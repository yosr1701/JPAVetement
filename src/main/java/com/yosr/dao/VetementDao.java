package com.yosr.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.yosr.entities.Vetement;
import com.yosr.util.JPAutil;

public class VetementDao {

	private EntityManager entityManager = JPAutil.getEntityManager("ProjVET");

	// Méthode ajouter d'une entité à la BD
	public void ajouter(Vetement v) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		//insert
		entityManager.persist(v);
		//pour valider 
		tx.commit();
	}

	// Méthode modifier d'une entité à partir de la BD
	public void modifier(Vetement v) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		//merge : update 
		entityManager.merge(v);
		tx.commit();
	}

	
    
	// Méthode supprimer d'une entité à partir de la BD
	public void supprimer(Vetement v) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		//merge dans la suppression c pour acceder puis supprimer 
		v = entityManager.merge(v); // important
		entityManager.remove(v);
		tx.commit();
	}

	// Méthode consulter une entité à partir de la BD
	public Vetement consulter(Object id) {
		return entityManager.find(Vetement.class, id);
	}

	// Méthode pour lister tous les objets à partir de la BD
	public List<Vetement> listerTous() {
		List<Vetement> vetements = entityManager.createQuery("select v from Vetement v").getResultList();
		return vetements;
	}

	// Méthode pour lister tous les vêtements dont le nom contient un texte donné en
	// paramètre (pnom)
	public List<Vetement> listerParNom(String nom) {
		List<Vetement> vetements = entityManager.createQuery("select v from Vetement v where v.nomVet like :nomVet")
				.setParameter("nomVet", "%" + nom + "%").getResultList();
		return vetements;
	}
}
