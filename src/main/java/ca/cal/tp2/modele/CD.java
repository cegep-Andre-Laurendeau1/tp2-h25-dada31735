package ca.cal.tp2.modele;

import lombok.Data;

@Data
class CD extends Document {
    private String artiste;
    private int duree;
    private String genre;
}