package br.edu.uniesi.expouniesi.listViews;

public class ListViewVisitantes {
    private String nome, email, whatsapp;

    public ListViewVisitantes(String nome, String email, String whatsapp) {
        this.nome = nome;
        this.email = email;
        this.whatsapp = whatsapp;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getWhatsapp() {
        return whatsapp;
    }
}
