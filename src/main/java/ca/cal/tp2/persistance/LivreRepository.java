package ca.cal.tp2.persistance;

import ca.cal.tp2.modele.Livre;

public interface LivreRepository {
    public void save(Livre livre);
    public Livre get(long id);
}
