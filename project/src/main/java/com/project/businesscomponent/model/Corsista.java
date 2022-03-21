package com.project.businesscomponent.model;

public class Corsista {

	private long codcorsista;
	private String nomecorsista;
	private String cognomecorsista;
	private String precedentiformativi;
	
	
	
	public long getCodcorsista() {
		return codcorsista;
	}
	public void setCodcorsista(long codcorsista) {
		this.codcorsista = codcorsista;
	}
	public String getNomecorsista() {
		return nomecorsista;
	}
	public void setNomecorsista(String nomecorsista) {
		this.nomecorsista = nomecorsista;
	}
	public String getCognomecorsista() {
		return cognomecorsista;
	}
	public void setCognomecorsista(String cognomecorsista) {
		this.cognomecorsista = cognomecorsista;
	}
	public String getPrecedentiformativi() {
		return precedentiformativi;
	}
	public void setPrecedentiformativi(String precedentiformativi) {
		this.precedentiformativi = precedentiformativi;
	}
	
	
	@Override
	public String toString() {
		return "Corsista [nomecorsista=" + nomecorsista + ", cognomecorsista=" + cognomecorsista
				+ ", precedentiformativi=" + precedentiformativi + "]";
	}
	
	
}
