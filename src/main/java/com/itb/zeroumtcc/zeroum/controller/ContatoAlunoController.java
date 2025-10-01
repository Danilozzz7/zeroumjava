package controller;

import jakarta.validation.Valid;
import model.repository.ContatoAlunoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;



@RestController
    @RequestMapping("/api/v1/contatos-aluno")
    public class ContatoAlunoController {

        private ContatoAlunoRepository repo;

        public void contatoAlunoController(ContatoAlunoRepository repo) {
            this.repo = repo;
        }

        public ContatoAlunoController(ContatoAlunoRepository repo) {
            this.repo = repo;
        }

        @GetMapping
        public List<com.zeroum.estagios.model.entity.ContatoAluno> findAll() {
            return repo.findAll();
        }

        @GetMapping("/{id}")
        public ResponseEntity<com.zeroum.estagios.model.entity.ContatoAluno> findById(@PathVariable Integer id) {
            Optional<com.zeroum.estagios.model.entity.ContatoAluno> c = repo.findById(id);
            return c.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        @PostMapping
        public ResponseEntity<com.zeroum.estagios.model.entity.ContatoAluno> create(@Valid @RequestBody com.zeroum.estagios.model.entity.ContatoAluno contato) {
            com.zeroum.estagios.model.entity.ContatoAluno saved = repo.save(contato);
            return ResponseEntity.created(URI.create("/api/v1/contatos-aluno/" + saved.getId())).body(saved);
        }

        @PutMapping("/{id}")
        public ResponseEntity<com.zeroum.estagios.model.entity.ContatoAluno> update(@PathVariable Integer id, @Valid @RequestBody com.zeroum.estagios.model.entity.ContatoAluno contato) {
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

