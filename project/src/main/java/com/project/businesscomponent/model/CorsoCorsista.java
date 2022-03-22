package com.project.businesscomponent.model;

public class CorsoCorsista {
	
	private int codcorso;
	private int codcorsista;
	
	public int getCodCorso() {
		return codcorso;
	}
	public void setCodCorso(int codcorso) {
		this.codcorso = codcorso;
	}
	public int getCodCorsista() {
		return codcorsista;
	}
	public void setCodCorsista(int codcorsista) {
		this.codcorsista = codcorsista;
	}
	@Override
	public String toString() {
		return "CorsoCorsista [codcorso=" + codcorso + ", codcorsista=" + codcorsista + "]";
	}
}

	

