package it.polito.tdp.librettovoti_model;

import java.util.ArrayList;
import java.util.List;

public class Libretto {
	
	private List<Voto> voti;
	
	public Libretto() {
		this.voti = new ArrayList<Voto>();
	}
	
	public void add(Voto v) {
		this.voti.add(v);
	}
	
	public Libretto filtraPunti(int punti) {
		Libretto result = new Libretto();
		for (Voto v: this.voti) {
			if (v.getPunti()==punti) {
				result.add(v);
			}
		}
		return result;
	}
	
	
	/**
	 * restiruisce il punteggio otttenuto all'esame du cui 
	 * specifico il nome
	 * @param nome Nome dell'esame
	 * @return punteggio numerico, oppure {@code null} null se esame non esiste  
	 */
	public Integer puntiEsame(String nome) {
		for (Voto v : this.voto) {
			if (v.getNome().equals(nome)) { // comparare le stringe NON ==(solo numeri) ma equals
				return v.getPunti;
			}
		}
		//return -1;
		return null;
		//throw new IllegalArgumentException("Corso non trovato");
	}
	
	public boolean isDuplicato(Voto v) {
		for (Voto v1: this.voti) {
			
			if(v1.equals(v))
				return true;
		}
		return false;
	}
	
	public boolean isConflitto(Voto v) {
		Integer punti = this.puntiEsame(v.getNome());
		if (punti != null && punti != v.getPunti())
			return true;
		else 
			return false;		
	}
	
	//public String toString() {
	//	return this.voti.toString();
	//}
	
		
		
	
}