package com.example.apiornitologando.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.apiornitologando.model.Passaro;
import com.example.apiornitologando.servico.PassaroServico;

@RequestMapping("/ornitologando")
@CrossOrigin//(origins = "http://localhost:8080")
@RestController
public class PassaroController {
    @Autowired
    private PassaroServico servico;
    
    @PostMapping("/passaro")
    public ResponseEntity<Passaro> cadastrarNovoPassaro (@RequestBody Passaro novo){
        Passaro pass = servico.criarNovoPassaro(novo);
        if (pass != null) {
            return ResponseEntity.status(201).body(pass);
        }
        return ResponseEntity.badRequest().build();
    }
    
    @GetMapping("/passaro")
    public ResponseEntity<List<Passaro>> recuperarTodos(){
        return ResponseEntity.ok(servico.listarTodos());
    }

    @GetMapping("/passaro/{id}")
    public ResponseEntity<Passaro> recuperarPorId(@PathVariable Integer id){
        Passaro res = servico.buscarPorId(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }
}
