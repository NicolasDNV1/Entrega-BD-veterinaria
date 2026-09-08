package com.example.veterinaria.Controller;

import com.example.veterinaria.Entity.HistoriaClinica;
import com.example.veterinaria.Service.HistoriaClinicaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historiaclinica")
public class HistoriaClinicaController {

    private final HistoriaClinicaService historiaClinicaService;

    public HistoriaClinicaController(HistoriaClinicaService historiaClinicaService) {
        this.historiaClinicaService = historiaClinicaService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<HistoriaClinica>> listar() {
        return ResponseEntity.ok(historiaClinicaService.listar());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<HistoriaClinica> buscarPorId(@PathVariable Long id) {
        return (ResponseEntity<HistoriaClinica>) historiaClinicaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/guardar")
    public ResponseEntity<HistoriaClinica> guardar(@RequestBody HistoriaClinica historiaClinica) {
        HistoriaClinica nueva = historiaClinicaService.guardar(historiaClinica);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<HistoriaClinica> actualizar(@PathVariable Long id, @RequestBody HistoriaClinica historiaClinica) {
        HistoriaClinica actualizada = historiaClinicaService.actualizar(id, historiaClinica);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        historiaClinicaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}