package com.itb.zeroumtcc.zeroum.model.repository;


import com.itb.zeroumtcc.zeroum.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}

