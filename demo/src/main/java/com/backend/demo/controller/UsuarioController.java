package com.backend.demo.controller;

import com.backend.demo.model.Usuario;
import com.backend.demo.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Usuario> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Usuario> buscarPorCpf(@PathVariable String cpf) {
        return service.buscarPorCpf(cpf)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usuario> salvar(@Valid @RequestBody Usuario usuario) {
        return ResponseEntity.ok(service.salvar(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @Valid @RequestBody Usuario usuario) {
        return service.buscarPorId(id)
                .map(u -> {
                    usuario.setId(id);
                    return ResponseEntity.ok(service.salvar(usuario));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(u -> {
                    service.deletar(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
