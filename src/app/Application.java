package app;

import models.*;

public class Application {

    public static void main(String[] args) {
        // ---------------------------------------------------------------------------------------
        // Etape 1 : Création d'une voiture de Formule 1
        // ---------------------------------------------------------------------------------------
        Voiture formule1 = new Voiture(16, "Ferrari");
        // ---------------------------------------------------------------------------------------
        // Etape 2 : Afficher la voiture
        // ---------------------------------------------------------------------------------------
        System.out.println(formule1);
        // ---------------------------------------------------------------------------------------
        // Etape 3 : Création d'un pilote de Formule 1 et afficher ses informations
        // ---------------------------------------------------------------------------------------
        Pilote piloteFormule1 = new Pilote("Charles Leclerc", "Monégasque", formule1);
        // ---------------------------------------------------------------------------------------
        // Etape 4 : Afficher le Pilote
        // ---------------------------------------------------------------------------------------
        System.out.println(piloteFormule1);
        // ---------------------------------------------------------------------------------------
        // Etape 5 : Tests des méthodes de la classe Pilote
        // ---------------------------------------------------------------------------------------
        Pneu pneuType1 = new Pneu(TypePneu.DUR_BLANC, 1.5);
        Pneu pneuType2 = new Pneu(TypePneu.MEDIUM_JAUNE, 1.8);
        Pneu pneuType3 = new Pneu(TypePneu.TENDRE_ROUGE, 2.0);
        Pneu pneuType4 = new Pneu(TypePneu.DUR_BLANC, 1.6);
        Pneu pneuType5 = new Pneu(TypePneu.MEDIUM_JAUNE, 1.7);
        // deposerPneuEnReserve() 5 fois de types différents
        piloteFormule1.deposerPneuEnReserve(pneuType1);
        piloteFormule1.deposerPneuEnReserve(pneuType2);
        piloteFormule1.deposerPneuEnReserve(pneuType3);
        piloteFormule1.deposerPneuEnReserve(pneuType4);
        piloteFormule1.deposerPneuEnReserve(pneuType5);
        // retirerPneuEnReserve() de type TENDRE_ROUGE et l'afficher
        piloteFormule1.retirerPneuEnReserve(TypePneu.TENDRE_ROUGE);
        System.out.print("Le pneu TENDRE_ROUGE qui a été retiré : Pneu ");
        System.out.println(pneuType3);
        // getNombrePneusEnReserve() et afficher le nombre de pneus en réserve
        System.out.println("Nombre de pneus en réserve : " + piloteFormule1.getNombrePneusEnReserve());
        // getPneusEnReserveSansTrous() et afficher les pneus en réserve
        piloteFormule1.getPneusEnReserveSansTrous();
        System.out.println("Pneus en réserve sans trous : ");
        System.out.println("-" +pneuType1);
        System.out.println("-" +pneuType2);
        System.out.println("-" +pneuType3);
        System.out.println("-" +pneuType4);
        // pressionMoyenneDesPneusEnReserveFormatee() et afficher la pression moyenne
        // des
        // pneus
        System.out.println(
                "Pression moyenne des pneus en réserve : " + piloteFormule1.pressionMoyenneDesPneusEnReserveFormatee());
        // compterNombrePneusEnReserveDeType() et afficher le nombre de pneus en réserve
        // de type DUR_BLANC
        System.out.println("Nombre de pneus en réserve de type DUR_BLANC : "
                + piloteFormule1.compterNombrePneusEnReserveDeType(TypePneu.DUR_BLANC));
        // Créer les 3 pneus et ajout le lot de pneus pour le pilote et afficher réussi
        // ou échoué
        Pneu[] lotPneu = new Pneu[3];
        lotPneu[0] = new Pneu(TypePneu.DUR_BLANC, 1.3);
        lotPneu[1] = new Pneu(TypePneu.DUR_BLANC, 1.2);
        lotPneu[2] = new Pneu(TypePneu.DUR_BLANC, 1.1);

        if (piloteFormule1.ajouterLotDePneus(lotPneu)) {
            System.out.println("Ajout du lot de pneus réussi :-)");
        } else {
            System.out.println("Ajout du lot de pneus échoué :-(");
        }
        ;
        // Supprimer les pneus de pression inférieure à 1.4 et afficher le nombre de
        // pneus supprimés
        piloteFormule1.supprimerPneusDePressionInferieure(1.4);
        System.out.print("Nombre de pneus supprimés de pression inférieure à 1.4 : ");
        System.out.println(piloteFormule1.supprimerPneusDePressionInferieure(1.4));

        // ---------------------------------------------------------------------------------------

    }

}
