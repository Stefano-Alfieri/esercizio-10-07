package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorie")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public List<Categoria> getListaCategorie(){
		return categoriaService.getListaCategorie();
	}
	
	@PostMapping
	public  ResponseEntity<String> addCategoria(@RequestBody Categoria categoria){
		categoriaService.addCategoria(categoria);
		return new ResponseEntity<>("Categoria aggiunta",HttpStatus.CREATED);
	}
	
	@PutMapping("/{nomeCategoria}")
	public ResponseEntity<String> aggiornaCategoria(@PathVariable String nome, @RequestBody Categoria aggiornaCategoria){
		boolean aggiornato = categoriaService.aggiornaCategoria(nome, aggiornaCategoria);
		if(aggiornato) {
			return new ResponseEntity<> ("Categoria modificata",HttpStatus.OK);
		}else {
			return new ResponseEntity<> ("Categoria non trovata",HttpStatus.NOT_FOUND);

		}
	}
}
