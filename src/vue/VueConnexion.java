package vue;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controleur.C_User;
import controleur.OrangeEvent;
import controleur.User;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class VueConnexion extends JFrame implements ActionListener, KeyListener {
    private JTextField txtEmail = new JTextField("admin@gmail.com");
    private JPasswordField txtMdp = new JPasswordField("123");
    private JButton btnAnnuler = new JButton("Annuler");
    private JButton btnSeConnecter = new JButton("Se connecter");
    private JPanel panelConnexion = new JPanel();

    // technicien connecté en static
    private static User unUserConnecte = null;

    public static User getUser() {
        return unUserConnecte;
    }

    public VueConnexion() {
        this.setTitle("Gestion des interventions Orange");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBounds(100, 100, 600, 300);
        this.getContentPane().setBackground(new Color(234, 176, 69));
        this.setLayout(null);

        // instanciation de l'image logo

        ImageIcon uneImage = new ImageIcon("src/images/logo.png");
        JLabel unLabel = new JLabel(uneImage);
        unLabel.setBounds(20, 30, 200, 200);

        this.add(unLabel);

        // installation du panel de connexion

        this.panelConnexion.setBounds(250, 30, 280, 200);
        this.panelConnexion.setBackground(new Color(234, 176, 69));
        this.panelConnexion.setLayout(new GridLayout(3, 2));

        this.panelConnexion.add(new JLabel("Email :"));
        this.panelConnexion.add(this.txtEmail);

        this.panelConnexion.add(new JLabel("Mot de passe :"));
        this.panelConnexion.add(this.txtMdp);

        this.panelConnexion.add(this.btnAnnuler);

        this.panelConnexion.add(this.btnSeConnecter);

        this.add(this.panelConnexion);

        // rendre les boutons cliquables

        this.btnAnnuler.addActionListener(this);
        this.btnSeConnecter.addActionListener(this);

        // rendre les txt ecoutables

        this.txtEmail.addKeyListener(this);
        this.txtMdp.addKeyListener(this);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btnAnnuler) {
            // effacer les champs
            this.txtEmail.setText("");
            this.txtMdp.setText("");
        } else if (e.getSource() == this.btnSeConnecter) {
            this.traitement();
        }

    }

    public void traitement() {
        String email = this.txtEmail.getText();
        String mdp = new String(this.txtMdp.getPassword());

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
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        // vérification dans la base de données
        unUserConnecte = C_User.selectWhereUser(email, mdp);
        if (unUserConnecte == null) {
            JOptionPane.showMessageDialog(this, "Veuillez vérifier vos identifiants");
        } else {
            JOptionPane.showMessageDialog(this,
                    "Bienvenue " + unUserConnecte.getNom_u() + " " + unUserConnecte.getPrenom_u());

            // ouverture de la JFrame générale
            OrangeEvent.rendreVisibleVueConnexion(false);
            OrangeEvent.rendreVisibleVueGenerale(true);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            this.traitement();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }
}
