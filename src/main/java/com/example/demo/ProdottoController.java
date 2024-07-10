package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prodotti")
public class ProdottoController {
	@Autowired
	private ProdottoService prodottoService;
	
	@GetMapping
	public List<Prodotto> getListaProdotti(){
		return prodottoService.getListaProdotti();
	}
	
	@PostMapping
	public ResponseEntity<String> addProdotto(@RequestBody Prodotto prodotto){
		prodottoService.addProdotto(prodotto);
		return new ResponseEntity<>("Prodotto aggiunto all'elenco",HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> aggiornaProdotto(@PathVariable int id, @RequestBody Prodotto aggiornaProdotto){
		boolean aggiornato = prodottoService.aggiornaProdotto(id, aggiornaProdotto);
		if(aggiornato) {
			return new ResponseEntity<>("Prodotto aggiornato",HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Prodotto non trovato", HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public  ResponseEntity<String> rimuoviProdotto(@PathVariable int id){
		boolean rimosso= prodottoService.rimuoviProdotto(id);
		if(rimosso) {
			return new ResponseEntity<>("Prodotto rimosso",HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Prodotto non trovato",HttpStatus.NOT_FOUND);
		}
	}
		
}
