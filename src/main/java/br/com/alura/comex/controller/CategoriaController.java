package br.com.alura.comex.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.repository.CategoriaRepository;
import br.com.alura.comex.service.RequestCategoria;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaRepository repository;

    public CategoriaController(CategoriaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Object> cadastrar(@RequestBody @Valid RequestCategoria request, BindingResult result){

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
