package com.itb.zeroumtcc.zeroum.model.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.zeroum.estagios.model.entity.enums.StatusVaga;

@Entity
@Table(name = "Vaga")
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // FK para Empresa
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id", nullable = false, foreignKey = @ForeignKey(name = "fk_vaga_empresa"))
    private Empresa empresa;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 500, nullable = false)
    private String descricao;

    @Column(length = 100)
    private String cidade;

    @Column(length = 100)
    private String bairro;

    @Column(length = 100)
    private String cargaHoraria;

    @Column(length = 100)
    private String salario;

    @Column(length = 100, nullable = false)
    private String area;

    @Column(nullable = false)
    private LocalDateTime dataCadastro;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private StatusVaga statusVaga;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public StatusVaga getStatusVaga() {
        return statusVaga;
    }

    public void setStatusVaga(StatusVaga statusVaga) {
        this.statusVaga = statusVaga;
    }
}
