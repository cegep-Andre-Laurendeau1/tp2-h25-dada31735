package ca.cal.tp2.modele;

import jakarta.persistence.*;
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

    @ManyToOne
    private Emprunt emprunt;

    public boolean isEnRetard() {
        return dateRetourActuelle.isAfter(dateRetourPrevue);
    }

    public void calculAmende() {
        System.out.println("Calcul amende");
    }

    public void updateStatus() {
        System.out.println("Update status");
    }

    @Override
    public String toString() {
        return "EmpruntDetail{" +
                "lineItemID=" + lineItemID +
                ", dateRetourPrevue=" + dateRetourPrevue +
                ", status='" + status + '\'' +
                ", document=" + document.getTitre() +
                '}';
    }
}