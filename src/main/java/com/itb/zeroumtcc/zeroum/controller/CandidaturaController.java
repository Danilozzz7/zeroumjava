package com.itb.zeroumtcc.zeroum.controller;
import com.itb.zeroumtcc.zeroum.model.entity.Candidatura;
import com.itb.zeroumtcc.zeroum.model.entity.ContatoAluno;
import com.itb.zeroumtcc.zeroum.model.repository.CandidaturaRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/candidaturas")
public class CandidaturaController {

    private final CandidaturaRepository repo;

    // Construtor para injeção de dependência do repositório
    public CandidaturaController(CandidaturaRepository repo) {
        this.repo = repo;
    }

    // Método para retornar todas as candidaturas
    @GetMapping
    public List<Candidatura> findAll() {
        return repo.findAll();
    }

    // Método para retornar candidatura pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Candidatura> findById(@PathVariable Integer id) {
        Optional<Candidatura> c = repo.findById(id);
        return c.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Método para criar uma nova candidatura
    @PostMapping
    public ResponseEntity<Candidatura> create(@Valid @RequestBody Candidatura candidatura) {
        Candidatura saved = (Candidatura) repo.save(candidatura); // Removido o cast
        return ResponseEntity.created(URI.create("/api/v1/candidaturas/" + saved.getId())).body(saved);
    }

    // Método para atualizar uma candidatura existente
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @Valid @RequestBody Candidatura candidatura) {
        /*return repo.findById(id)
                .map(existing -> {
                    candidatura.setId(existing.getId());
                    return ResponseEntity.ok(repo.save(candidatura));
                }).orElseGet(() -> ResponseEntity.notFound().build());

         */


        Candidatura CandidaturaBd = (Candidatura) repo.findById(id).get();
        return ResponseEntity.ok(repo.save(CandidaturaBd));

    }

    // Método para excluir uma candidatura
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
