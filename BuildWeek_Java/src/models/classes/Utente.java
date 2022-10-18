package models.classes;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Utente {

	@Id
	private int id;
	
	private String nome;
	
	private String cognome;
	
	private Tessera tessera;
	
	public Utente() {}

	public Utente(String nome, String cognome, Tessera tessera) {
		this.nome = nome;
		this.cognome = cognome;
		this.tessera = tessera;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Tessera getTessera() {
		return tessera;
	}

	public void setTessera(Tessera tessera) {
		this.tessera = tessera;
	}
	
	
	
}
