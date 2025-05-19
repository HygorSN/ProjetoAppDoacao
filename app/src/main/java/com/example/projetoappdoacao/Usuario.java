package com.example.projetoappdoacao;

public class Usuario {
    public String nome;
    public String email;
    public String telefone;
    public String documento;
    public String senha;
    public String tipo;

    public Usuario(String nome, String email, String telefone, String documento, String senha, String tipo) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.documento = documento;
        this.senha = senha;
        this.tipo = tipo;
    }
}
