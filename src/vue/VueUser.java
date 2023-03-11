package vue;

import java.util.Scanner;

import controleur.User;

public class VueUser {
    public static User saisirUser() {
        String role = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("Saisir le nom de l'user :");
        String nom = sc.nextLine();
        System.out.println("Saisir le prenom de l'user :");
        String prenom = sc.nextLine();
        System.out.println("Saisir la date de naissance de l'user :");
        String datenaissance = sc.nextLine();
        System.out.println("Saisir l'email de l'user :");
        String email = sc.nextLine();
        System.out.println("Saisir le telephone de l'user :");
        String tel = sc.nextLine();
        System.out.println("Saisir l'adresse de l'user :");
        String adresse = sc.nextLine();
        System.out.println("Saisir la ville de l'user :");
        String ville = sc.nextLine();
        System.out.println("Saisir le code postal de l'user :");
        String codepos = sc.nextLine();
        System.out.println("Saisir le sexe de l'user :");
        String sexe = sc.nextLine();
        do {
            System.out.println("Saisir le role de l'user : ('eleve' ou 'moniteur')");
            role = sc.nextLine();
        } while (!role.equals("eleve") && !role.equals("moniteur"));
        System.out.println("Saisir le mot de passe de l'user :");
        String mdp = sc.nextLine();
        System.out.println("Saisir la question de securite de l'user :");
        String security_question = sc.nextLine();
        System.out.println("Saisir la reponse de securite de l'user :");
        String security_answer = sc.nextLine();
        if (role.equals("moniteur")) {
            System.out.println("Saisir la date d'embauche du moniteur :");
            String dateembauche = sc.nextLine();
            System.out.println("Saisir le date d'obtention du BAFM du moniteur :");
            String dateobtentionbafm = sc.nextLine();

            User user = new User(nom, prenom, datenaissance, email, tel, adresse, ville, codepos, sexe, role, mdp,
                    security_question, security_answer, dateembauche, dateobtentionbafm);

            return user;
        }

        // instanciation de la classe Moniteur
        User user = new User(nom, prenom, datenaissance, email, tel, adresse, ville, codepos, sexe, role, mdp,
                security_question, security_answer);

        return user;
    }

    public static void afficherUser(User user) {
        System.out.println("Id de l'user : " + user.getId_u());
        System.out.println("Nom de l'user : " + user.getNom_u());
        System.out.println("Prenom de l'user : " + user.getPrenom_u());
        System.out.println("Date de naissance de l'user : " + user.getDatenaissance_u());
        System.out.println("Email de l'user : " + user.getEmail_u());
        System.out.println("Telephone de l'user : " + user.getTel_u());
        System.out.println("Adresse de l'user : " + user.getAdresse_u());
        System.out.println("Ville de l'user : " + user.getVille_u());
        System.out.println("Code postal de l'user : " + user.getCodepos_u());
        System.out.println("Sexe de l'user : " + user.getSexe_u());
        System.out.println("Role de l'user : " + user.getRole_u());
        System.out.println("Mot de passe de l'user : " + user.getMdp_u());
        System.out.println("Question de securite de l'user : " + user.getSecurity_question());
        System.out.println("Reponse de securite de l'user : " + user.getSecurity_answer());
    }

    public static User modifierUser(User unUser) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ancien nom de l'user : " + unUser.getNom_u());
        System.out.println("Nouveau nom de l'user :");
        unUser.setNom_u(sc.nextLine());

        System.out.println("Ancien prenom de l'user : " + unUser.getPrenom_u());
        System.out.println("Nouveau prenom de l'user :");
        unUser.setPrenom_u(sc.nextLine());

        System.out.println("Ancienne date de naissance de l'user : " + unUser.getDatenaissance_u());
        System.out.println("Nouvelle date de naissance de l'user :");
        unUser.setDatenaissance_u(sc.nextLine());

        System.out.println("Ancien email de l'user : " + unUser.getEmail_u());
        System.out.println("Nouvel email de l'user :");
        unUser.setEmail_u(sc.nextLine());

        System.out.println("Ancien telephone de l'user : " + unUser.getTel_u());
        System.out.println("Nouveau telephone de l'user :");
        unUser.setTel_u(sc.nextLine());

        System.out.println("Ancienne adresse de l'user : " + unUser.getAdresse_u());
        System.out.println("Nouvelle adresse de l'user :");
        unUser.setAdresse_u(sc.nextLine());

        System.out.println("Ancienne ville de l'user : " + unUser.getVille_u());
        System.out.println("Nouvelle ville de l'user :");
        unUser.setVille_u(sc.nextLine());

        System.out.println("Ancien code postal de l'user : " + unUser.getCodepos_u());
        System.out.println("Nouveau code postal de l'user :");
        unUser.setCodepos_u(sc.nextLine());

        System.out.println("Ancien sexe de l'user : " + unUser.getSexe_u());
        System.out.println("Nouveau sexe de l'user :");
        unUser.setSexe_u(sc.nextLine());

        System.out.println("Ancien role de l'user : " + unUser.getRole_u());
        System.out.println("Nouveau role de l'user :");
        unUser.setRole_u(sc.nextLine());

        System.out.println("Ancien mot de passe de l'user : " + unUser.getMdp_u());
        System.out.println("Nouveau mot de passe de l'user :");
        unUser.setMdp_u(sc.nextLine());

        System.out.println("Ancienne question de securite de l'user : " + unUser.getSecurity_question());
        System.out.println("Nouvelle question de securite de l'user :");
        unUser.setSecurity_question(sc.nextLine());

        System.out.println("Ancienne reponse de securite de l'user : " + unUser.getSecurity_answer());
        System.out.println("Nouvelle reponse de securite de l'user :");
        unUser.setSecurity_answer(sc.nextLine());

        return unUser;
    }
}
