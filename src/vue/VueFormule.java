package vue;

import java.util.Scanner;
import controleur.Formule;

public class VueFormule {
    public static Formule saisirFormule() {
        Scanner sc = new Scanner(System.in);
        int choix = 0;
        Formule uneFormule = null;

        do {
            System.out.println("Voulez vous saisir une formule avec type de boite ? (1: oui, 2: non)");
            choix = sc.nextInt();
            if (choix != 1 && choix != 2) {
                System.out.println("Erreur de saisie");
            }
        } while (choix != 1 && choix != 2);

        if (choix == 1) {
            System.out.println("Donner le nom de la formule :");
            String nom_f = sc.next();

            System.out.println("Donner le prix de la formule :");
            float prix_f = sc.nextFloat();

            System.out.println("Donner le nombre d'heures de la formule :");
            float nb_heures = sc.nextFloat();

            System.out.println("Donner le type de boite de la formule (Manuelle / Automatique):");
            String type_boite = sc.next();
            uneFormule = new Formule(nom_f, prix_f, nb_heures, type_boite);

        } else if (choix == 2) {
            System.out.println("Donner le nom de la formule :");
            String nom_f = sc.next();

            System.out.println("Donner le prix de la formule :");
            float prix_f = sc.nextFloat();

            System.out.println("Donner le nombre d'heures de la formule :");
            float nb_heures = sc.nextFloat();

            uneFormule = new Formule(nom_f, prix_f, nb_heures);
        }

        return uneFormule;

    }

    public static void afficherFormule(Formule uneFormule) {
        System.out.println("Nom de la formule : " + uneFormule.getNom_f());
        System.out.println("Prix de la formule : " + uneFormule.getPrix_f());
        System.out.println("Nombre d'heures de la formule : " + uneFormule.getNb_heures());
        System.out.println("Type de boite de la formule : " + uneFormule.getType_boite());
    }

    public static Formule modifierFormule(Formule uneFormule) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ancien nom de la formule : " + uneFormule.getNom_f());
        System.out.println("Nouveau nom de la formule : ");
        uneFormule.setNom_f(sc.next());

        System.out.println("Ancien prix de la formule : " + uneFormule.getPrix_f());
        System.out.println("Nouveau prix de la formule : ");
        uneFormule.setPrix_f(sc.nextFloat());

        System.out.println("Ancien nombre d'heures de la formule : " + uneFormule.getNb_heures());
        System.out.println("Nouveau nombre d'heures de la formule : ");
        uneFormule.setNb_heures(sc.nextFloat());

        System.out.println("Ancien type de boite de la formule : " + uneFormule.getType_boite());
        System.out.println("Nouveau type de boite de la formule (Manuelle / Automatique): ");
        uneFormule.setType_boite(sc.next());

        return uneFormule;
    }
}
