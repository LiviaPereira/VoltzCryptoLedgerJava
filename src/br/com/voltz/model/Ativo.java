package br.com.voltz.model;

public class Ativo extends EntidadeBase {
    private String ticker;
    private String nome;

    public Ativo(int id, String ticker, String nome) {
        super(id);
        this.ticker = ticker;
        this.nome = nome;
    }

    public String getTicker() { return ticker; }
    public void setTicker(String ticker) { this.ticker = ticker; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    @Override
    public String toString() { return "Ativo{id=" + id + ", ticker='" + ticker + "', nome='" + nome + "'}"; }
    @Override
    public String descrever() { return "Ativo: " + ticker + " - " + nome; }
}
