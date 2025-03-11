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
public class Emprunt {
    @Id
    @GeneratedValue
    private long borrowID;
    private LocalDate dateEmprunt;
    private String status;

    @ManyToOne
    private Emprunteur emprunteur;

    @OneToMany(mappedBy = "emprunt", cascade = CascadeType.ALL)
    private List<EmpruntDetail> items;

    @Override
    public String toString() {
        return "Emprunt{" +
                "borrowID=" + borrowID +
                ", dateEmprunt=" + dateEmprunt +
                ", status='" + status + '\'' +
                ", items=" + items +
                '}';
    }
}