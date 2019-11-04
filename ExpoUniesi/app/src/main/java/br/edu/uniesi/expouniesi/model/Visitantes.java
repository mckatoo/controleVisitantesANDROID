package br.edu.uniesi.expouniesi.model;

public class Visitantes {
    private int id;
    private String nome;
    private String email;
    private String escola;
    private String whatsapp;
    private String curso_desejado;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEscola() {
        return escola;
    }

    public void setEscola(String escola) {
        this.escola = escola;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getCurso_desejado() {
        return curso_desejado;
    }

    public void setCurso_desejado(String curso_desejado) {
        this.curso_desejado = curso_desejado;
    }

    @Override
    public String toString() {
        return "Visitantes{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", escola='" + escola + '\'' +
                ", whatsapp='" + whatsapp + '\'' +
                ", curso_desejado='" + curso_desejado + '\'' +
                '}';
    }
}
