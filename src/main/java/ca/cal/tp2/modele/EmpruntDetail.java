package ca.cal.tp2.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpruntDetail {
    @Id
    @GeneratedValue
    private long lineItemID;
    private LocalDate dateRetourPrevue;
    private LocalDate dateRetourActuelle;
    private String status;
    @OneToOne
    private Document document;

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