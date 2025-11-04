package br.com.voltz.repository;

import br.com.voltz.model.Favorito;
import java.util.*;
import java.util.stream.Collectors;

public class RepositorioFavoritos {
    private final Set<String> chaves = new HashSet<>();
    private final List<Favorito> favoritos = new ArrayList<>();

    private String key(int empresaId, int ativoId) { return empresaId + "_" + ativoId; }

    public void salvar(Favorito f) {
        String k = key(f.getEmpresaId(), f.getAtivoId());
        if (!chaves.contains(k)) {
            chaves.add(k);
            favoritos.add(f);
        }
    }

    public List<Favorito> listarPorEmpresa(int empresaId) {
        return favoritos.stream().filter(f -> f.getEmpresaId() == empresaId).collect(Collectors.toList());
    }

    public void remover(int empresaId, int ativoId) {
        String k = key(empresaId, ativoId);
        favoritos.removeIf(f -> key(f.getEmpresaId(), f.getAtivoId()).equals(k));
        chaves.remove(k);
    }
}
