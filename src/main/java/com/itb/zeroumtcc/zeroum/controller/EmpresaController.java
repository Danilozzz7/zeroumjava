package com.itb.zeroumtcc.zeroum.controller;

import com.itb.zeroumtcc.zeroum.model.entity.Empresa;
import com.itb.zeroumtcc.zeroum.model.repository.EmpresaRepository; // Assumindo que exista
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/empresas")
public class EmpresaController {

    private final EmpresaRepository repo;

    public EmpresaController(EmpresaRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Empresa> findAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> findById(@PathVariable Integer id) {
        Optional<Empresa> empresa = repo.findById(id);
        return empresa.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Empresa> create(@RequestBody Empresa empresa) {
        Empresa saved = repo.save(empresa);
        return ResponseEntity.created(URI.create("/api/v1/empresas/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> update(@PathVariable Integer id, @RequestBody Empresa empresa) {
        return repo.findById(id)
                .map(existing -> {
                    empresa.setId(existing.getId());
                    Empresa updated = repo.save(empresa);
                    return ResponseEntity.ok(updated);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
