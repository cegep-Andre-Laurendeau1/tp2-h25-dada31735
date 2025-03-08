package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
class Emprunt {
    @Id
    @GeneratedValue
    private long borrowID;
    private LocalDate dateEmprunt;
    private String status;

    @OneToMany(mappedBy = "emprunt")
    private List<EmpruntDetail> items;
}