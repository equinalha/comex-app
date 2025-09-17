package br.com.alura.comex.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.comex.repository.ClienteRepository;
import br.com.alura.comex.model.Cliente;
import br.com.alura.comex.service.RequestClienteDTO;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    // Injeção de dependência
    private final ClienteRepository repository;

    public ClienteController(ClienteRepository repository){
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Object> cadastrar(@RequestBody @Valid RequestClienteDTO request, BindingResult result) {
        
        if(result.hasErrors()){
            FieldError fieldError = result.getFieldError();
            if(fieldError != null){
                String mensagem = fieldError.getDefaultMessage();
                return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>("Erro Genérico", HttpStatus.BAD_REQUEST);
            }
        }

        Cliente cliente = request.toCliente();
        repository.save(cliente);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }
}
