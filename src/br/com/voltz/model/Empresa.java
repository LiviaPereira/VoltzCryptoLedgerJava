package br.com.voltz.model;

public class Empresa extends EntidadeBase {
    private String nome;
    private String cnpj;
    private boolean ativa = true;

    public Empresa(int id, String nome, String cnpj) {
        super(id);
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    public boolean isAtiva() { return ativa; }
    public void setAtiva(boolean ativa) { this.ativa = ativa; }

    @Override
    public String toString() {
        return "Empresa{id=" + id + ", nome='" + nome + "', cnpj='" + cnpj + "', ativa=" + ativa + "}";
    }

    @Override
    public String descrever() { return "Empresa: " + nome + " (" + cnpj + ")"; }
}
