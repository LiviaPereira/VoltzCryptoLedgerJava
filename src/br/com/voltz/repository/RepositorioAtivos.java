package br.com.voltz.repository;

import br.com.voltz.model.Ativo;
import java.util.*;

public class RepositorioAtivos {
    private final Map<Integer, Ativo> ativos = new HashMap<>();

    public void salvar(Ativo a) { ativos.put(a.getId(), a); }
    public Optional<Ativo> porId(int id) { return Optional.ofNullable(ativos.get(id)); }
    public List<Ativo> listar() { return new ArrayList<>(ativos.values()); }
    public void remover(int id) { ativos.remove(id); }
}
