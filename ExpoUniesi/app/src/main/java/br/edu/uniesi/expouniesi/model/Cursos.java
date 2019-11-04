package br.edu.uniesi.expouniesi.model;

public class Cursos {
    private int id;
    private String curso;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Cursos{" +
                "id=" + id +
                ", curso='" + curso + '\'' +
                '}';
    }
}
