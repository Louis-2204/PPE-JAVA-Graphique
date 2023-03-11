package vue;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controleur.OrangeEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VueGenerale extends JFrame implements ActionListener {

    private JPanel panelMenu = new JPanel();
    private JButton btnProfil = new JButton("Profil");
    private JButton btnEleves = new JButton("Eleves");
    private JButton btnMoniteurs = new JButton("Moniteurs");
    private JButton btnFormules = new JButton("Formules");
    private JButton btnVehicules = new JButton("Vehicules");
    private JButton btnQuitter = new JButton("Quitter");

    // liste des panels
    private PanelProfil unPanelProfil = new PanelProfil();
    private PanelEleve unPanelEleve = new PanelEleve();
    private PanelMoniteur unPanelMoniteur = new PanelMoniteur();
    private PanelFormule unPanelFormule = new PanelFormule();
    private PanelVehicule unPanelVehicule = new PanelVehicule();

    public VueGenerale() {
        this.setTitle("Gestion du garage Val'Auto");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBounds(100, 100, 900, 500);
        this.getContentPane().setBackground(new Color(234, 176, 69));
        this.setLayout(null);

        // installation du panel du menu

        this.panelMenu.setBounds(50, 20, 800, 30);
        this.panelMenu.setBackground(new Color(234, 176, 69));
        this.panelMenu.setLayout(new GridLayout(1, 6, 10, 0));
        this.panelMenu.add(this.btnProfil);
        this.panelMenu.add(this.btnEleves);
        this.panelMenu.add(this.btnMoniteurs);
        this.panelMenu.add(this.btnFormules);
        this.panelMenu.add(this.btnVehicules);

        this.add(this.panelMenu);

        // rendre les boutons cliquables

        this.btnProfil.addActionListener(this);
        this.btnEleves.addActionListener(this);
        this.btnMoniteurs.addActionListener(this);
        this.btnFormules.addActionListener(this);
        this.btnVehicules.addActionListener(this);
        this.btnQuitter.addActionListener(this);

        // ajout des panels dans la fenêtre
        this.add(this.unPanelProfil);
        this.add(this.unPanelEleve);
        this.add(this.unPanelMoniteur);
        this.add(this.unPanelFormule);
        this.add(this.unPanelVehicule);

        this.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btnQuitter) {
            int retour = JOptionPane.showConfirmDialog(this,
                    "Voulez-vous vraiment quitter l'application Val'Auto ?",
                    "Quitter l'application", JOptionPane.YES_NO_OPTION);
            if (retour == 0) {
                OrangeEvent.rendreVisibleVueGenerale(false);
                OrangeEvent.rendreVisibleVueConnexion(true);
            }
        } else if (e.getSource() == this.btnProfil) {
            this.afficherPanel(1);
        } else if (e.getSource() == this.btnEleves) {
            this.afficherPanel(2);
        } else if (e.getSource() == this.btnMoniteurs) {
            this.afficherPanel(3);
        } else if (e.getSource() == this.btnFormules) {
            this.afficherPanel(4);
        } else if (e.getSource() == this.btnVehicules) {
            this.afficherPanel(5);
        }
    }

    private void afficherPanel(int numero) {
        this.unPanelProfil.setVisible(false);
        this.unPanelEleve.setVisible(false);
        this.unPanelMoniteur.setVisible(false);
        this.unPanelFormule.setVisible(false);
        this.unPanelVehicule.setVisible(false);

        switch (numero) {
            case 1:
                this.unPanelProfil.setVisible(true);
                break;
            case 2:
                this.unPanelEleve.setVisible(true);
                break;
            case 3:
                this.unPanelMoniteur.setVisible(true);
                break;
            case 4:
                this.unPanelFormule.setVisible(true);
                break;
            case 5:
                this.unPanelVehicule.setVisible(true);
                break;
        }
    }
}
