package br.com.alura.comex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.repository.CategoriaRepository;
import br.com.alura.comex.service.RequestCategoriaDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @PostMapping
    // RequestCategoria -> A anotação @RequesttBody faz com que o objeto RequestCategoriaDTO seja populado com os campos vindos da requisição HTTP
    public ResponseEntity<Object> cadastrar(@RequestBody @Valid RequestCategoriaDTO request, BindingResult result){

        if(result.hasErrors()){
            FieldError fieldError = result.getFieldError();
            if(fieldError != null){
                String mensagem = fieldError.getDefaultMessage();
                return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>("Erro Genérico", HttpStatus.BAD_REQUEST);
            }
        }

        Categoria categoria = request.toCategoria();
        repository.save(categoria);
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }
}
