package ca.cal.tp2.modele;

import lombok.Data;

import java.util.Date;

@Data
class Amende {
    private int fineID;
    private double montant;
    private Date dateCreation;
    private boolean status;

    public void calculMontant() {}
    public void updateStatus() {}
}