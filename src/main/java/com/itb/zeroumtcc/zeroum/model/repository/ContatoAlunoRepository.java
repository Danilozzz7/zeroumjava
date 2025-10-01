package com.itb.zeroumtcc.zeroum.model.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContatoAlunoRepository<ContatoAluno> extends JpaRepository<ContatoAluno, Integer> {

}
