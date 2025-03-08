package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Entity
@Getter
@Setter
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