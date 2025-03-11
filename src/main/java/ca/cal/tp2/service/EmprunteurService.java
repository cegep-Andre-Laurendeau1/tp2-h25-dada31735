package ca.cal.tp2.service;

import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Emprunteur;
import ca.cal.tp2.modele.Emprunt;
import ca.cal.tp2.modele.EmpruntDetail;
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
            detail.setDateRetourPrevue(LocalDate.now().plusWeeks(2));
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

    public List<Emprunt> obtenirEmprunts(long emprunteurId) {
        return empruntRepository.findByEmprunteurId(emprunteurId);
    }
}