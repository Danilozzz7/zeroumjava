package model.entity;

public class Perfil_Aluno {
    private Long id;
    private String curso;
    private String ano;
    private String telefone;
    private String email;
    private String experiencia;
    private String statusProf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getStatusProf() {
        return statusProf;
    }

    public void setStatusProf(String statusProf) {
        this.statusProf = statusProf;
    }
}
