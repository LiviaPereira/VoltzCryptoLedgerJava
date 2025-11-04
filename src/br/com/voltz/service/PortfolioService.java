package br.com.voltz.service;

import br.com.voltz.model.Aporte;
import br.com.voltz.model.PortfolioItem;
import br.com.voltz.repository.RepositorioAportes;
import br.com.voltz.repository.RepositorioCotacoes;

import java.util.*;
import java.util.stream.Collectors;

public class PortfolioService {
    private final RepositorioAportes repoAportes;
    private final RepositorioCotacoes repoCotacoes;

    public PortfolioService(RepositorioAportes repoAportes, RepositorioCotacoes repoCotacoes) {
        this.repoAportes = repoAportes;
        this.repoCotacoes = repoCotacoes;
    }


    public List<PortfolioItem> consolidarPorEmpresa(int empresaId) {
        return consolidarPorEmpresa(empresaId, Collections.emptyMap());
    }


    public List<PortfolioItem> consolidarPorEmpresa(int empresaId, Map<Integer, Double> precosMercadoOverride) {
        Map<Integer, List<Aporte>> porAtivo = repoAportes.porEmpresa(empresaId).stream()
                .collect(Collectors.groupingBy(Aporte::getAtivoId));

        List<PortfolioItem> itens = new ArrayList<>();
        for (Map.Entry<Integer, List<Aporte>> e : porAtivo.entrySet()) {
            int ativoId = e.getKey();
            List<Aporte> aportes = e.getValue();

            double quantidade = aportes.stream().mapToDouble(Aporte::getQuantidade).sum();
            double valorTotal = aportes.stream().mapToDouble(Aporte::getValorTotal).sum();
            double precoMedio = quantidade > 0 ? valorTotal / quantidade : 0.0;

            double precoMercado;
            if (precosMercadoOverride != null && precosMercadoOverride.containsKey(ativoId)) {
                precoMercado = precosMercadoOverride.get(ativoId);
            } else {
                precoMercado = repoCotacoes.ultimaPorAtivo(ativoId).map(c -> c.getPrecoFechamento()).orElse(precoMedio);
            }
            itens.add(new PortfolioItem(empresaId, ativoId, quantidade, precoMedio, precoMercado));
        }
        return itens;
    }


    public List<PortfolioItem> consolidarPorEmpresa(int empresaId, double precoPadrao) {
        List<PortfolioItem> base = consolidarPorEmpresa(empresaId);
        for (PortfolioItem item : base) item.setPrecoMercado(precoPadrao);
        return base;
    }
}
