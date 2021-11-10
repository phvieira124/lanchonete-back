package com.lanchonete.funcionarios;

import com.lanchonete.restaurantes.Restaurante;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
@AllArgsConstructor
public class FuncionarioController {

    @Autowired
    FuncionarioRepository repository;

    @GetMapping("/retornaTodos")
    List<Funcionario> todosFuncionarios() {
        return  repository.findAll();
    }

    @PostMapping("/novo")
    Funcionario novoFuncionario(@RequestBody Funcionario funcionario) {
        return repository.save(funcionario);
    }

    @GetMapping("/{id}")
    Optional<Funcionario> retornaFuncionario(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping("/{id}")
    Funcionario atualizaFuncionario(@RequestBody Funcionario funcionario, @PathVariable Long id) {
        funcionario.setId(id);
        return repository.save(funcionario);
    }

    @DeleteMapping("/deleta/{id}")
    void deletaFuncionario(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
