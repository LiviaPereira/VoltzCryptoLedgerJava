package br.com.voltz.model;


public class Favorito implements Imprimivel {
    private int empresaId;
    private int ativoId;
    private String observacao; // opcional

    public Favorito(int empresaId, int ativoId) { this(empresaId, ativoId, ""); }

    public Favorito(int empresaId, int ativoId, String observacao) {
        this.empresaId = empresaId;
        this.ativoId = ativoId;
        this.observacao = observacao;
    }

    public int getEmpresaId() { return empresaId; }
    public void setEmpresaId(int empresaId) { this.empresaId = empresaId; }
    public int getAtivoId() { return ativoId; }
    public void setAtivoId(int ativoId) { this.ativoId = ativoId; }
    public String getObservacao() { return observacao; }
    public void setObservacao(String observacao) { this.observacao = observacao; }

    @Override
    public String descrever() {
        return "Favorito{empresaId=" + empresaId + ", ativoId=" + ativoId + ", obs='" + observacao + "'}";
    }
}
