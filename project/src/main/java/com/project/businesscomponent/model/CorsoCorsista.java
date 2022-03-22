package com.project.businesscomponent.model;

public class CorsoCorsista {
	
	private int codcorso;
	private int codcorsista;
	public int getCodcorso() {
		return codcorso;
	}
	public void setCodcorso(int codcorso) {
		this.codcorso = codcorso;
	}
	public int getCodcorsista() {
		return codcorsista;
	}
	public void setCodcorsista(int codcorsista) {
		this.codcorsista = codcorsista;
	}
	@Override
	public String toString() {
		return "CorsoCorsista [codcorso=" + codcorso + ", codcorsista=" + codcorsista + "]";
	}
}

	

