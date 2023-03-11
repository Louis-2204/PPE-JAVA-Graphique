package vue;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controleur.C_User;
import controleur.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelProfil extends PanelPrincipal implements ActionListener {

    private JPanel panelForm = new JPanel();
    private JTextField txtNom = new JTextField();
    private JTextField txtPrenom = new JTextField();
    private JTextField txtDateNaissance = new JTextField();
    private JTextField txtEmail = new JTextField();
    private JTextField txtTel = new JTextField();
    private JTextField txtAdresse = new JPasswordField();
    private JTextField txtVille = new JPasswordField();
    private JTextField txtCodePostal = new JPasswordField();
    private JTextField cbxSexe = new JTextField();
    private JPasswordField txtMdp = new JPasswordField();

    private JButton btnAnnuler = new JButton("Annuler");
    private JButton btnEnregistrer = new JButton("Enregistrer");

    private User unU = new User();

    // TextArea pour afficher les informations du technicien
    private JTextArea txtInfos = new JTextArea();

    private JButton btnModifier = new JButton("Modifier");

    public PanelProfil() {
        super();
        this.titre.setText("_______ Mon profil _______");

        this.panelForm.setBounds(400, 60, 350, 250);
        this.panelForm.setBackground(new Color(234, 176, 69));
        this.panelForm.setLayout(new GridLayout(11, 2, 10, 10));

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
        this.panelForm.add(new JLabel("Mot de passe: "));
        this.panelForm.add(this.txtMdp);
        this.panelForm.add(this.btnAnnuler);
        this.panelForm.add(this.btnEnregistrer);

        // ajout du panel form au panel client
        this.add(this.panelForm);
        this.panelForm.setVisible(false);

        // installation du textArea
        this.txtInfos.setBounds(40, 50, 300, 180);
        this.txtInfos.setBackground(new Color(234, 176, 69));
        this.unU = VueConnexion.getUser();
        this.txtInfos.setText("_________ Informations _________\n\n"
                + "Nom: " + unU.getNom_u() + " " + unU.getPrenom_u() + "\n\n"
                + "Email: " + unU.getEmail_u() + "\n\n"
                + "Téléphone: " + unU.getTel_u() + "\n\n"
                + "Date de naissance: " + unU.getDatenaissance_u() + "\n\n"
                + "Adresse: " + unU.getAdresse_u() + "\n\n"
                + "Ville: " + unU.getVille_u() + "\n\n"
                + "Code postal: " + unU.getCodepos_u() + "\n\n"
                + "Sexe: " + unU.getSexe_u() + "\n\n"
                + "Rôle: " + unU.getRole_u() + "\n\n");

        this.txtInfos.setEditable(false);
        this.add(this.txtInfos);

        // remplir les infos du formulaire
        this.txtNom.setText(this.unU.getNom_u());
        this.txtPrenom.setText(this.unU.getPrenom_u());
        this.txtEmail.setText(this.unU.getEmail_u());
        this.txtTel.setText(this.unU.getTel_u());
        this.txtDateNaissance.setText(this.unU.getDatenaissance_u());
        this.txtAdresse.setText(this.unU.getAdresse_u());
        this.txtVille.setText(this.unU.getVille_u());
        this.txtCodePostal.setText(this.unU.getCodepos_u());
        this.cbxSexe.setText(this.unU.getSexe_u());
        this.txtMdp.setText(this.unU.getMdp_u());

        this.btnModifier.setBounds(40, 250, 300, 40);
        this.add(this.btnModifier);

        // rendre les boutons cliquables
        this.btnAnnuler.addActionListener(this);
        this.btnEnregistrer.addActionListener(this);
        this.btnModifier.addActionListener(this);
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
        this.cbxSexe.setText("");
        this.txtMdp.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == this.btnModifier) {
            if (this.panelForm.isVisible()) {
                this.panelForm.setVisible(false);
            } else {
                this.panelForm.setVisible(true);
            }
        } else if (e.getSource() == this.btnAnnuler) {
            this.panelForm.setVisible(false);
        } else if (e.getSource() == this.btnEnregistrer) {
            if (this.txtNom.getText().equals("") || this.txtPrenom.getText().equals("")
                    || this.txtEmail.getText().equals("") || this.txtTel.getText().equals("")
                    || this.txtDateNaissance.getText().equals("")
                    || this.txtAdresse.getText().equals("") || this.txtVille.getText().equals("")
                    || this.txtCodePostal.getText().equals("")
                    || this.txtMdp.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs", "Erreur",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                String nom = this.txtNom.getText();
                String prenom = this.txtPrenom.getText();
                String datenaissance = this.txtDateNaissance.getText();
                String email = this.txtEmail.getText();
                String tel = this.txtTel.getText();
                String adresse = this.txtAdresse.getText();
                String ville = this.txtVille.getText();
                String codepos = this.txtCodePostal.getText();
                String sexe = this.unU.getSexe_u();
                String mdp = new String(this.txtMdp.getPassword());
                // instancier un technicien
                this.unU = new User(unU.getId_u(), nom, prenom, datenaissance, email, tel, adresse, ville, codepos,
                        sexe, unU.getRole_u(), mdp, unU.getSecurity_question(), unU.getSecurity_answer());
                // on l'enregistre dans la base de données
                C_User.updateUser(unU);

                JOptionPane.showMessageDialog(this, "Modification de votre profil effectuée avec succès");
                this.txtInfos.setText("_________ Informations _________\n\n"
                        + "Nom: " + unU.getNom_u() + " " + unU.getPrenom_u() + "\n\n"
                        + "Email: " + unU.getEmail_u() + "\n\n"
                        + "Téléphone: " + unU.getTel_u() + "\n\n"
                        + "Date de naissance: " + unU.getDatenaissance_u() + "\n\n"
                        + "Adresse: " + unU.getAdresse_u() + "\n\n"
                        + "Ville: " + unU.getVille_u() + "\n\n"
                        + "Code postal: " + unU.getCodepos_u() + "\n\n"
                        + "Sexe: " + unU.getSexe_u() + "\n\n"
                        + "Rôle: " + unU.getRole_u() + "\n\n");
            }
        }
    }
}
