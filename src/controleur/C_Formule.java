package controleur;

import java.util.ArrayList;
import java.util.Scanner;
import modele.ModeleFormule;
import vue.VueFormule;

public class C_Formule {
    public static void insertFormule(Formule uneFormule) {
        ModeleFormule.insertFormule(uneFormule);
    }

    public static ArrayList<Formule> selectAllFormules() {
        return ModeleFormule.selectAllFormules();
    }

    public static void updateFormule(Formule uneFormule) {
        ModeleFormule.updateFormule(uneFormule);
    }

    public static void deleteFormule(int idFormule) {
        ModeleFormule.deleteFormule(idFormule);
    }

    public static Formule selectWhereFormule(int idFormule) {
        return ModeleFormule.selectWhereFormule(idFormule);
    }

    public static Formule selectWhereFormule(String nom, Float prix, Float nbHeures, String typeBoite) {
        return ModeleFormule.selectWhereFormule(nom, prix, nbHeures, typeBoite);
    }
}
