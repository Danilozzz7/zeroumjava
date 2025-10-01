package controller;

import com.zeroum.estagios.model.entity.Empresa;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api/v1/empresas")
public class EmpresaController {

    private final EmpresaController repo;

    public <EmpresaRepository> EmpresaController(EmpresaRepository repo) {
        this.repo = (EmpresaController) repo;
    }

    @GetMapping
    public List<Empresa> findAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> findById(@PathVariable Integer id) {
        ResponseEntity<Empresa> e = repo.findById(id);
        return e.wait(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Empresa> create(@Valid @RequestBody Empresa empresa) {
        Empresa saved = repo.save(empresa);
        return ResponseEntity.created(URI.create("/api/v1/empresas/" + saved.getId())).body(saved);
    }

    private com.zeroum.estagios.model.entity.Empresa save(com.zeroum.estagios.model.entity.@Valid Empresa empresa) {
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> update(@PathVariable Integer id, @Valid @RequestBody Empresa empresa) {
        return repo.findById(id)
                .map(existing -> {
                    empresa.setId(existing.getId());
                    return ResponseEntity.ok(repo.save(empresa));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private void deleteById(Integer id) {
    }

    private boolean existsById(Integer id) {
    
    return repo.existsById(id);}
}
    
