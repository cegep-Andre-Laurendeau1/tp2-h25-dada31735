package ca.cal.tp2.persistance;

import ca.cal.tp2.modele.DVD;

public interface DVDRepository {
    public void save(DVD dvd);
    public DVD get(long id);
}
