package com.lanchonete.lanches;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/lanches")
@AllArgsConstructor
public class LancheController {

	@Autowired
	LancheRepository repository;
	
	@GetMapping("/retornaTodos")
	List<Lanche> todosLaches(){
		return repository.findAll();
	}
	
	@PostMapping("/novo")
	Lanche novoLanche(@RequestBody Lanche lanche) {
		return repository.save(lanche);
	}
	
	@GetMapping("/{id}")
	Optional<Lanche> retornaLanche(@PathVariable Long id){
		return repository.findById(id);
	}
	
	@PutMapping("/{id}")
	Lanche atualizaLanche(@RequestBody Lanche lanche, @PathVariable Long id) {
		lanche.setId(id);
		return repository.save(lanche);
	}
	
	@DeleteMapping("/deleta/{id}")
	void deletaPrato(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
