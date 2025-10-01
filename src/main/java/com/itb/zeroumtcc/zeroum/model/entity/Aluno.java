package model.entity;


import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Aluno",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_aluno_rm", columnNames = "rm")
        })
public class Aluno {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        // FK para Usuario
        @ManyToOne(optional = false, fetch = FetchType.LAZY)
        @JoinColumn(name = "usuario_id", nullable = false,
                foreignKey = @ForeignKey(name = "fk_aluno_usuario"))
        private com.zeroum.estagios.model.entity.Usuario usuario;

        @Column(length = 100, nullable = false)
        private String nome;

        @Column(length = 10, nullable = false, unique = true)
        private String rm;

        @Column(length = 20, nullable = false)
        private String curso;

        @Column(length = 20, nullable = false)
        private String conclusao; // exemplo: "DEZEMBRO/2026"

        @Lob
        @Column(name = "curriculo")
        private byte[] curriculo;

        @Column(nullable = false)
        private LocalDate dataNascimento;

        @Column(nullable = false)
        private LocalDateTime dataCadastro;

        @Enumerated(EnumType.STRING)
        @Column(length = 20, nullable = false)
        private StatusAluno statusAluno;

        public Integer getId() { return id; }
        public void setId(Integer id) { this.id = id; }

        public com.zeroum.estagios.model.entity.Usuario getUsuario() { return usuario; }
        public void setUsuario(com.zeroum.estagios.model.entity.Usuario usuario) { this.usuario = usuario; }

        public String getNome() { return nome; }
        public void setNome(String nome) { this.nome = nome; }

        public String getRm() { return rm; }
        public void setRm(String rm) { this.rm = rm; }

        public String getCurso() { return curso; }
        public void setCurso(String curso) { this.curso = curso; }

        public String getConclusao() { return conclusao; }
        public void setConclusao(String conclusao) { this.conclusao = conclusao; }

        public byte[] getCurriculo() { return curriculo; }
        public void setCurriculo(byte[] curriculo) { this.curriculo = curriculo; }

        public LocalDate getDataNascimento() { return dataNascimento; }
        public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

        public LocalDateTime getDataCadastro() { return dataCadastro; }
        public void setDataCadastro(LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }

        public StatusAluno getStatusAluno() { return statusAluno; }
        public void setStatusAluno(StatusAluno statusAluno) { this.statusAluno = statusAluno; }
}