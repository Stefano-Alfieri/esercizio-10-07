package com.example.demo;
import java.util.List;

import com.example.demo.Categoria;
public class Prodotto {
	private int id;
	private String titolo;
	private double prezzo;
	private String descrizione;
	private String categoria;

	public Prodotto(int id,String titolo,double prezzo,String categoria,String descrizione) {
		this.id=id;
		this.titolo=titolo;
		this.prezzo=prezzo;
		this.categoria=categoria;
		this.descrizione=descrizione;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

}
