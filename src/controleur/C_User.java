package controleur;

import java.util.ArrayList;
import java.util.Scanner;

import modele.ModeleUser;
import vue.VueUser;

public class C_User {

    public static void insertUser(User unUser) {
        ModeleUser.insertUser(unUser);
    }

    public static ArrayList<User> selectAllUsers() {
        return ModeleUser.selectAllUsers();
    }

    public static void updateUser(User unUser) {
        ModeleUser.updateUser(unUser);
    }

    public static void deleteUser(int idUser) {
        ModeleUser.deleteUser(idUser);
    }

    public static User selectWhereUser(int idUser) {
        return ModeleUser.selectWhereUser(idUser);
    }

    public static User selectWhereUser(String email, String mdp) {
        return ModeleUser.selectWhereUser(email, mdp);
    }

    public static void insertMoniteurInfos(int id_u, String dateembauche, String dateobtentionbafm) {
        ModeleUser.insertMoniteurInfos(id_u, dateembauche, dateobtentionbafm);
    }

    public static String[] selectMoniteurInfos(int id_u) {
        return ModeleUser.selectMoniteurInfos(id_u);
    }
}
