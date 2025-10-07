package com.itb.zeroumtcc.zeroum.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itb.zeroumtcc.zeroum.model.entity.Cadastro;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Long> {
}
