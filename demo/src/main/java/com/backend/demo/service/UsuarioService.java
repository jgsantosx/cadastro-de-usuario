package com.backend.demo.service;

import com.backend.demo.model.Usuario;
import com.backend.demo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Optional<Usuario> buscarPorCpf(String cpf) {
        return repository.findByCpf(cpf);
    }

    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
