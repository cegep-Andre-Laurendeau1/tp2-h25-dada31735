package ca.cal.tp2.service;

import ca.cal.tp2.modele.Livre;
import ca.cal.tp2.persistance.LivreRepository;

public class LivreService {
    LivreRepository livreRepository;

    public LivreService(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }


    public void ajouteLivre(int id, String titre, String auteur, String editeur, int nbPages) {
        Livre livre = new Livre();
        livre.setTitre(titre);
        livre.setAuteur(auteur);
        livre.setEditeur(editeur);
        livre.setNombrePages(nbPages);
        livre.setDocumentID(id);

        livreRepository.save(livre);
    }

    public void getLivre(int id) {
        Livre livre = livreRepository.get(id);
        System.out.println(livre);
    }
}
