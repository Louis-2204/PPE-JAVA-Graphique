package modele;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Vehicule;

public class ModeleVehicule {
    private static Bdd uneBdd = new Bdd("54.81.36.203:13392", "autoecole", "alexys", "alexys");

    public static void insertVehicule(Vehicule unVehicule) {
        String requete = "INSERT INTO vehicule VALUES ( '"+ unVehicule.getMatricule() + "','"
                + unVehicule.getType_v() + "','"
                + unVehicule.getModel_v() + "','"
                + unVehicule.getMarque_v() + "','"
                + unVehicule.getAnneimmatri_v() + "','"
                + unVehicule.getAnneachat_v() + "','"
                + unVehicule.getType_boite() + "');";
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            unStat.execute(requete);
            unStat.close();
            uneBdd.seDeconnecter();
        } catch (SQLException exp) {
            System.out.println("Erreur d'execution de la requete : " + requete + exp);
        }
    }

    public static void updateVehicule(Vehicule unVehicule) {
        String requete = "UPDATE vehicule SET"
                + " type_v = '" + unVehicule.getType_v() + "',"
                + " model_v = '" + unVehicule.getModel_v() + "',"
                + " marque_v = '" + unVehicule.getMarque_v() + "',"
                + " anneimmatri_v = '" + unVehicule.getAnneimmatri_v() + "',"
                + " anneachat_v = '" + unVehicule.getAnneachat_v() + "',"
                + " type_boite = '" + unVehicule.getType_boite() + "'"
                + " WHERE matricule = '" + unVehicule.getMatricule() + "';";
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            unStat.execute(requete);
            unStat.close();
            uneBdd.seDeconnecter();
        } catch (SQLException exp) {
            System.out.println("Erreur d'execution de la requete : " + requete + exp);
        }
    }

    public static void deleteVehicule(String matricule) {
        String requete = "DELETE FROM vehicule WHERE matricule = " + matricule + ";";
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            unStat.execute(requete);
            unStat.close();
            uneBdd.seDeconnecter();
        } catch (SQLException exp) {
            System.out.println("Erreur d'execution de la requete : " + requete + exp);
        }
    }

    public static ArrayList<Vehicule> selectAllVehicules() {
        ArrayList<Vehicule> lesVehicules = new ArrayList<Vehicule>();
        String requete = "SELECT * FROM vehicule;";
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            // recuperation des Vehicules
            java.sql.ResultSet desResultats = unStat.executeQuery(requete);
            // on parcours les resultats et on instancie les Vehicules
            while (desResultats.next()) {
                Vehicule unVehicule = new Vehicule(
                        desResultats.getString("matricule"),
                        desResultats.getString("type_v"),
                        desResultats.getString("model_v"),
                        desResultats.getString("marque_v"),
                        desResultats.getString("anneimmatri_v").substring(0, 4),
                        desResultats.getString("anneachat_v").substring(0, 4),
                        desResultats.getString("type_boite"));
                // on ajoute le Vehicule dans l'ArrayList
                lesVehicules.add(unVehicule);
            }
            unStat.close();
            uneBdd.seDeconnecter();
        } catch (SQLException exp) {
            System.out.println("Erreur d'execution de la requete : " + requete + exp);
        }
        return lesVehicules;
    }

    public static Vehicule selectWhereVehicule(String matricule) {
        Vehicule unVehicule = null;
        String requete = "SELECT * FROM vehicule WHERE matricule = " + matricule + ";";
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            // recuperation un seul Vehicule
            java.sql.ResultSet unResultat = unStat.executeQuery(requete);
            // on teste si on a un rÃ©sultat
            if (unResultat.next()) {
                unVehicule = new Vehicule(
                        unResultat.getString("matricule"),
                        unResultat.getString("type_v"),
                        unResultat.getString("model_v"),
                        unResultat.getString("marque_v"),
                        unResultat.getString("anneimmatri_v"),
                        unResultat.getString("anneachat_v"),
                        unResultat.getString("type_boite"));
            }
            unStat.close();
            uneBdd.seDeconnecter();
        } catch (SQLException exp) {
            System.out.println("Erreur d'execution de la requete : " + requete + exp);
        }
        return unVehicule;
    }

    public static Vehicule selectWhereVehicule(String type, String modele, String marque, String anneeImmat,
            String anneeAchat, String typeBoite) {
        Vehicule unVehicule = null;
        String requete = "SELECT * FROM vehicule WHERE type_v = '" + type + "' AND model_v = '" + modele
                + "' AND marque_v = '" + marque + "' AND anneimmatri_v = '" + anneeImmat + "' AND anneachat_v = '"
                + anneeAchat + "' AND type_boite = '"
                + typeBoite + "';";
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            // recuperation un seul Vehicule
            java.sql.ResultSet unResultat = unStat.executeQuery(requete);
            // on teste si on a un rÃ©sultat
            if (unResultat.next()) {
                unVehicule = new Vehicule(
                        unResultat.getString("matricule"),
                        unResultat.getString("type_v"),
                        unResultat.getString("model_v"),
                        unResultat.getString("marque_v"),
                        unResultat.getString("anneimmatri_v").substring(0, 4),
                        unResultat.getString("anneachat_v").substring(0, 4),
                        unResultat.getString("type_boite"));
            }
            unStat.close();
            uneBdd.seDeconnecter();
        } catch (SQLException exp) {
            System.out.println("Erreur d'execution de la requete : " + requete + exp);
        }
        return unVehicule;
    }
}
