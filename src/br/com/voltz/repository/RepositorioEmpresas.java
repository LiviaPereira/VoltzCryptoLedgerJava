package br.com.voltz.repository;

import br.com.voltz.model.Empresa;
import java.util.*;

public class RepositorioEmpresas {
    private final Map<Integer, Empresa> empresas = new HashMap<>();

    public void salvar(Empresa e) { empresas.put(e.getId(), e); }
    public Optional<Empresa> porId(int id) { return Optional.ofNullable(empresas.get(id)); }
    public List<Empresa> listar() { return new ArrayList<>(empresas.values()); }
    public void remover(int id) { empresas.remove(id); }
}
