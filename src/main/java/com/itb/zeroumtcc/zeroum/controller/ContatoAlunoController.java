package com.itb.zeroumtcc.zeroum.controller;

import com.itb.zeroumtcc.zeroum.model.entity.ContatoAluno;
import com.itb.zeroumtcc.zeroum.model.repository.ContatoAlunoRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/contatos-aluno")
public class ContatoAlunoController {

    private final ContatoAlunoRepository repo;

    public ContatoAlunoController(ContatoAlunoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<ContatoAluno> findAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContatoAluno> findById(@PathVariable Integer id) {
        Optional<ContatoAluno> c = repo.findById(id);
        return c.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ContatoAluno> create(@Valid @RequestBody ContatoAluno contato) {
        ContatoAluno saved = (ContatoAluno) repo.save(contato);
        return ResponseEntity.created(URI.create("/api/v1/contatos-aluno/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContatoAluno> update(@PathVariable Integer id, @Valid @RequestBody ContatoAluno contato) {
        return repo.findById(id)
                .map(existing -> {
                    contato.setId(existing.getId());
                    return ResponseEntity.ok(repo.save(contato));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
