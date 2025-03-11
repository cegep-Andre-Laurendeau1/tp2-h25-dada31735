package ca.cal.tp2.dto;

import ca.cal.tp2.modele.Livre;
import lombok.Data;

@Data
public class LivreDTO {
    private String titre;
    private String ISBN;
    private String auteur;
    private String editeur;
    private int nombrePages;

    public LivreDTO(Livre livre) {
        this.titre = livre.getTitre();
        this.ISBN = livre.getISBN();
        this.auteur = livre.getAuteur();
        this.editeur = livre.getEditeur();
        this.nombrePages = livre.getNombrePages();
    }
}
