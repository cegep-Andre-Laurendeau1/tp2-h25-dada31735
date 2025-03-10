package ca.cal.tp2.modele;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("C")
public class CD extends Document {
    private String artiste;
    private int duree;
    private String genre;

    public CD(String titre, int nombreExemplaires, String artiste, int duree, String genre) {
        super(titre, nombreExemplaires);
        this.artiste = artiste;
        this.duree = duree;
        this.genre = genre;
    }
}