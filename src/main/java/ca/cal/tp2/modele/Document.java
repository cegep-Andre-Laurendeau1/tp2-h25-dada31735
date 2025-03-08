package ca.cal.tp2.modele;

import lombok.Data;

@Data
public abstract class Document {
    private int documentID;
    private String titre;
    private int nombreExemplaires;

    public boolean verifieDisponibilite() {
        return this.nombreExemplaires > 0;
    }
}
