package br.com.alura.comex.model;

import java.util.List;

import br.com.alura.comex.service.StatusCategoria;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;

    @OneToMany(mappedBy = "categorias")
    private List<Produto> produtos;

    @Enumerated(EnumType.STRING)
    private StatusCategoria status = StatusCategoria.ATIVA;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    public StatusCategoria getStatus() {
        return status;
    }

    public void setStatus(StatusCategoria status) {
        this.status = status;
    }
    
}