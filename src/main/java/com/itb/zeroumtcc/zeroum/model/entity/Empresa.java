package com.itb.zeroumtcc.zeroum.model.entity;
import com.itb.zeroumtcc.zeroum.model.entity.enums.StatusEmpresa;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Empresa",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_empresa_cnpj", columnNames = "cnpj")
        })
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // FK para Usuario
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_empresa_usuario"))
    private Usuario usuario;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 18, nullable = false, unique = true)
    private String cnpj;

    @Column(length = 300, nullable = false)
    private String informacao;

    @Column(length = 8, nullable = false)
    private String cep;

    @Column(length = 10, nullable = false)
    private String numero;

    @Column(length = 50)
    private String webSite;

    @Column(length = 20, nullable = false)
    private String telefone;

    @Column(nullable = false)
    private LocalDateTime dataCadastro;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private StatusEmpresa statusEmpresa;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public String getInformacao() { return informacao; }
    public void setInformacao(String informacao) { this.informacao = informacao; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getWebSite() { return webSite; }
    public void setWebSite(String webSite) { this.webSite = webSite; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }

}