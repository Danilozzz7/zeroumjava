package com.itb.zeroumtcc.zeroum.model.repository;

import com.itb.zeroumtcc.zeroum.model.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

}
