package vue;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import controleur.C_User;
import controleur.Tableau;
import controleur.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PanelMoniteur extends PanelPrincipal implements ActionListener {

    private JPanel panelForm = new JPanel();
    private JPanel panelWrap = new JPanel();
    private JTextField txtNom = new JTextField();
    private JTextField txtPrenom = new JTextField();
    private JTextField txtDateNaissance = new JTextField();
    private JTextField txtEmail = new JTextField();
    private JTextField txtTel = new JTextField();
    private JTextField txtAdresse = new JTextField();
    private JTextField txtVille = new JTextField();
    private JTextField txtCodePostal = new JTextField();
    private JComboBox<String> cbxSexe = new JComboBox<String>();
    private JTextField txtDateembauche = new JTextField();
    private JTextField txtDateobtentionbafm = new JTextField();
    private JPasswordField txtMdp = new JPasswordField();

    private JButton btnAnnuler = new JButton("Annuler");
    private JButton btnEnregistrer = new JButton("Enregistrer");

    private JTable tableUser;
    private Tableau unTableau;

    public PanelMoniteur() {
        super();
        this.titre.setText("_______ Moniteurs _______");

        // construction du panel form

        this.panelForm.setBounds(40, 60, 350, 250);
        this.panelForm.setBackground(new Color(43, 140, 82));
        this.panelForm.setLayout(new GridLayout(13, 2, 10, 10));

        this.panelForm.add(new JLabel("Nom: "));
        this.panelForm.add(this.txtNom);
        this.panelForm.add(new JLabel("Prenom: "));
        this.panelForm.add(this.txtPrenom);
        this.panelForm.add(new JLabel("Email: "));
        this.panelForm.add(this.txtEmail);
        this.panelForm.add(new JLabel("Téléphone: "));
        this.panelForm.add(this.txtTel);
        this.panelForm.add(new JLabel("Date de naissance: "));
        this.panelForm.add(this.txtDateNaissance);
        this.panelForm.add(new JLabel("Adresse: "));
        this.panelForm.add(this.txtAdresse);
        this.panelForm.add(new JLabel("Ville: "));
        this.panelForm.add(this.txtVille);
        this.panelForm.add(new JLabel("Code postal: "));
        this.panelForm.add(this.txtCodePostal);
        this.panelForm.add(new JLabel("Sexe: "));
        this.panelForm.add(this.cbxSexe);
        this.panelForm.add(new JLabel("Date d'embauche: "));
        this.panelForm.add(this.txtDateembauche);
        this.panelForm.add(new JLabel("Date d'obtention du BAFM: "));
        this.panelForm.add(this.txtDateobtentionbafm);
        this.panelForm.add(new JLabel("Mot de passe: "));
        this.panelForm.add(this.txtMdp);
        this.panelForm.add(this.btnAnnuler);
        this.panelForm.add(this.btnEnregistrer);

        // construction de la JTable
        String entetes[] = { "ID User", "Nom", "Prenom", "Email", "Téléphone", "Date de naissance", "Adresse", "Ville",
                "Code postal", "Sexe", "Date d'embauche", "Date d'obtention du BAFM" };
        Object donnees[][] = this.getDonnees();

        this.unTableau = new Tableau(donnees, entetes);
        this.tableUser = new JTable(unTableau);

        this.tableUser.setShowGrid(false);
        this.tableUser.setShowVerticalLines(true);

        this.tableUser.setBackground(new Color(255, 255, 255));

        JScrollPane unScroll = new JScrollPane(this.tableUser);

        // remplir le CBX Sexe
        this.remplirCBX();

        // ajout du panel wrap au panel client
        this.panelWrap.add(this.panelForm);
        this.panelWrap.add(unScroll);

        this.panelWrap.setLayout(new GridLayout(2, 1, 10, 20));

        this.panelWrap.setBackground(new Color(43, 140, 82));

        JScrollPane scrollPrincipal = new JScrollPane(this.panelWrap);
        scrollPrincipal.setBounds(50, 80, 715, 350);
        scrollPrincipal.setBorder(null);

        this.add(scrollPrincipal);

        // rendre les boutons cliquables
        this.btnAnnuler.addActionListener(this);
        this.btnEnregistrer.addActionListener(this);
    }

    public Object[][] getDonnees() {
        String infos[] = null;
        ArrayList<User> lesUsers = C_User.selectAllUsers("moniteur");
        Object[][] matrice = new Object[lesUsers.size()][12];
        int i = 0;
        for (User unUser : lesUsers) {
            infos = C_User.selectMoniteurInfos(unUser.getId_u());
            matrice[i][0] = unUser.getId_u();
            matrice[i][1] = unUser.getNom_u();
            matrice[i][2] = unUser.getPrenom_u();
            matrice[i][3] = unUser.getEmail_u();
            matrice[i][4] = unUser.getTel_u();
            matrice[i][5] = unUser.getDatenaissance_u();
            matrice[i][6] = unUser.getAdresse_u();
            matrice[i][7] = unUser.getVille_u();
            matrice[i][8] = unUser.getCodepos_u();
            matrice[i][9] = unUser.getSexe_u();
            matrice[i][10] = infos[0];
            matrice[i][11] = infos[1];
            i++;
        }
        return matrice;
    }

    public void remplirCBX() {
        // supprimer ou vider le CBX Sexe
        this.cbxSexe.removeAllItems();

        // remplir le CBX Sexe
        this.cbxSexe.addItem("M");
        this.cbxSexe.addItem("F");
        this.cbxSexe.addItem("Ne souhaite pas répondre");
    }

    public void viderChamps() {
        this.txtNom.setText("");
        this.txtPrenom.setText("");
        this.txtEmail.setText("");
        this.txtTel.setText("");
        this.txtDateNaissance.setText("");
        this.txtAdresse.setText("");
        this.txtVille.setText("");
        this.txtCodePostal.setText("");
        this.cbxSexe.setSelectedIndex(0);
        this.txtMdp.setText("");
        this.txtDateembauche.setText("");
        this.txtDateobtentionbafm.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btnAnnuler) {
            this.viderChamps();
        } else if (e.getSource() == this.btnEnregistrer) {
            if (this.txtNom.getText().equals("") || this.txtPrenom.getText().equals("")
                    || this.txtEmail.getText().equals("") || this.txtTel.getText().equals("")
                    || this.txtDateNaissance.getText().equals("") || this.txtAdresse.getText().equals("")
                    || this.txtVille.getText().equals("") || this.txtCodePostal.getText().equals("")
                    || this.txtMdp.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs", "Erreur",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                String nom = this.txtNom.getText();
                String prenom = this.txtPrenom.getText();
                String email = this.txtEmail.getText();
                String tel = this.txtTel.getText();
                String datenaissance = this.txtDateNaissance.getText();
                String adresse = this.txtAdresse.getText();
                String ville = this.txtVille.getText();
                String codepos = this.txtCodePostal.getText();
                String sexe = this.cbxSexe.getSelectedItem().toString();
                String mdp = this.txtMdp.getText();

                String dateEmbauche = this.txtDateembauche.getText();
                String dateBAFM = this.txtDateobtentionbafm.getText();

                // instancier un User
                User unUser = new User(nom, prenom, datenaissance, email, tel, adresse, ville, codepos,
                        sexe, "moniteur", mdp, "Temporaire", "Temporaire");

                // on l'enregistre dans la base de donnÃ©es
                C_User.insertUser(unUser);

                // cryptage du mot de passe
                try {
                    MessageDigest md = MessageDigest.getInstance("SHA-1");
                    md.update(mdp.getBytes());
                    byte[] digest = md.digest();
                    StringBuffer sb = new StringBuffer();
                    for (byte b : digest) {
                        sb.append(String.format("%02x", b & 0xff));
                    }
                    mdp = sb.toString();
                } catch (NoSuchAlgorithmException ex) {
                    ex.printStackTrace();
                }

                // rÃ©cupÃ©rer l'id de l'User insÃ©rÃ© Ã  partir de la BDD
                unUser = C_User.selectWhereUser(email, mdp);

                // on ajoute les infos dans la table moniteur
                C_User.insertMoniteurInfos(unUser.getId_u(), dateEmbauche, dateBAFM);

                // on récupère les infos du moniteur
                String infos[] = C_User.selectMoniteurInfos(unUser.getId_u());

                // on recharge la JTable
                Object ligne[] = { unUser.getId_u(), unUser.getNom_u(), unUser.getPrenom_u(), unUser.getEmail_u(),
                        unUser.getTel_u(), unUser.getDatenaissance_u(), unUser.getAdresse_u(), unUser.getVille_u(),
                        unUser.getCodepos_u(), unUser.getSexe_u(), infos[0], infos[1] };
                this.unTableau.insertLigne(ligne);

                // on affiche un message de confirmation
                JOptionPane.showMessageDialog(this, "Le moniteur a été enregistré avec succès");

                // on vide les champs
                this.viderChamps();
            }
        }
    }

}
