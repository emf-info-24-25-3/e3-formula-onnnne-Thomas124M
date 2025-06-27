package models;

import java.text.DecimalFormat;

public class Voiture {
    private int numero;
    private String nomEquipe;

    public Voiture(int numero, String nomEquipe) {
        this.numero = numero;
        this.nomEquipe = nomEquipe;
    }

    public int getNumero() {
        return numero;
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    @Override
    public String toString() {
        DecimalFormat formateur = new DecimalFormat("000");
        return "Voiture N°" + formateur.format(numero) + " de l'équipe '" + nomEquipe + "'";
    }

}
