package com.farm.Farmacia.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farm.Farmacia.model.Categoria;
import com.farm.Farmacia.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> findAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(repository.findById(id).get());
	}
	@GetMapping("/decricao/{descricao}")
	public ResponseEntity<List<Categoria>> findAllByDescricaoContainingIgnoreCase(@PathVariable String descricao){
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	@PostMapping("/criar") // Insere um novo dado
	public ResponseEntity<Categoria> saveCategoria(@Valid @RequestBody Categoria categoria){
		return ResponseEntity.status(200).body(repository.save(categoria));
	}
	
	@PutMapping("/atualizar")
    public ResponseEntity<Categoria> updateCategoria (@Valid @RequestBody Categoria categoria){
        return ResponseEntity.status(200).body(repository.save(categoria));
    }
	
	@DeleteMapping("/{id}")
    public void deletar (@PathVariable Long id) {
		repository.deleteById(id);
	}
	

	

	
	
}
	


