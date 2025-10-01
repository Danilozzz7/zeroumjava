package model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
package com.zeroum.estagios.model.entity;

import com.zeroum.estagios.model.entity.enums.StatusCandidatura;
import jakarta.persistence.*;
import java.time.LocalDateTime;
public class Candidatura {
    public <candidatura> candidatura getId() {
    }

    public void setId(Object id) {
    }

    @Entity
    @Table(name = "Candidatura")
    public class Candidatura {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        // FK para Aluno
        @ManyToOne(optional = false, fetch = FetchType.LAZY)
        @JoinColumn(name = "aluno_id", nullable = false,
                foreignKey = @ForeignKey(name = "fk_candidatura_aluno"))
        private Aluno aluno;

        // FK para Vaga
        @ManyToOne(optional = false, fetch = FetchType.LAZY)
        @JoinColumn(name = "vaga_id", nullable = false,
                foreignKey = @ForeignKey(name = "fk_candidatura_vaga"))
        private Vaga vaga;

        @Column(name = "data_cadastro", nullable = false)
        private LocalDateTime dataCadastro;

        @Enumerated(EnumType.STRING)
        @Column(name = "status_candidatura", length = 20, nullable = false)
        private StatusCandidatura statusCandidatura;

        public Integer getId() { return id; }
        public void setId(Integer id) { this.id = id; }

        public Aluno getAluno() { return aluno; }
        public void setAluno(Aluno aluno) { this.aluno = aluno; }

        public Vaga getVaga() { return vaga; }
        public void setVaga(Vaga vaga) { this.vaga = vaga; }

        public LocalDateTime getDataCadastro() { return dataCadastro; }
        public void setDataCadastro(LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }

        public StatusCandidatura getStatusCandidatura() { return statusCandidatura; }
        public void setStatusCandidatura(StatusCandidatura statusCandidatura) { this.statusCandidatura = statusCandidatura; }
    }
}
