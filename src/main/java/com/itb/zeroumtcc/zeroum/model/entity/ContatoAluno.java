package com.itb.zeroumtcc.zeroum.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ContatoAluno")
public class ContatoAluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // FK para Aluno
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_contato_aluno"))
    private Aluno aluno;

    @Column(length = 50, nullable = false)
    private String nomeContato;

    @Column(length = 200, nullable = false)
    private String link;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Aluno getAluno() { return aluno; }
    public void setAluno(Aluno aluno) { this.aluno = aluno; }

    public String getNomeContato() { return nomeContato; }
    public void setNomeContato(String nomeContato) { this.nomeContato = nomeContato; }

    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }
}