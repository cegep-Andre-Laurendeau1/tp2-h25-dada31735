package ca.cal.tp2.persistance;

import ca.cal.tp2.modele.Emprunt;

import java.util.List;

public interface EmpruntRepository {
    public void save(Emprunt emprunt);
    public List<Emprunt> findByEmprunteurId(long id);
}
