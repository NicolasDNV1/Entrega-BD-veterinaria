package com.example.veterinaria.Service.Serviceimpl;

import com.example.veterinaria.Entity.Propietario;
import com.example.veterinaria.Repository.PropietarioRepository;
import com.example.veterinaria.Service.PropietarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropietarioServiceImpl implements PropietarioService {

    private final PropietarioRepository propietarioRepository;

    public PropietarioServiceImpl(PropietarioRepository propietarioRepository) {
        this.propietarioRepository = propietarioRepository;
    }

    @Override
    public List<Propietario> listar() {
        return propietarioRepository.findAll();
    }

    @Override
    public Optional <Propietario>   buscarPorId(Long id) {
        return propietarioRepository.findById(id);
    }

    @Override
    public Propietario guardar(Propietario propietario) {
        return propietarioRepository.save(propietario);
    }

    @Override
    public Propietario actualizar(Long id, Propietario propietario) {
        Propietario existente = propietarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Propietario no encontrado con id " + id));

        existente.setNombre(propietario.getNombre());
        existente.setDocumento(propietario.getDocumento());
        existente.setTelefono(propietario.getTelefono());
        existente.setCorreo(propietario.getCorreo());

        return propietarioRepository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        propietarioRepository.deleteById(id);
    }
}