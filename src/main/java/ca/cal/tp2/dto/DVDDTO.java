package ca.cal.tp2.dto;

import ca.cal.tp2.modele.DVD;
import lombok.Data;

@Data
public class DVDDTO {
    private String titre;
    private String director;
    private int duree;
    private String rating;

    public DVDDTO(DVD dvd) {
        this.titre = dvd.getTitre();
        this.director = dvd.getDirector();
        this.duree = dvd.getDuree();
        this.rating = dvd.getRating();
    }
}
