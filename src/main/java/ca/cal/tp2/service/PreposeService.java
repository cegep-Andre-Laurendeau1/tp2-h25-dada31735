package ca.cal.tp2.service;

import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.DVD;
import ca.cal.tp2.modele.Livre;
import ca.cal.tp2.persistance.CDRepository;
import ca.cal.tp2.persistance.DVDRepository;
import ca.cal.tp2.persistance.LivreRepository;

public class PreposeService {
    private final LivreRepository livreRepository;
    private final CDRepository cdRepository;
    private final DVDRepository dvdRepository;

    public PreposeService(LivreRepository livreRepository, CDRepository cdRepository, DVDRepository dvdRepository) {
        this.livreRepository = livreRepository;
        this.cdRepository = cdRepository;
        this.dvdRepository = dvdRepository;
    }

    public void ajouterLivre(String titre, int nombreExemplaires, String ISBN, String auteur, String editeur, int nombrePages) {
        Livre livre = new Livre(titre, nombreExemplaires, ISBN, auteur, editeur, nombrePages);
        livreRepository.save(livre);
    }

    public Livre obtenirLivre(long id) {
        return livreRepository.get(id);
    }

    public Livre rechercheLivre(String titre, String auteur) {
        return livreRepository.recherche(titre, auteur);
    }

    public void ajouterCD(String titre, int nombreExemplaire, String artiste, int duree, String genre) {
        CD cd = new CD(titre, nombreExemplaire, artiste, duree, genre);
        cdRepository.save(cd);
    }

    public CD obtenirCD(long id) {
        return cdRepository.get(id);
    }

    public void ajouterDVD(String titre, int nombreExemplaire, String realisateur, int duree, String rating) {
        DVD dvd = new DVD(titre, nombreExemplaire, realisateur, duree, rating);
        dvdRepository.save(dvd);
    }

    public DVD obtenirDVD(long id) {
        return dvdRepository.get(id);
    }
}
