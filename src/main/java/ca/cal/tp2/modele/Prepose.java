package ca.cal.tp2.modele;

public class Prepose extends Utilisateur {

    public void entrerNouveauDocument(Document document){
        System.out.println("Entrer un nouveau document");
    }

    public void collecteAmende(Emprunteur emprunteur, double montant) {
        System.out.println("Collecte amende de " + montant + " pour " + emprunteur.getName());
    }

    public void rapportAmendes() {
        System.out.println("Rapport des amendes");
    }

    public void rapportEmprunts() {
        System.out.println("Rapport des emprunts");
    }
}