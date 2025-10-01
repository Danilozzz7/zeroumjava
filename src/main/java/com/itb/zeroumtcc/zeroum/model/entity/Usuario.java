package com.zeroum.estagios.model.entity;

import com.zeroum.estagios.model.entity.enums.NivelAcesso;
import com.zeroum.estagios.model.entity.enums.StatusUsuario;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Usuario",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_usuario_email", columnNames = "email")
        })
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 100, nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = true)
    private NivelAcesso nivelAcesso; // ADMIN, ALUNO, EMPRESA

    @Lob
    @Column(name = "foto")
    private byte[] foto; // VARBINARY(MAX)

    @Column(nullable = false)
    private LocalDateTime dataCadastro;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private StatusUsuario statusUsuario; // ATIVO, INATIVO, TROCAR_SENHA

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public NivelAcesso getNivelAcesso() { return nivelAcesso; }
    public void setNivelAcesso(NivelAcesso nivelAcesso) { this.nivelAcesso = nivelAcesso; }

    public byte[] getFoto() { return foto; }
    public void setFoto(byte[] foto) { this.foto = foto; }

    public LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }

    public StatusUsuario getStatusUsuario() { return statusUsuario; }
    public void setStatusUsuario(StatusUsuario statusUsuario) { this.statusUsuario = statusUsuario; }
}