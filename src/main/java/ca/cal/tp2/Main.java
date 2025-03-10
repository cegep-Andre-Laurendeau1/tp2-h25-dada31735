package ca.cal.tp2;

import ca.cal.tp2.persistance.CDRepositoryJPA;
import ca.cal.tp2.persistance.DVDRepositoryJPA;
import ca.cal.tp2.persistance.LivreRepositoryJPA;
import ca.cal.tp2.service.PreposeService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        // Votre script qui utilise votre API ici
        TcpServer.startTcpServer();
        PreposeService preposeService = new PreposeService(new LivreRepositoryJPA(), new CDRepositoryJPA(), new DVDRepositoryJPA());

        //ajouts livres
        preposeService.ajouterLivre("Seigneur des anneaux", 100,"1239123", "tolkien", "hobbit", 1000);
        preposeService.ajouterLivre("Seigneur des anneaux", 100,"1239123", "tolkien", "hobbit", 1000);

        //ajouts CD
        preposeService.ajouterCD("Let go", 100,"Avril Lavigne", 100, "pop");

        //ajouts DVD
        preposeService.ajouterDVD("Once upon a time in Hollywood", 5,"Tarantino", 120, "fresh");

        //recherches de livre
        //par titre
        System.out.println(preposeService.rechercheLivre("Anneaux", "tolkien"));

        Thread.currentThread().join();
    }
}
