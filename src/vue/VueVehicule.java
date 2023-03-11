package vue;

import java.util.Scanner;

import controleur.Vehicule;

public class VueVehicule {
    public static Vehicule saisirVehicule() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Donner le type du vehicule :");
        String type_v = sc.next();

        System.out.println("Donner le modèle du vehicule :");
        String model_v = sc.next();

        System.out.println("Donner la marque du vehicule :");
        String marque_v = sc.next();

        System.out.println("Donner l'année d'immatriculation du vehicule :");
        String annneimmatri_v = sc.next();

        System.out.println("Donner l'année d'achat du vehicule :");
        String anneachat_v = sc.next();

        Vehicule unVehicule = new Vehicule(type_v, model_v, marque_v, annneimmatri_v, anneachat_v);
        return unVehicule;
    }

    public static void afficherVehicule(Vehicule unVehicule) {
        System.out.println("Type du vehicule : " + unVehicule.getType_v());
        System.out.println("Modèle du vehicule : " + unVehicule.getModel_v());
        System.out.println("Marque du vehicule : " + unVehicule.getMarque_v());
        System.out.println("Année d'immatriculation du vehicule : " + unVehicule.getAnnneimmatri_v());
        System.out.println("Année d'achat du vehicule : " + unVehicule.getAnneachat_v());
    }

    public static Vehicule modifierVehicule(Vehicule unVehicule) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ancien type du vehicule : " + unVehicule.getType_v());
        System.out.println("Nouveau type du vehicule :");
        unVehicule.setType_v(sc.next());

        System.out.println("Ancien modèle du vehicule : " + unVehicule.getModel_v());
        System.out.println("Nouveau modèle du vehicule :");
        unVehicule.setModel_v(sc.next());

        System.out.println("Ancienne marque du vehicule : " + unVehicule.getMarque_v());
        System.out.println("Nouvelle marque du vehicule :");
        unVehicule.setMarque_v(sc.next());

        System.out.println("Ancienne année d'immatriculation du vehicule : " + unVehicule.getAnnneimmatri_v());
        System.out.println("Nouvelle année d'immatriculation du vehicule :");
        unVehicule.setAnnneimmatri_v(sc.next());

        System.out.println("Ancienne année d'achat du vehicule : " + unVehicule.getAnneachat_v());
        System.out.println("Nouvelle année d'achat du vehicule :");
        unVehicule.setAnneachat_v(sc.next());

        return unVehicule;
    }
}
