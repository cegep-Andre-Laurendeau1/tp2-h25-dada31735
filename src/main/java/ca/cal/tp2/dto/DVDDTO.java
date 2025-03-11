package ca.cal.tp2.dto;

import ca.cal.tp2.modele.DVD;
import lombok.Data;

@Data
public class DVDDTO extends DocumentDTO {
    private String director;
    private int duree;
    private String rating;

    public DVDDTO(DVD dvd) {
        this.titre = dvd.getTitre();
        this.director = dvd.getDirector();
        this.duree = dvd.getDuree();
        this.rating = dvd.getRating();
    }

    @Override
    public DVD toDocument() {
        return new DVD(titre, 1, director, duree, rating);
    }
}