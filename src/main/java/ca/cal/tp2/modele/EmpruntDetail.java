package ca.cal.tp2.modele;

import lombok.Data;

import java.util.Date;

@Data
public class EmpruntDetail {
    private int lineItemID;
    private Date dateRetourPrevue;
    private Date dateRetourActuelle;
    private String status;

    public boolean isEnRetard() {
        return dateRetourActuelle.after(dateRetourPrevue);
    }

    public void calculAmende() {
        System.out.println("Calcul amende");
    }

    public void updateStatus() {
        System.out.println("Update status");
    }
}