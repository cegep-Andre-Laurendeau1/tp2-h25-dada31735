package ca.cal.tp2;

import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Emprunt;
import ca.cal.tp2.modele.Emprunteur;
import ca.cal.tp2.persistance.*;
import ca.cal.tp2.service.EmprunteurService;
import ca.cal.tp2.service.PreposeService;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        // Votre script qui utilise votre API ici
        TcpServer.startTcpServer();
        PreposeService preposeService = new PreposeService(new LivreRepositoryJPA(), new CDRepositoryJPA(), new DVDRepositoryJPA(), new EmprunteurRepositoryJPA());
        EmprunteurService emprunteurService = new EmprunteurService(new EmpruntRepositoryJPA(), new EmprunteurRepositoryJPA());
        //ajouts livres
        preposeService.ajouterLivre("Seigneur des anneaux", 100,"1239123", "tolkien", "hobbit", 1000);
        preposeService.ajouterLivre("Seigneur des anneaux", 100,"1239123", "tolkien", "hobbit", 1000);

        //ajouts CD
        preposeService.ajouterCD("Let go", 100,"Avril Lavigne", 100, "pop");

        //ajouts DVD
        preposeService.ajouterDVD("Once upon a time in Hollywood", 5,"Tarantino", 120, "fresh");

        //ajouts Emprunteurs
        preposeService.ajouterEmprunteur("Dumitru", "qwerty@azerty.com", "1234567890");

        //recherches de livre
        //par titre
        System.out.println(preposeService.rechercheLivre("Anneaux", "tolkien"));

        Emprunteur emprunteur = preposeService.rechercheEmprunteur("Dumitru");
        Document livre = preposeService.rechercheLivre("Seigneur des anneaux", "tolkien");

        if (emprunteur != null && livre != null) {
            emprunteurService.emprunterDocument(emprunteur.getUserID(), livre);
            List<Emprunt> emprunts = emprunteurService.obtenirEmprunts(emprunteur.getUserID());
            System.out.println("Liste des emprunts pour " + emprunteur.getName() + ":");
            for (Emprunt emprunt : emprunts) {
                System.out.println("Emprunt ID: " + emprunt.getBorrowID() + ", Date: " + emprunt.getDateEmprunt() + ", Status: " + emprunt.getStatus());
            }
        }

        Thread.currentThread().join();
    }
}