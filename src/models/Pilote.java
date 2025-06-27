package models;

import java.text.DecimalFormat;

public class Pilote {
    public final static int NOMBRE_PNEUS_EN_RESERVE = 16;
    private String nom;
    private String nationalite;
    private int nombrePoints;
    private int nombreCourses;
    private int nombreVictoires;
    private int nombrePodiums;
    private Pneu[] pneusEnReserve;
    private Voiture voiture;

    public Pilote(String nom, String nationalite) {
        this.nom = nom;
        this.nationalite = nationalite;
        this.pneusEnReserve = new Pneu[0];
        this.nombreCourses = 16;
        this.nombreVictoires = 65;
        this.nombrePodiums = 3;
        this.nombrePoints = 7;
    }

    public Pilote(String nom, String nationalite, Voiture voiture) {
        this.nom = nom;
        this.nationalite = nationalite;
        this.voiture = voiture;
        this.pneusEnReserve = new Pneu[0];
        this.nombreCourses = 16;
        this.nombreVictoires = 65;
        this.nombrePodiums = 3;
        this.nombrePoints = 7;
    }

    public boolean deposerPneuEnReserve(Pneu pneu) {
        boolean reussi = false;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] == null) {
                pneusEnReserve[i] = pneu;
                reussi = true;
                break;
            }
        }
        return reussi;
    }

    public Pneu retirerPneuEnReserve(TypePneu type) {
        Pneu pneuTypeTrouve = null;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (type == pneusEnReserve[i].getType()) {
                pneuTypeTrouve = pneusEnReserve[i];
                pneusEnReserve[i] = null;

            }
        }
        return pneuTypeTrouve;
    }

    public int compterNombrePneusEnReserveDeType(TypePneu type) {
        int compteur = 0;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (type == pneusEnReserve[i].getType()) {
                compteur++;
            }
        }
        return compteur;

    }

    public int getNombrePneusEnReserve() {
        int compteur = 0;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                compteur++;
            }
        }
        return compteur;
    }

    public Pneu[] getPneusEnReserveSansTrous() {
        Pneu[] reserve = new Pneu[pneusEnReserve.length];
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                pneusEnReserve[i] = reserve[i];
                System.out.println(reserve[i]);
            }
        }
        return reserve;
    }

    public String pressionMoyenneDesPneusEnReserveFormatee() {
        double pressionTotale = 0;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            pressionTotale += pneusEnReserve[i].getPression();
        }
        double moyennePression = pressionTotale / getNombrePneusEnReserve();
        DecimalFormat formateur = new DecimalFormat("#.##");

        return formateur.format(moyennePression);
    }

    public int supprimerPneusDePressionInferieure(double pression) {
        int compteur = 0;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i].getPression() < pression) {
                pneusEnReserve[i] = null;
                compteur++;
            }
        }
        return compteur;
    }

    public boolean ajouterLotDePneus(Pneu[] pneus) {
        boolean reussi = false;
        if (pneus != null) {
            int nombrePneuLot = 0;
            for (int i = 0; i < pneus.length; i++) {
                if (pneus[i] != null) {
                    nombrePneuLot++;
                }
            }
            int espaceLibre = NOMBRE_PNEUS_EN_RESERVE - getNombrePneusEnReserve();
            if (nombrePneuLot <= espaceLibre && nombrePneuLot != 0) {
                for (int i = 0; i < pneusEnReserve.length; i++) {
                    if (pneusEnReserve[i] == null) {
                        pneusEnReserve[i] = pneus[i];
                        reussi = true;
                    }
                }
            }
        }

        return reussi;
    }

    public String getNom() {
        return nom;
    }

    public String getNationalite() {
        return nationalite;
    }

    public int getNombrePoints() {
        return nombrePoints;
    }

    public void setNombrePoints(int nombrePoints) {
        this.nombrePoints = nombrePoints;
    }

    public int getNombreCourses() {
        return nombreCourses;
    }

    public void setNombreCourses(int nombreCourses) {
        this.nombreCourses = nombreCourses;
    }

    public int getNombreVictoires() {
        return nombreVictoires;
    }

    public void setNombreVictoires(int nombreVictoires) {
        this.nombreVictoires = nombreVictoires;
    }

    public int getNombrePodiums() {
        return nombrePodiums;
    }

    public void setNombrePodiums(int nombrePodiums) {
        this.nombrePodiums = nombrePodiums;
    }

    @Override
    public String toString() {
        String resultat = "Pilote: " + nom + " (" + nationalite + ")\n";
        if (voiture != null) {
            String nomEquipe = voiture.getNomEquipe();
            int numero = voiture.getNumero();
            resultat += "-> Voiture " + nomEquipe + " (" + numero + ")\n";
            resultat += "-> Points: " + nombrePoints + "\n";
            resultat += "-> Courses: " + nombreCourses + "\n";
            resultat += "-> Victoires: " + nombreVictoires + "\n";
            resultat += "-> Podiums: " + nombrePodiums + "\n";
        } else {
            resultat += "-> Pas de voiture assignée. \n";
        }
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                TypePneu type = pneusEnReserve[i].getType();
                resultat += "-> Pneu en réserve: " + type + "\n";
            }
        }
        return resultat;
    }
}
