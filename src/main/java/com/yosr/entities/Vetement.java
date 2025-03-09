package com.yosr.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vetement implements Serializable {
	
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long idVet;
	
    private String nomVet;
    private String taille;
    private double prix;
    
    
	public Long getIdVet() {
		return idVet;
	}
	public void setIdVet(Long idVet) {
		this.idVet = idVet;
	}
	public String getNomVet() {
		return nomVet;
	}
	public void setNomVet(String nomVet) {
		this.nomVet = nomVet;
	}
	public String getTaille() {
		return taille;
	}
	public void setTaille(String taille) {
		this.taille = taille;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	@Override
	public String toString() {
		return "Vetement [idVet=" + idVet + ", nomVet=" + nomVet + ", taille=" + taille + ", prix=" + prix + "]";
	}

	
}
