package com.example.veterinaria.Service;

import com.example.veterinaria.Entity.Mascota;

import java.util.List;
import java.util.Optional;

public interface MascotaService {

    List <Mascota> listar();
    Optional buscarPorId(Long id);
    Mascota guardar(Mascota mascota);
    Mascota actualizar(Long id, Mascota mascota);
    void eliminar(Long id);
}
