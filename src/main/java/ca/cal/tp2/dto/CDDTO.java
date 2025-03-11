package ca.cal.tp2.dto;

import ca.cal.tp2.modele.CD;
import lombok.Data;

@Data
public class CDDTO {
    private String titre;
    private String artiste;
    private int duree;
    private String genre;

    public CDDTO(CD cd) {
        this.titre = cd.getTitre();
        this.artiste = cd.getArtiste();
        this.duree = cd.getDuree();
        this.genre = cd.getGenre();
    }
}
