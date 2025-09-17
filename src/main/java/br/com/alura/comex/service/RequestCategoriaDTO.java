package br.com.alura.comex.service;

import org.hibernate.validator.constraints.Length;
import br.com.alura.comex.model.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RequestCategoriaDTO {

    @NotNull
    @NotBlank(message = "O nome não pode estar em branco.")
    // Para strings: @Length, para número: @Size
    @Length(min = 2, message = "O nome deve ter no mínimo 2 caracteres.")
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