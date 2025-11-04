package br.com.voltz.repository;

import br.com.voltz.model.Aporte;
import java.util.*;
import java.util.stream.Collectors;

public class RepositorioAportes {
    private final Map<Integer, Aporte> aportes = new HashMap<>();

    public void salvar(Aporte a) { aportes.put(a.getId(), a); }
    public Optional<Aporte> porId(int id) { return Optional.ofNullable(aportes.get(id)); }
    public List<Aporte> listar() { return new ArrayList<>(aportes.values()); }
    public void remover(int id) { aportes.remove(id); }

    public List<Aporte> porEmpresaEAtivo(int empresaId, int ativoId) {
        return aportes.values().stream()
                .filter(a -> a.getEmpresaId() == empresaId && a.getAtivoId() == ativoId)
                .sorted(Comparator.comparing(Aporte::getData))
                .collect(Collectors.toList());
    }

    // Overload: só por empresa (polimorfismo estático adicional)
    public List<Aporte> porEmpresa(int empresaId) {
        return aportes.values().stream()
                .filter(a -> a.getEmpresaId() == empresaId)
                .sorted(Comparator.comparing(Aporte::getData))
                .collect(Collectors.toList());
    }
}
