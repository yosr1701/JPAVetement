package com.yosr.test;

import com.yosr.dao.VetementDao;
import com.yosr.entities.Vetement;

public class VetementTest {
    public static void main(String[] args) {
        // Créer un objet Vetement
        Vetement v1 = new Vetement();
        v1.setNomVet("T-shirt");
        v1.setTaille("M");
        v1.setPrix(29.99);
        
        Vetement v2 = new Vetement();
        v2.setNomVet("robe");
        v2.setTaille("S");
        v2.setPrix(99.99);
        
        Vetement v3 = new Vetement();
        v3.setNomVet("jean");
        v3.setTaille("L");
        v3.setPrix(49.99);
        
        Vetement v4 = new Vetement();
        v4.setNomVet("Veste cuir");
        v4.setTaille("M");
        v4.setPrix(299.99);
        
        // Ajouter les objets Vetement à la BD
        VetementDao vetDao = new VetementDao();
        vetDao.ajouter(v1);
        vetDao.ajouter(v2);
        vetDao.ajouter(v3); 
        vetDao.ajouter(v4); 

        System.out.println("Appel de la méthode listerTous");
        for (Vetement vet : vetDao.listerTous()) {
            System.out.println(vet);
        }

        System.out.println("\nAppel de la méthode listerParNom");
        for (Vetement vet : vetDao.listerParNom("robe")) {
            System.out.println(vet);
        }
        
        // Tester la méthode modifier
        System.out.println("\nAppel de la méthode modifier");
        v1.setPrix(19.99); // Changer le prix du T-shirt
        vetDao.modifier(v1); // Appel de la méthode modifier pour mettre à jour le T-shirt
        // Afficher les vêtements après modification
        for (Vetement vet : vetDao.listerTous()) {
            System.out.println(vet);
        }
        
        
        // Tester la méthode supprimer
        vetDao.supprimer(v2); // Suppression du premier Vetement ajouté
        System.out.println("\nAprès suppression de vetement de l'id=2:");
        for (Vetement vet : vetDao.listerTous()) {
            System.out.println(vet);
        }
        
        // Tester la méthode consulter
        System.out.println("\nAppel de la méthode consulter");
        Vetement vetementConsulte = vetDao.consulter(v3.getIdVet()); // Passer l'ID de v
        if (vetementConsulte != null) {
            System.out.println(vetementConsulte);
        } else {
            System.out.println("Aucun vêtement trouvé avec cet ID.");
        }
    }
}
