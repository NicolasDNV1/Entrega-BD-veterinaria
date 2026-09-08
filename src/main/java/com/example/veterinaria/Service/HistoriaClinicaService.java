package com.example.veterinaria.Service;

import com.example.veterinaria.Entity.HistoriaClinica;

import java.util.List;
import java.util.Optional;

public interface HistoriaClinicaService {

    List <HistoriaClinica> listar();
    Optional buscarPorId(Long id);
    HistoriaClinica guardar(HistoriaClinica historiaClinica);
    HistoriaClinica actualizar(Long id, HistoriaClinica historiaClinica);
    void eliminar(Long id);
}
