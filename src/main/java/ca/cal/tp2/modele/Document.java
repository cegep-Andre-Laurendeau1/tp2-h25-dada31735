package ca.cal.tp2.modele;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long documentID;
    private String titre;
    private int nombreExemplaires;

    public Document(String titre, int nombreExemplaires) {
        this.titre = titre;
        this.nombreExemplaires = nombreExemplaires;
    }

    public boolean verifieDisponibilite() {
        return this.nombreExemplaires > 0;
    }
}
