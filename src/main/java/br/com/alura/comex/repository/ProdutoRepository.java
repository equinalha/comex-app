package br.com.alura.comex.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.comex.model.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long>{
}
