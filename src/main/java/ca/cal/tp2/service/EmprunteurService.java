package ca.cal.tp2.service;

import ca.cal.tp2.modele.*;
import ca.cal.tp2.persistance.EmpruntRepository;
import ca.cal.tp2.persistance.EmprunteurRepository;

import java.time.LocalDate;
import java.util.List;

public class EmprunteurService {
    private final EmpruntRepository empruntRepository;
    private final EmprunteurRepository emprunteurRepository;

    public EmprunteurService(EmpruntRepository empruntRepository, EmprunteurRepository emprunteurRepository) {
        this.empruntRepository = empruntRepository;
        this.emprunteurRepository = emprunteurRepository;
    }

    public void emprunterDocument(long emprunteurId, Document document) {
        Emprunteur emprunteur = emprunteurRepository.findByIdWithEmprunts(emprunteurId);
        if (document.verifieDisponibilite()) {
            Emprunt emprunt = new Emprunt();
            emprunt.setDateEmprunt(LocalDate.now());
            emprunt.setStatus("En cours");
            emprunt.setEmprunteur(emprunteur);

            EmpruntDetail detail = new EmpruntDetail();
            detail.setDocument(document);
            detail.setDateRetourPrevue(LocalDate.now().plusWeeks(getBorrowingPeriod(document)));
            detail.setStatus("Emprunté");
            detail.setEmprunt(emprunt);

            emprunt.setItems(List.of(detail));
            emprunteur.getEmprunts().add(emprunt);

            document.setNombreExemplaires(document.getNombreExemplaires() - 1);
            empruntRepository.save(emprunt);
        } else {
            throw new RuntimeException("No copies available");
        }
    }

    private int getBorrowingPeriod(Document document) {
        if (document instanceof Livre) {
            return 3;
        } else if (document instanceof CD) {
            return 2;
        } else if (document instanceof DVD) {
            return 1;
        }
        return 0;
    }

    public List<Emprunt> obtenirEmprunts(long emprunteurId) {
        return empruntRepository.findByEmprunteurId(emprunteurId);
    }
}