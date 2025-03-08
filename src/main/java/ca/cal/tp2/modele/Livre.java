package ca.cal.tp2.modele;

import lombok.Data;

@Data
public class Livre extends Document {
    private String ISBN;
    private String auteur;
    private String editeur;
    private int nombrePages;
}
