package ca.cal.tp2.dto;

import ca.cal.tp2.modele.Livre;
import lombok.Data;

@Data
public class LivreDTO extends DocumentDTO {
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

    @Override
    public Livre toDocument() {
        return new Livre(titre, 1, ISBN, auteur, editeur, nombrePages);
    }
}