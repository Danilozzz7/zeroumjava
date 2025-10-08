package com.itb.zeroumtcc.zeroum.model.repository;

import com.itb.zeroumtcc.zeroum.model.entity.ContatoAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoAlunoRepository extends JpaRepository<ContatoAluno, Integer> {

}
