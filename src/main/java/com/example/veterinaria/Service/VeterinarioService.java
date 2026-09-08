package com.example.veterinaria.Service;

import com.example.veterinaria.Entity.Veterinario;

import java.util.List;
import java.util.Optional;

public interface VeterinarioService {

    List<Veterinario> listar();
    Optional<Veterinario> buscarPorId(Long id);
    Veterinario guardar(Veterinario veterinario);
    Veterinario actualizar(Long id, Veterinario veterinario);
    void eliminar(Long id);
}