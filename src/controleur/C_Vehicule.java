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

    public static void deleteVehicule(int idVehicule) {
        ModeleVehicule.deleteVehicule(idVehicule);
    }

    public static Vehicule selectWhereVehicule(int idVehicule) {
        return ModeleVehicule.selectWhereVehicule(idVehicule);
    }

    public static Vehicule selectWhereVehicule(String type, String modele, String marque, String anneeImmat,
            String anneeAchat) {
        return ModeleVehicule.selectWhereVehicule(type, modele, marque, anneeImmat, anneeAchat);
    }
}
