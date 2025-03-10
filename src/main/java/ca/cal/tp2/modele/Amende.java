package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
class Amende {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long fineID;
    private double montant;
    private LocalDate dateCreation;
    private boolean status;

    @ManyToOne
    private Emprunteur emprunteur;

    public void calculMontant() {}
    public void updateStatus() {}
}