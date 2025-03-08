package ca.cal.tp2;

import ca.cal.tp2.persistance.LivreRepository;
import ca.cal.tp2.persistance.LivreRepositoryJDBC;
import ca.cal.tp2.service.LivreService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        // Votre script qui utilise votre API ici
        TcpServer.startTcpServer();
        LivreService livreService = new LivreService(new LivreRepositoryJDBC());

        livreService.ajouteLivre(1, "Le seigneur des anneaux", "J.R.R. Tolkien", "Editeur", 999);

        livreService.getLivre(1);

        Thread.currentThread().join();
    }
}
