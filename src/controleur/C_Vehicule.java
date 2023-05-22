package controleur;

import java.util.ArrayList;
import java.util.Scanner;

import modele.ModeleVehicule;

public class C_Vehicule {
    public static void insertVehicule(Vehicule unVehicule) {
        ModeleVehicule.insertVehicule(unVehicule);
    }

    public static ArrayList<Vehicule> selectAllVehicules() {
        return ModeleVehicule.selectAllVehicules();
    }

    public static void updateVehicule(Vehicule unVehicule) {
        ModeleVehicule.updateVehicule(unVehicule);
    }

    public static void deleteVehicule(String matricule) {
        ModeleVehicule.deleteVehicule(matricule);
    }

    public static Vehicule selectWhereVehicule(String matricule) {
        return ModeleVehicule.selectWhereVehicule(matricule);
    }

    public static Vehicule selectWhereVehicule(String type, String modele, String marque, String anneeImmat,
            String anneeAchat, String typeBoite) {
        return ModeleVehicule.selectWhereVehicule(type, modele, marque, anneeImmat, anneeAchat, typeBoite);
    }
}
