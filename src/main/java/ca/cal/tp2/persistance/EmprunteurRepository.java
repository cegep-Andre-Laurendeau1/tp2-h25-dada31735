package ca.cal.tp2.persistance;

import ca.cal.tp2.modele.Emprunteur;

public interface EmprunteurRepository {
    public void save(Emprunteur emprunteur);
    public Emprunteur get(long id);
    public Emprunteur recherche(String nom);
    public Emprunteur findByIdWithEmprunts(long emprunteurId);
}
