package ca.cal.tp2.persistance;

import ca.cal.tp2.modele.CD;

public interface CDRepository {
    public void save(CD cd);
    public CD get(long id);
}
