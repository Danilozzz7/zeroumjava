package controller;
import model.entity.Candidatura;
import model.repository.CandidaturaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.Optional;
import java.util.List;

    @RestController

    @RequestMapping("/api/v1/candidaturas")

    public class CandidaturaController {

        private final CandidaturaRepository repo;

        public CandidaturaController(CandidaturaRepository repo) {

            this.repo = repo;

        }

        @GetMapping

        public List<Candidatura> findAll() {

            return repo.findAll();

        }

        @GetMapping("/{id}")

        public ResponseEntity<Candidatura> findById(@PathVariable Integer id) {

            Optional<Candidatura> c = repo.findById(id);

            return c.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

        }

        @PostMapping

        public ResponseEntity<Candidatura> create(@Valid @RequestBody Candidatura candidatura) {

            Candidatura saved = repo.save(candidatura);

            return ResponseEntity.created(URI.create("/api/v1/candidaturas/" + saved.getId())).body(saved);

        }

        @PutMapping("/{id}")

        public ResponseEntity<Candidatura> update(@PathVariable Integer id, @Valid @RequestBody Candidatura candidatura) {

            return repo.findById(id)

                    .map(existing -> {

                        candidatura.setId(existing.getId());

                        return ResponseEntity.ok(repo.save(candidatura));

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



