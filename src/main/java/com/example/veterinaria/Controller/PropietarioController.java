package com.example.veterinaria.Controller;

import com.example.veterinaria.Entity.Propietario;
import com.example.veterinaria.Service.PropietarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/propietario")
public class PropietarioController {

    private final PropietarioService propietarioService;

    public PropietarioController(PropietarioService propietarioService) {
        this.propietarioService = propietarioService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Propietario>> listar() {
        return ResponseEntity.ok(propietarioService.listar());
    }

    @GetMapping("/buscar/{id}")
    public Optional buscarPorId(@PathVariable Long id) {
        return propietarioService.buscarPorId(id);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Propietario> guardar(@RequestBody Propietario propietario) {
        Propietario nuevo = propietarioService.guardar(propietario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Propietario> actualizar(@PathVariable Long id, @RequestBody Propietario propietario) {
        Propietario actualizado = propietarioService.actualizar(id, propietario);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        propietarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}