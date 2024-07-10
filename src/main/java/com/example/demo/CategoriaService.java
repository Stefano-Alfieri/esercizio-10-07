package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service

public class CategoriaService {
private List<Categoria> listaCategorie;
	
	public CategoriaService() {
		this.listaCategorie=new ArrayList<Categoria>();
		listaCategorie.add(new Categoria("vestiti"));
		listaCategorie.add(new Categoria("tecnologia"));
		listaCategorie.add(new Categoria("videogiochi"));
	}

	public List<Categoria> getListaCategorie(){
		return listaCategorie;
	}
	
	public void addCategoria(Categoria categoria) {
		listaCategorie.add(categoria);
	}
	
	public boolean aggiornaCategoria(String nome, Categoria aggiornaCategoria) {
		Optional<Categoria> categoriaEsistente= listaCategorie.stream().filter(c  ->c.getNomeCategoria().equalsIgnoreCase(nome)).findFirst();
		if(categoriaEsistente.isPresent()) {
			Categoria categoria= categoriaEsistente.get();
			categoria.setNomeCategoria(nome);
			return true;
		}
		return false;
	}
	
}
