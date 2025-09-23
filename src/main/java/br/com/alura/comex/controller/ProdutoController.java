package br.com.alura.comex.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.model.Produto;
import br.com.alura.comex.repository.ProdutoRepository;
import br.com.alura.comex.service.RequestProdutoDTO;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    
    private final ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository){
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Object> cadastrar(@RequestBody @Valid RequestProdutoDTO request, BindingResult result) {

        if(result.hasErrors()){
            FieldError fieldError = result.getFieldError();
            if(fieldError != null){
                String mensagem = fieldError.getDefaultMessage();
                return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>("Erro Genérico", HttpStatus.BAD_REQUEST);
            }
        }

        Produto produto = request.toProduto();
        repository.save(produto);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<List<Produto>> listarTodos() {
        List<Produto> produtos = repository.findAll();
        return ResponseEntity.ok(produtos);
    }
}
