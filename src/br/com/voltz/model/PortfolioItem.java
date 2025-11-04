package br.com.voltz.model;

public class PortfolioItem implements Imprimivel {
    private int empresaId;
    private int ativoId;
    private double quantidadeTotal;
    private double precoMedio;
    private double precoMercado;

    public PortfolioItem(int empresaId, int ativoId, double quantidadeTotal, double precoMedio, double precoMercado) {
        this.empresaId = empresaId;
        this.ativoId = ativoId;
        this.quantidadeTotal = quantidadeTotal;
        this.precoMedio = precoMedio;
        this.precoMercado = precoMercado;
    }

    public int getEmpresaId() { return empresaId; }
    public void setEmpresaId(int empresaId) { this.empresaId = empresaId; }
    public int getAtivoId() { return ativoId; }
    public void setAtivoId(int ativoId) { this.ativoId = ativoId; }
    public double getQuantidadeTotal() { return quantidadeTotal; }
    public void setQuantidadeTotal(double quantidadeTotal) { this.quantidadeTotal = quantidadeTotal; }
    public double getPrecoMedio() { return precoMedio; }
    public void setPrecoMedio(double precoMedio) { this.precoMedio = precoMedio; }
    public double getPrecoMercado() { return precoMercado; }
    public void setPrecoMercado(double precoMercado) { this.precoMercado = precoMercado; }

    public double getValorMercado() { return quantidadeTotal * precoMercado; }
    public double getValorInvestido() { return quantidadeTotal * precoMedio; }
    public double getPL() { return getValorMercado() - getValorInvestido(); }

    @Override
    public String toString() {
        return "PortfolioItem{empresaId=" + empresaId + ", ativoId=" + ativoId +
                ", qtd=" + quantidadeTotal + ", precoMedio=" + precoMedio +
                ", precoMercado=" + precoMercado + ", PL=" + getPL() + "}";
    }

    @Override
    public String descrever() { return toString(); }
}
