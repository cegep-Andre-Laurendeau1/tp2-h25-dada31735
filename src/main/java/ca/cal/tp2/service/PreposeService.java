package ca.cal.tp2.service;

import ca.cal.tp2.dto.CDDTO;
import ca.cal.tp2.dto.DVDDTO;
import ca.cal.tp2.dto.LivreDTO;
import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.DVD;
import ca.cal.tp2.modele.Emprunteur;
import ca.cal.tp2.modele.Livre;
import ca.cal.tp2.persistance.CDRepository;
import ca.cal.tp2.persistance.DVDRepository;
import ca.cal.tp2.persistance.EmprunteurRepository;
import ca.cal.tp2.persistance.LivreRepository;

public class PreposeService {
    private final LivreRepository livreRepository;
    private final CDRepository cdRepository;
    private final DVDRepository dvdRepository;
    private final EmprunteurRepository emprunteurRepository;

    public PreposeService(LivreRepository livreRepository, CDRepository cdRepository, DVDRepository dvdRepository, EmprunteurRepository emprunteurRepository) {
        this.livreRepository = livreRepository;
        this.cdRepository = cdRepository;
        this.dvdRepository = dvdRepository;
        this.emprunteurRepository = emprunteurRepository;
    }

    public void ajouterLivre(String titre, int nombreExemplaires, String ISBN, String auteur, String editeur, int nombrePages) {
        Livre livre = new Livre(titre, nombreExemplaires, ISBN, auteur, editeur, nombrePages);
        livreRepository.save(livre);
    }

    public LivreDTO obtenirLivre(long id) {
        return new LivreDTO(livreRepository.get(id));
    }

    public LivreDTO rechercheLivre(String titre, String auteur) {
        return new LivreDTO(livreRepository.recherche(titre, auteur));
    }

    public void ajouterCD(String titre, int nombreExemplaire, String artiste, int duree, String genre) {
        CD cd = new CD(titre, nombreExemplaire, artiste, duree, genre);
        cdRepository.save(cd);
    }

    public CDDTO obtenirCD(long id) {
        return new CDDTO(cdRepository.get(id));
    }

    public void ajouterDVD(String titre, int nombreExemplaire, String realisateur, int duree, String rating) {
        DVD dvd = new DVD(titre, nombreExemplaire, realisateur, duree, rating);
        dvdRepository.save(dvd);
    }

    public DVDDTO obtenirDVD(long id) {
        return new DVDDTO(dvdRepository.get(id));
    }

    public void ajouterEmprunteur(String nom, String courriel, String telephone) {
        emprunteurRepository.save(new Emprunteur(nom, courriel, telephone));
    }

    public Emprunteur rechercheEmprunteur(String name) {
        return emprunteurRepository.recherche(name);
    }
}