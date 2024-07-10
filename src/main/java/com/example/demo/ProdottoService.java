package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ProdottoService {
	private List<Prodotto> listaProdotti;
	public ProdottoService() {
		this.listaProdotti=new ArrayList<Prodotto>();
		listaProdotti.add(new Prodotto(1,"Maglia",22.50,"vestiti","maglietta nike nera"));
		listaProdotti.add(new Prodotto(2,"Pantalone",35,"vestiti","pantalone nera"));
		listaProdotti.add(new Prodotto(3,"Computer",2100,"tecnologia","mcbook"));
		listaProdotti.add(new Prodotto(4,"Crash Bandicoot Warped",40,"videogiochi","terzo capitolo della saga"));
	}
	public List<Prodotto> getListaProdotti() {
		return listaProdotti;
	}
	public void addProdotto(Prodotto prodotto) {
		listaProdotti.add(prodotto);
	}

	public boolean aggiornaProdotto(int id, Prodotto aggiornaProdotto) {
		Optional<Prodotto> prodottoEsistente = listaProdotti.stream().filter(p -> p.getId()==id).findFirst();
		if(prodottoEsistente.isPresent()) {
			Prodotto prodotto = prodottoEsistente.get();
			prodotto.setTitolo(aggiornaProdotto.getTitolo());
			prodotto.setPrezzo(aggiornaProdotto.getPrezzo());
			prodotto.setCategoria(aggiornaProdotto.getCategoria());	
			prodotto.setDescrizione(aggiornaProdotto.getDescrizione());
			return true;
			}
		return false;
	}
	
	public boolean rimuoviProdotto(int id) {
		return listaProdotti.removeIf(p -> p.getId()==id);
	}
}
