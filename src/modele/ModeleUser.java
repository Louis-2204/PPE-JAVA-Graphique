package modele;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.User;

public class ModeleUser {
    private static Bdd uneBdd = new Bdd("localhost", "autoecole", "root", "");

    public static void insertUser(User unUser) {
        String requete = "INSERT INTO user VALUES ( null,'"
                + unUser.getNom_u() + "','"
                + unUser.getPrenom_u() + "','"
                + unUser.getDatenaissance_u() + "','"
                + unUser.getEmail_u() + "','"
                + unUser.getTel_u() + "','"
                + unUser.getAdresse_u() + "','"
                + unUser.getVille_u() + "','"
                + unUser.getCodepos_u() + "','"
                + unUser.getSexe_u() + "','"
                + unUser.getRole_u() + "','"
                + unUser.getMdp_u() + "','"
                + unUser.getSecurity_question() + "','"
                + unUser.getSecurity_answer() + "');";
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            unStat.execute(requete);
            unStat.close();
            uneBdd.seDeconnecter();
        } catch (SQLException exp) {
            System.out.println("Erreur d'execution de la requete : " + requete);
        }
    }

    public static void updateUser(User unUser) {
        String requete = "UPDATE user SET"
                + " nom_u = '" + unUser.getNom_u() + "',"
                + " prenom_u = '" + unUser.getPrenom_u() + "',"
                + " datenaissance_u = '" + unUser.getDatenaissance_u() + "',"
                + " email_u = '" + unUser.getEmail_u() + "',"
                + " tel_u = '" + unUser.getTel_u() + "',"
                + " adresse_u = '" + unUser.getAdresse_u() + "',"
                + " ville_u = '" + unUser.getVille_u() + "',"
                + " codepos_u = '" + unUser.getCodepos_u() + "',"
                + " sexe_u = '" + unUser.getSexe_u() + "',"
                + " role_u = '" + unUser.getRole_u() + "',"
                + " mdp_u = '" + unUser.getMdp_u() + "',"
                + " security_question = '" + unUser.getSecurity_question() + "',"
                + " security_answer = '" + unUser.getSecurity_answer() + "'"
                + " WHERE id_u = " + unUser.getId_u() + ";";
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            unStat.execute(requete);
            unStat.close();
            uneBdd.seDeconnecter();
        } catch (SQLException exp) {
            System.out.println("Erreur d'execution de la requete : " + requete);
        }
    }

    public static void deleteUser(int id_u) {
        String requete = "DELETE FROM user WHERE id_u = " + id_u + ";";
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            unStat.execute(requete);
            unStat.close();
            uneBdd.seDeconnecter();
        } catch (SQLException exp) {
            System.out.println("Erreur d'execution de la requete : " + requete);
        }
    }

    public static ArrayList<User> selectAllUsers() {
        ArrayList<User> lesUsers = new ArrayList<User>();
        String requete = "SELECT * FROM User;";
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            // recuperation des Users
            java.sql.ResultSet desResultats = unStat.executeQuery(requete);
            // on parcours les resultats et on instancie les Users
            while (desResultats.next()) {
                User unUser = new User(
                        desResultats.getInt("id_u"),
                        desResultats.getString("nom_u"),
                        desResultats.getString("prenom_u"),
                        desResultats.getString("datenaissance_u"),
                        desResultats.getString("email_u"),
                        desResultats.getString("tel_u"),
                        desResultats.getString("adresse_u"),
                        desResultats.getString("ville_u"),
                        desResultats.getString("codepos_u"),
                        desResultats.getString("sexe_u"),
                        desResultats.getString("role_u"),
                        desResultats.getString("mdp_u"),
                        desResultats.getString("security_question"),
                        desResultats.getString("security_answer"));
                // on ajoute le User dans l'ArrayList
                lesUsers.add(unUser);
            }
            unStat.close();
            uneBdd.seDeconnecter();
        } catch (SQLException exp) {
            System.out.println("Erreur d'execution de la requete : " + requete);
        }
        return lesUsers;
    }

    public static User selectWhereUser(int id_u) {
        User unUser = null;
        String requete = "SELECT * FROM user WHERE id_u = " + id_u + ";";
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            // recuperation un seul User
            java.sql.ResultSet unResultat = unStat.executeQuery(requete);
            // on teste si on a un rÃ©sultat
            if (unResultat.next()) {
                unUser = new User(
                        unResultat.getInt("id_u"),
                        unResultat.getString("nom_u"),
                        unResultat.getString("prenom_u"),
                        unResultat.getString("datenaissance_u"),
                        unResultat.getString("email_u"),
                        unResultat.getString("tel_u"),
                        unResultat.getString("adresse_u"),
                        unResultat.getString("ville_u"),
                        unResultat.getString("codepos_u"),
                        unResultat.getString("sexe_u"),
                        unResultat.getString("role_u"),
                        unResultat.getString("mdp_u"),
                        unResultat.getString("security_question"),
                        unResultat.getString("security_answer"));
            }
            unStat.close();
            uneBdd.seDeconnecter();
        } catch (SQLException exp) {
            System.out.println("Erreur d'execution de la requete : " + requete);
        }
        return unUser;
    }

    public static User selectWhereUser(String email_u, String mdp_u) {
        User unUser = null;
        String requete = "SELECT * FROM user WHERE email_u = '" + email_u + "' AND mdp_u = '" + mdp_u + "';";
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            // recuperation un seul User
            java.sql.ResultSet unResultat = unStat.executeQuery(requete);
            // on teste si on a un rÃ©sultat
            if (unResultat.next()) {
                unUser = new User(
                        unResultat.getInt("id_u"),
                        unResultat.getString("nom_u"),
                        unResultat.getString("prenom_u"),
                        unResultat.getString("datenaissance_u"),
                        unResultat.getString("email_u"),
                        unResultat.getString("tel_u"),
                        unResultat.getString("adresse_u"),
                        unResultat.getString("ville_u"),
                        unResultat.getString("codepos_u"),
                        unResultat.getString("sexe_u"),
                        unResultat.getString("role_u"),
                        unResultat.getString("mdp_u"),
                        unResultat.getString("security_question"),
                        unResultat.getString("security_answer"));
            }
            unStat.close();
            uneBdd.seDeconnecter();
        } catch (SQLException exp) {
            System.out.println("Erreur d'execution de la requete : " + requete);
        }
        return unUser;
    }

    public static void insertMoniteurInfos(int id_u, String dateembauche, String dateobtentionbafm) {
        String requete = "INSERT INTO moniteur (id_u, dateembauche, dateobtentionbafm) VALUES ('" + id_u + "', '"
                + dateembauche + "', '" + dateobtentionbafm + "');";
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            unStat.execute(requete);
            unStat.close();
            uneBdd.seDeconnecter();
        } catch (SQLException exp) {
            System.out.println("Erreur d'execution de la requete : " + requete);
        }
    }

    public static String[] selectMoniteurInfos(int id_u) {
        String infos[] = null;
        String requete = "SELECT * FROM moniteur WHERE id_u = " + id_u + ";";
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            // recuperation un seul User
            java.sql.ResultSet unResultat = unStat.executeQuery(requete);
            // on teste si on a un rÃ©sultat
            if (unResultat.next()) {
                infos[0] = unResultat.getString("dateembauche");
                infos[1] = unResultat.getString("dateobtentionbafm");
            }
            unStat.close();
            uneBdd.seDeconnecter();
        } catch (SQLException exp) {
            System.out.println("Erreur d'execution de la requete : " + requete);
        }
        return infos;
    }
}
