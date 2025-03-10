package ca.cal.tp2.service;

import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.Livre;
import ca.cal.tp2.persistance.CDRepository;
import ca.cal.tp2.persistance.LivreRepository;

public class PreposeService {
    private final LivreRepository livreRepository;
    private final CDRepository cdRepository;

    public PreposeService(LivreRepository livreRepository, CDRepository cdRepository) {
        this.livreRepository = livreRepository;
        this.cdRepository = cdRepository;
    }

    public void ajouterLivre(String ISBN, String auteur, String editeur, int nombrePages) {
        Livre livre = new Livre(ISBN, auteur, editeur, nombrePages);
        livreRepository.save(livre);
    }

    public Livre obtenirLivre(long id) {
        return livreRepository.get(id);
    }

    public void ajouterCD(String artiste, int duree, String genre) {
        CD cd = new CD(artiste, duree, genre);
        cdRepository.save(cd);
    }
}
