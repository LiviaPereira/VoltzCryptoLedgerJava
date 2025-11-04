package br.com.voltz.model;

import java.time.LocalDate;

public class CotacaoDiaria {

    private int ativoId;
    private LocalDate data;
    private double precoFechamento;

    public CotacaoDiaria(int ativoId, LocalDate data, double precoFechamento) {
        setAtivoId(ativoId);
        setData(data);
        setPrecoFechamento(precoFechamento);
    }

    public int getAtivoId() { return ativoId; }
    public void setAtivoId(int ativoId) { this.ativoId = ativoId; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public double getPrecoFechamento() { return precoFechamento; }
    public void setPrecoFechamento(double precoFechamento) {
        if (precoFechamento <= 0) throw new IllegalArgumentException("Preço deve ser > 0");
        this.precoFechamento = precoFechamento;
    }
}
