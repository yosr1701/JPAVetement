package com.yosr.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAutil {
	private static EntityManagerFactory factory;
	private static EntityManager entityManager;
	
	//persistanceunit :(name="ProjVET")dans fichier xml 
	public static EntityManager getEntityManager(String persistUnit)
	 {
	if (entityManager==null)
	{
		factory = Persistence.createEntityManagerFactory(persistUnit);
		entityManager = factory.createEntityManager();
	}
	return entityManager;
	//retourne l'entité affecte avec factory
	}

}
