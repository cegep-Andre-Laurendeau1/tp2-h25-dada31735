package ca.cal.tp2.service;

import ca.cal.tp2.modele.Livre;
import ca.cal.tp2.persistance.LivreRepository;

public class PreposeService {
    private final LivreRepository livreRepository;

    public PreposeService(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    public void ajouterLivre(String ISBN, String auteur, String editeur, int nombrePages) {
        Livre livre = new Livre(ISBN, auteur, editeur, nombrePages);
        livreRepository.save(livre);
    }

    public Livre obtenirLivre(long id) {
        return livreRepository.get(id);
    }
}
