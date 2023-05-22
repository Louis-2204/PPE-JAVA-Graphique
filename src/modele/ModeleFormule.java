package modele;

import controleur.Formule;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeleFormule {
    private static Bdd uneBdd = new Bdd("54.81.36.203:13392", "autoecole", "alexys", "alexys");

    public static void insertFormule(Formule uneFormule) {
        String requete = "INSERT INTO formule VALUES ( null,'"
                + uneFormule.getNom_f() + "','"
                + uneFormule.getPrix_f() + "','"
                + uneFormule.getNb_heures() + "','"
                + uneFormule.getType_boite() + "');";
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

    public static void updateFormule(Formule uneFormule) {
        String requete = "UPDATE formule SET"
                + " nom_f = '" + uneFormule.getNom_f() + "',"
                + " prix_f = '" + uneFormule.getPrix_f() + "',"
                + " nb_heures = '" + uneFormule.getNb_heures() + "',"
                + " type_boite = '" + uneFormule.getType_boite() + "'"
                + " WHERE id_f = " + uneFormule.getId_f() + ";";
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

    public static void deleteFormule(int id_f) {
        String requete = "DELETE FROM Formule WHERE id_f = " + id_f + ";";
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

    public static ArrayList<Formule> selectAllFormules() {
        ArrayList<Formule> lesFormules = new ArrayList<Formule>();
        String requete = "SELECT * FROM formule;";
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            // recuperation des Formules
            java.sql.ResultSet desResultats = unStat.executeQuery(requete);
            // on parcours les resultats et on instancie les Formules
            while (desResultats.next()) {
                Formule uneFormule = new Formule(
                        desResultats.getInt("id_f"),
                        desResultats.getString("nom_f"),
                        desResultats.getFloat("prix_f"),
                        desResultats.getFloat("nb_heures"),
                        desResultats.getString("type_boite"));
                // on ajoute le Formule dans l'ArrayList
                lesFormules.add(uneFormule);
            }
            unStat.close();
            uneBdd.seDeconnecter();
        } catch (SQLException exp) {
            System.out.println("Erreur d'execution de la requete : " + requete + exp);
        }
        return lesFormules;
    }

    public static Formule selectWhereFormule(int id_f) {
        Formule uneFormule = null;
        String requete = "SELECT * FROM Formule WHERE id_f = " + id_f + ";";
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            // recuperation un seul Formule
            java.sql.ResultSet unResultat = unStat.executeQuery(requete);
            // on teste si on a un rÃ©sultat
            if (unResultat.next()) {
                uneFormule = new Formule(
                        unResultat.getInt("id_f"),
                        unResultat.getString("nom_f"),
                        unResultat.getFloat("prix_f"),
                        unResultat.getFloat("nb_heures"),
                        unResultat.getString("type_boite"));
            }
            unStat.close();
            uneBdd.seDeconnecter();
        } catch (SQLException exp) {
            System.out.println("Erreur d'execution de la requete : " + requete + exp);
        }
        return uneFormule;
    }

    public static Formule selectWhereFormule(String nom, Float prix, Float nbHeures, String typeBoite) {
        Formule uneFormule = null;
        String requete = "SELECT * FROM formule WHERE nom_f = '" + nom + "' AND prix_f = '" + prix
                + "' AND nb_heures = '" + nbHeures + "' AND type_boite = '" + typeBoite + "';";
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            // recuperation un seul Formule
            java.sql.ResultSet unResultat = unStat.executeQuery(requete);
            // on teste si on a un rÃ©sultat
            if (unResultat.next()) {
                uneFormule = new Formule(
                        unResultat.getInt("id_f"),
                        unResultat.getString("nom_f"),
                        unResultat.getFloat("prix_f"),
                        unResultat.getFloat("nb_heures"),
                        unResultat.getString("type_boite"));
            }
            unStat.close();
            uneBdd.seDeconnecter();
        } catch (SQLException exp) {
            System.out.println("Erreur d'execution de la requete : " + requete + exp);
        }
        return uneFormule;
    }
}
