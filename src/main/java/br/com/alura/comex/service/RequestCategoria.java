package br.com.alura.comex.service;

import br.com.alura.comex.model.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RequestCategoria {

    @NotNull
    @NotBlank(message = "O nome não pode estar em branco.")
    @Size(min = 2, message = "O nome deve ter no mínimo 2 caracteres.")
    private String nome;

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método para converter o DTO para a entidade
    public Categoria toCategoria() {
        Categoria categoria = new Categoria();
        categoria.setNome(this.nome);
        return categoria;
    }
}