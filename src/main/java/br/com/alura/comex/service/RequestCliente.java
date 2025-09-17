package br.com.alura.comex.service;

import org.hibernate.validator.constraints.Length;
import br.com.alura.comex.model.Cliente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class RequestCliente {
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode estar em branco.")
    @Length(min = 2, message = "O nome deve ter no mínimo 2 caracteres.")
    private String nome;

    @NotNull(message = "O CPF não pode ser nulo")
    @NotBlank(message = "O CPF não pode estar em branco.")
    @Length(min = 11, max = 11, message = "O CPF deve ter 11 caractéres")
    private String cpf;

    @NotNull(message = "O e-mail não pode ser nulo")
    @NotBlank(message = "O e-mail não pode estar em branco.")
    @Email(message = "O formato do e-mail é inválido")
    private String email;

    @NotNull(message = "O telefone não pode ser nulo")
    @NotBlank(message = "O telefone não pode estar em branco.")
    private String telefone;

    @NotNull(message = "O logradouro não pode ser nulo")
    @NotBlank(message = "O logradouro não pode estar em branco.")
    private String logradouro;

    @NotNull(message = "O bairro não pode ser nulo")
    @NotBlank(message = "O bairro não pode estar em branco.")
    private String bairro;
    
    @NotNull(message = "O cidade não pode ser nulo")
    @NotBlank(message = "O cidade não pode estar em branco.")
    private String cidade;
    
    @NotNull(message = "O estado não pode ser nulo")
    @NotBlank(message = "O estado não pode estar em branco.")
    private String estado;
    
    @NotNull(message = "O cep não pode ser nulo")
    @NotBlank(message = "O cep não pode estar em branco.")
    private String cep;
    
    @NotNull(message = "O preco não pode ser nulo")
    @Positive(message = "O preço não pode ser negativo.")
    private Double preco;
  
    @NotNull(message = "A quantidade não pode ser nulo")
    private Long quantidade;

    public Cliente toCliente() {
        Cliente cliente = new Cliente();

        return cliente;
    }

}