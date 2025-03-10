package ca.cal.tp2.modele;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("E")
public class Emprunteur extends Utilisateur {
    @OneToMany(mappedBy = "emprunteur")
    private List<Emprunt> emprunts;

    @OneToMany(mappedBy = "emprunteur")
    private List<Amende> amendes;

    public Emprunteur(String nom, String telephone, String courriel) {
        super(nom, courriel, telephone);
    }

    public void emprunte(Document doc) {}
    public void retourneDocument(Document doc) {}
    public void payeAmende(double montant) {}
    public void rapportHistoriqueEmprunt() {}
}
