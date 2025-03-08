package ca.cal.tp2.modele;

import lombok.Data;

@Data
class Emprunteur extends Utilisateur {
    public void emprunte(Document doc) {}
    public void retourneDocument(Document doc) {}
    public void payeAmende(double montant) {}
    public void rapportHistoriqueEmprunt() {}
}
