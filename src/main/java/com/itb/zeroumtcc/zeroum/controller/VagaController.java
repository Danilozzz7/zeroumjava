package com.itb.zeroumtcc.zeroum.controller;

import com.itb.zeroumtcc.zeroum.model.entity.Vaga;
import com.itb.zeroumtcc.zeroum.model.repository.VagaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/vagas")
public class VagaController {

    private final VagaRepository repo;

    public VagaController(VagaRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Vaga> findAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vaga> findById(@PathVariable Integer id) {
        Optional<Vaga> vaga = repo.findById(id);
        return vaga.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Vaga> create(@RequestBody Vaga vaga) {
        Vaga saved = repo.save(vaga);
        return ResponseEntity.created(URI.create("/api/v1/vagas/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vaga> update(@PathVariable Integer id, @RequestBody Vaga vaga) {
        return repo.findById(id)
                .map(existing -> {
                    vaga.setId(existing.getId());
                    return ResponseEntity.ok(repo.save(vaga));
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
