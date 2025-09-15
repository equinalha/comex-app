package br.com.alura.comex.service;

import br.com.alura.comex.model.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class RequestProduto {
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode estar em branco.")
    @Size(min = 2, message = "O nome deve ter no mínimo 2 caracteres.")
    private String nome;
    
    @NotNull(message = "O preco não pode ser nulo")
    @PositiveOrZero(message = "O preço não pode ser negativo.")
    private Double preco;

    private String descricao;
    
    @NotNull(message = "A quantidade não pode ser nulo")
    private Long quantidade;

    public Produto toProduto() {
        Produto produto = new Produto();
        produto.setNome(this.nome);
        produto.setPreco(this.preco);
        produto.setDescricao(this.descricao);
        produto.setQuantidade(this.quantidade);

        return produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
}