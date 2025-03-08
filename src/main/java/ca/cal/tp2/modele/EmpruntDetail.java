package ca.cal.tp2.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class EmpruntDetail {
    @Id
    @GeneratedValue
    private long lineItemID;
    private LocalDate dateRetourPrevue;
    private LocalDate dateRetourActuelle;
    private String status;

    public boolean isEnRetard() {
        return dateRetourActuelle.isAfter(dateRetourPrevue);
    }

    public void calculAmende() {
        System.out.println("Calcul amende");
    }

    public void updateStatus() {
        System.out.println("Update status");
    }
}