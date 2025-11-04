package br.com.voltz.repository;

import br.com.voltz.model.CotacaoDiaria;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class RepositorioCotacoes {
    private final List<CotacaoDiaria> cotacoes = new ArrayList<>();

    public void salvar(CotacaoDiaria c) { cotacoes.add(c); }
    public List<CotacaoDiaria> listar() { return new ArrayList<>(cotacoes); }

    public Optional<CotacaoDiaria> ultimaPorAtivo(int ativoId) {
        return cotacoes.stream()
                .filter(c -> c.getAtivoId() == ativoId)
                .max(Comparator.comparing(CotacaoDiaria::getData));
    }

    public List<CotacaoDiaria> porAtivoIntervalo(int ativoId, LocalDate ini, LocalDate fim) {
        return cotacoes.stream()
                .filter(c -> c.getAtivoId() == ativoId && !c.getData().isBefore(ini) && !c.getData().isAfter(fim))
                .sorted(Comparator.comparing(CotacaoDiaria::getData))
                .collect(Collectors.toList());
    }
}
