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
@DiscriminatorValue("D")
public class DVD extends Document {
    private String director;
    private int duree;
    private String rating;

    public DVD(String titre, int nombreExemplaires, String director, int duree, String rating) {
        super(titre, nombreExemplaires);
        this.director = director;
        this.duree = duree;
        this.rating = rating;
    }
}