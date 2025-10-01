package com.itb.zeroumtcc.zeroum.model.repository;
import com.itb.zeroumtcc.zeroum.model.entity.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Integer> {

}
