package ca.cal.tp2.modele;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long documentID;
    private String titre;
    private int nombreExemplaires;

    public boolean verifieDisponibilite() {
        return this.nombreExemplaires > 0;
    }
}
