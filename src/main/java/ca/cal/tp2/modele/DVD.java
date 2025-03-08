package ca.cal.tp2.modele;

import lombok.Data;

@Data
class DVD extends Document {
    private String director;
    private int duree;
    private String rating;
}