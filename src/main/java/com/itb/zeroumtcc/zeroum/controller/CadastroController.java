package com.itb.zeroumtcc.zeroum.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.itb.zeroumtcc.zeroum.model.entity.Cadastro;
import com.itb.zeroumtcc.zeroum.model.service.CadastroService;

@RestController
@RequestMapping("/api/v1/cadastro")
public class CadastroController {

    @Autowired
    private CadastroService cadastroService;

    // GET - listar todos
    @GetMapping
    public List<Cadastro> listarTodos() {
        return cadastroService.findAll();
    }

    // GET - buscar por RM
    @GetMapping("/{rm}")
    public Optional<Cadastro> buscarPorRm(@PathVariable Long rm) {
        return cadastroService.findById(rm);
    }

    // POST - criar novo cadastro
    @PostMapping
    public Cadastro criar(@RequestBody Cadastro cadastro) {
        return cadastroService.save(cadastro);
    }

    // PUT - atualizar cadastro
    @PutMapping("/{rm}")
    public Cadastro atualizar(@PathVariable Long rm, @RequestBody Cadastro cadastro) {
        return cadastroService.update(rm, cadastro);
    }

    // DELETE - excluir cadastro
    @DeleteMapping("/{rm}")
    public String deletar(@PathVariable Long rm) {
        boolean removido = cadastroService.delete(rm);
        return removido ? "Cadastro removido com sucesso!" : "Cadastro não encontrado.";
    }
}