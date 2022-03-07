package it.polito.tdp.librettovoti_model;

public class Voto {
	private String nome;
	private int voto;
	private int punti;
	
	public Voto(String nome, int voto, int punti) {
		super();
		this.nome= nome;
		this.voto=voto;	
		this.punti= punti;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getVoto() {
		return voto;
	}
	
	public int setPunti() {
		this.punti = punti;
	}

	@Override
	public String toString() {
		return nome+ " : " + punti;
	}
	
}
