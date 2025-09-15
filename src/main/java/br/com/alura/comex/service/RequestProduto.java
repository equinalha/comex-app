package br.com.alura.comex.service;

import br.com.alura.comex.model.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class RequestProduto {
    @NotNull
    @NotBlank(message = "O nome não pode estar em branco.")
    @Size(min = 2, message = "O nome deve ter no mínimo 2 caracteres.")
    private String nome;
    
    @NotNull
    @NotBlank
    @PositiveOrZero(message = "O preço não pode ser negativo.")
    private Double preco;

    private String descricao;
    
    @NotNull
    @NotBlank
    private Long quantidade;

    public Produto toProduto() {
        Produto produto = new Produto();
        produto.setNome(this.nome);
        produto.setPreco(this.preco);
        produto.setDescricao(this.descricao);
        produto.setQuantidade(this.quantidade);

        return produto;
    }
}