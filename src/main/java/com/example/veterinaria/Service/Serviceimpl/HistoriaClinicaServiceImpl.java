package com.example.veterinaria.Service.Serviceimpl;

import com.example.veterinaria.Entity.HistoriaClinica;
import com.example.veterinaria.Repository.HistoriaClinicaRepository;
import com.example.veterinaria.Service.HistoriaClinicaService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class HistoriaClinicaServiceImpl implements HistoriaClinicaService {

    private final HistoriaClinicaRepository historiaClinicaRepository;   // (1)

    public HistoriaClinicaServiceImpl(HistoriaClinicaRepository historiaClinicaRepository) {  // (2)
        this.historiaClinicaRepository = historiaClinicaRepository;   // (3)
    }

    @Override
    public List<HistoriaClinica> listar() {
        return historiaClinicaRepository.findAll();   // (4)
    }

    @Override
    public Optional<HistoriaClinica> buscarPorId(Long id) {
        return historiaClinicaRepository.findById(id);   // (5)
    }

    @Override
    public HistoriaClinica guardar(HistoriaClinica historiaClinica) {
        return historiaClinicaRepository.save(historiaClinica);   // (6)
    }

    @Override
    public HistoriaClinica actualizar(Long id, HistoriaClinica historiaClinica) {
        HistoriaClinica existente = historiaClinicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Historia clínica no encontrada con id " + id));

        existente.setFecha_apertura(historiaClinica.getFecha_apertura());   // (7) fechaApertura
        existente.setAntecedentes(historiaClinica.getAntecedentes());   // (8) antecedentes
        existente.setObservaciones(historiaClinica.getObservaciones());   // (9) observaciones

        return historiaClinicaRepository.save(existente);   // (10)
    }

    @Override
    public void eliminar(Long id) {
        historiaClinicaRepository.deleteById(id);   // (11)
    }
}