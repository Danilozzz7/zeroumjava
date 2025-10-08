package com.itb.zeroumtcc.zeroum.model.repository;

import com.itb.zeroumtcc.zeroum.model.entity.Candidatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidaturaRepository extends JpaRepository<Candidatura, Integer> {

}

