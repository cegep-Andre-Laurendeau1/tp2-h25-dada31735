package ca.cal.tp2;

import ca.cal.tp2.persistance.CDRepositoryJPA;
import ca.cal.tp2.persistance.LivreRepositoryJPA;
import ca.cal.tp2.service.PreposeService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        // Votre script qui utilise votre API ici
        TcpServer.startTcpServer();
        PreposeService preposeService = new PreposeService(new LivreRepositoryJPA(), new CDRepositoryJPA());
        preposeService.ajouterLivre("1239123", "tolkien", "hobbit", 1000);
        preposeService.ajouterCD("Avril Lavigne", 100, "pop");
        Thread.currentThread().join();
    }
}
