package ca.cal.tp2.dto;

import ca.cal.tp2.modele.Document;

public abstract class DocumentDTO {
    String titre;

    public abstract Document toDocument();
}