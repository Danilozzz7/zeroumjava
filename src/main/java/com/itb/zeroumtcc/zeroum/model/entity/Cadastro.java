package com.itb.zeroumtcc.zeroum.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Cadastro")
public class Cadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private Long rm;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String senha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRm() {
        return rm;
    }

    public void setRm(Long rm) {
        this.rm = rm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
