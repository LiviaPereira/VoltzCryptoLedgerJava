package br.com.voltz;

import br.com.voltz.model.*;
import br.com.voltz.repository.*;
import br.com.voltz.service.PortfolioService;

import java.time.LocalDate;
import java.util.*;

public class App {
    public static void main(String[] args) {
        try {
            RepositorioEmpresas repEmpresas = new RepositorioEmpresas();
            RepositorioAtivos repAtivos = new RepositorioAtivos();
            RepositorioAportes repAportes = new RepositorioAportes();
            RepositorioCotacoes repCotacoes = new RepositorioCotacoes();
            RepositorioFavoritos repFavoritos = new RepositorioFavoritos();

            Empresa emp1 = new Empresa(1, "Patinhas Inc.", "00.000.000/0001-00");
            repEmpresas.salvar(emp1);

            Ativo btc = new Ativo(1, "BTC", "Bitcoin");
            Ativo eth = new Ativo(2, "ETH", "Ethereum");
            repAtivos.salvar(btc);
            repAtivos.salvar(eth);

            // Associativa PK composta
            repFavoritos.salvar(new Favorito(emp1.getId(), btc.getId(), "Acompanhar volatilidade"));
            repFavoritos.salvar(new Favorito(emp1.getId(), eth.getId()));

            // Associativa com atributos
            repAportes.salvar(new Aporte(1, emp1.getId(), btc.getId(), LocalDate.now().minusDays(10), 0.05, 300000.0, 0.0));
            repAportes.salvar(new Aporte(2, emp1.getId(), btc.getId(), LocalDate.now().minusDays(5),  0.02, 320000.0, 2.5));
            repAportes.salvar(new Aporte(3, emp1.getId(), eth.getId(), LocalDate.now().minusDays(8),  0.7, 15000.0,  0.0));

            repCotacoes.salvar(new CotacaoDiaria(btc.getId(), LocalDate.now().minusDays(1), 315000.0));
            repCotacoes.salvar(new CotacaoDiaria(eth.getId(), LocalDate.now().minusDays(1), 15500.0));

            PortfolioService svc = new PortfolioService(repAportes, repCotacoes);

            // Overloads
            List<PortfolioItem> carteira1 = svc.consolidarPorEmpresa(emp1.getId());
            Map<Integer, Double> override = new HashMap<>();
            override.put(btc.getId(), 310000.0);
            List<PortfolioItem> carteira2 = svc.consolidarPorEmpresa(emp1.getId(), override);
            List<PortfolioItem> carteira3 = svc.consolidarPorEmpresa(emp1.getId(), 200000.0);

            System.out.println("--- Carteira (sem override) ---");
            carteira1.forEach(pi -> System.out.println(pi.descrever()));

            System.out.println("\n--- Carteira (override BTC=310k) ---");
            carteira2.forEach(System.out::println);

            System.out.println("\n--- Carteira (preço padrão=200k) ---");
            carteira3.forEach(pi -> System.out.println(pi.descrever()));

        } catch (Exception ex) {
            System.err.println("Erro ao executar a aplicação: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
