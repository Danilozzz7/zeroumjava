package com.itb.zeroumtcc.zeroum.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itb.zeroumtcc.zeroum.model.entity.Cadastro;
import com.itb.zeroumtcc.zeroum.model.repository.CadastroRepository;

@Service
public class CadastroService {

    @Autowired
    private CadastroRepository cadastroRepository;

    public Cadastro save(Cadastro cadastro) {
        return cadastroRepository.save(cadastro);
    }

    public List<Cadastro> findAll() {
        return cadastroRepository.findAll();
    }

    public Optional<Cadastro> findById(Long rm) {
        return cadastroRepository.findById(rm);
    }

    public Cadastro update(Long rm, Cadastro cadastroAtualizado) {
        Optional<Cadastro> cadastroExistente = cadastroRepository.findById(rm);

        if (cadastroExistente.isPresent()) {
            Cadastro cadastro = cadastroExistente.get();
            cadastro.setNome(cadastroAtualizado.getNome());
            cadastro.setSenha(cadastroAtualizado.getSenha());
            cadastro.setRm(cadastroAtualizado.getRm());
            return cadastroRepository.save(cadastro);
        } else {
            return null;
        }
    }

    public boolean delete(Long rm) {
        if (cadastroRepository.existsById(rm)) {
            cadastroRepository.deleteById(rm);
            return true;
        }
        return false;
    }
}