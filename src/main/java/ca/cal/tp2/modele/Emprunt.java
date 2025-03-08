package ca.cal.tp2.modele;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
class Emprunt {
    private int borrowID;
    private Date dateEmprunt;
    private String status;
    private List<EmpruntDetail> items;
}