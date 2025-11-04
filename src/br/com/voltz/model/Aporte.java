package br.com.voltz.model;

import java.time.LocalDate;


public class Aporte extends EntidadeBase {
    private int empresaId;
    private int ativoId;
    private LocalDate data;
    private double quantidade;
    private double precoUnitario;
    private double taxa;

    public Aporte(int id, int empresaId, int ativoId, LocalDate data,
                  double quantidade, double precoUnitario, double taxa) {
        super(id);
        setEmpresaId(empresaId);
        setAtivoId(ativoId);
        setData(data);
        setQuantidade(quantidade);
        setPrecoUnitario(precoUnitario);
        setTaxa(taxa);
    }

    public int getEmpresaId() { return empresaId; }
    public void setEmpresaId(int empresaId) { this.empresaId = empresaId; }

    public int getAtivoId() { return ativoId; }
    public void setAtivoId(int ativoId) { this.ativoId = ativoId; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public double getQuantidade() { return quantidade; }
    public void setQuantidade(double quantidade) {
        if (quantidade <= 0) throw new IllegalArgumentException("Quantidade deve ser > 0");
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() { return precoUnitario; }
    public void setPrecoUnitario(double precoUnitario) {
        if (precoUnitario <= 0) throw new IllegalArgumentException("Preço unitário deve ser > 0");
        this.precoUnitario = precoUnitario;
    }

    public double getTaxa() { return taxa; }
    public void setTaxa(double taxa) { this.taxa = Math.max(0, taxa); }

    public double getValorTotal() { return quantidade * precoUnitario + taxa; }

    @Override
    public String descrever() {
        return "Aporte{id=" + id + ", empresaId=" + empresaId + ", ativoId=" + ativoId + ", data=" + data +
                ", qtd=" + quantidade + ", preco=" + precoUnitario + ", taxa=" + taxa + "}";
    }
}
