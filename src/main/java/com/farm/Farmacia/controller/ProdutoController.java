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

import com.farm.Farmacia.model.Produto;
import com.farm.Farmacia.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin("*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(repository.findById(id).get());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produto>> getByNome(@PathVariable String nome){
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping("/criar") // Insere um novo dado
	public ResponseEntity<Produto> saveProduto(@Valid @RequestBody Produto produto){
		return ResponseEntity.status(200).body(repository.save(produto));
	}
	
	@PutMapping("/Atualiza") // Insere um novo dado
	public ResponseEntity<Produto> updateProduto(@Valid @RequestBody Produto produto){
		return ResponseEntity.status(200).body(repository.save(produto));
	}
	
	@DeleteMapping("/{id}")
    public void deletar (@PathVariable Long id) {
		repository.deleteById(id);
	}
}
