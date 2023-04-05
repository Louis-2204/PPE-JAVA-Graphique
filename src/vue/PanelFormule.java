package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import controleur.C_Formule;
import controleur.Tableau;
import controleur.Formule;

public class PanelFormule extends PanelPrincipal implements ActionListener {

    private JPanel panelForm = new JPanel();
    private JPanel panelWrap = new JPanel();
    private JTextField txtNom = new JTextField();
    private JTextField txtPrix = new JTextField();
    private JTextField txtNbHeures = new JTextField();
    private JTextField txtTypeBoite = new JTextField();

    private JButton btnAnnuler = new JButton("Annuler");
    private JButton btnEnregistrer = new JButton("Enregistrer");

    private JTable tableUser;
    private Tableau unTableau;

    public PanelFormule() {
        super();
        this.titre.setText("_______ Formules _______");

        // construction du panel form

        this.panelForm.setBackground(new Color(43, 140, 82));
        this.panelForm.setLayout(new GridLayout(5, 2, 10, 10));

        this.panelForm.add(new JLabel("Nom: "));
        this.panelForm.add(this.txtNom);
        this.panelForm.add(new JLabel("Prix: "));
        this.panelForm.add(this.txtPrix);
        this.panelForm.add(new JLabel("Nombre d'heures: "));
        this.panelForm.add(this.txtNbHeures);
        this.panelForm.add(new JLabel("Type de boite: "));
        this.panelForm.add(this.txtTypeBoite);
        this.panelForm.add(this.btnAnnuler);
        this.panelForm.add(this.btnEnregistrer);

        // construction de la JTable
        String entetes[] = { "Id", "Nom", "Prix", "Nombre d'heures", "Type de boite" };
        Object donnees[][] = this.getDonnees();

        this.unTableau = new Tableau(donnees, entetes);
        this.tableUser = new JTable(unTableau);

        this.tableUser.setShowGrid(false);
        this.tableUser.setShowVerticalLines(true);

        JScrollPane unScroll = new JScrollPane(this.tableUser);

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

        // implémentation de la supression / modification d'une ligne
        this.tableUser.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                int numLigne = tableUser.getSelectedRow();
                int idFormule = Integer.parseInt(tableUser.getValueAt(numLigne, 0).toString());
                if (e.getClickCount() >= 2) {
                    viderChamps();
                    btnEnregistrer.setText("Enregistrer");
                    int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer cette formule?",
                            "Suppression formule", JOptionPane.YES_NO_OPTION);
                    if (retour == 0) {
                        C_Formule.deleteFormule(idFormule);
                        unTableau.deleteLigne(numLigne);
                        JOptionPane.showMessageDialog(null, "Formule supprimé avec succès");
                    }
                } else if (e.getClickCount() == 1) {
                    txtNom.setText(tableUser.getValueAt(numLigne, 1).toString());
                    txtPrix.setText(tableUser.getValueAt(numLigne, 2).toString());
                    txtNbHeures.setText(tableUser.getValueAt(numLigne, 3).toString());
                    txtTypeBoite.setText(tableUser.getValueAt(numLigne, 4).toString());
                    btnEnregistrer.setText("Modifier");
                }
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mousePressed(MouseEvent arg0) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseReleased(MouseEvent arg0) {
                // TODO Auto-generated method stub
            }

        });
    }

    public Object[][] getDonnees() {
        ArrayList<Formule> lesFormules = C_Formule.selectAllFormules();
        Object[][] matrice = new Object[lesFormules.size()][5];
        int i = 0;
        for (Formule uneFormule : lesFormules) {
            matrice[i][0] = uneFormule.getId_f();
            matrice[i][1] = uneFormule.getNom_f();
            matrice[i][2] = uneFormule.getPrix_f();
            matrice[i][3] = uneFormule.getNb_heures();
            matrice[i][4] = uneFormule.getType_boite();
            i++;
        }
        return matrice;
    }

    public void remplirCBX() {
    }

    public void viderChamps() {
        this.txtNom.setText("");
        this.txtPrix.setText("");
        this.txtNbHeures.setText("");
        this.txtTypeBoite.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btnAnnuler) {
            this.viderChamps();
        } else if (e.getSource() == this.btnEnregistrer && this.btnEnregistrer.getText().equals("Enregistrer")) {
            if (this.txtNom.getText().equals("")
                    || this.txtPrix.getText().equals("")
                    || this.txtNbHeures.getText().equals("")
                    || this.txtTypeBoite.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs obligatoires", "Erreur",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                String nom = this.txtNom.getText();
                // on convertit le String en Float
                Float prix = Float.parseFloat(this.txtPrix.getText());
                Float nbHeures = Float.parseFloat(this.txtNbHeures.getText());
                String typeBoite = this.txtTypeBoite.getText();

                // instancier une Formule
                Formule uneFormule = new Formule(nom, prix, nbHeures, typeBoite);

                // on l'enregistre dans la base de donnÃ©es
                C_Formule.insertFormule(uneFormule);

                // rÃ©cupÃ©rer l'id de la Formule inséré à partir de la BDD
                uneFormule = C_Formule.selectWhereFormule(nom, prix, nbHeures, typeBoite);

                // on recharge la JTable
                Object ligne[] = { uneFormule.getId_f(), uneFormule.getNom_f(), uneFormule.getPrix_f(),
                        uneFormule.getNb_heures(), uneFormule.getType_boite() };
                this.unTableau.insertLigne(ligne);

                // on affiche un message de confirmation
                JOptionPane.showMessageDialog(this, "La formule a été enregistrée avec succès");

                // on vide les champs
                this.viderChamps();
            }
        } else if (e.getSource() == this.btnEnregistrer && this.btnEnregistrer.getText().equals("Modifier")) {
            if (this.txtNom.getText().equals("")
                    || this.txtPrix.getText().equals("")
                    || this.txtNbHeures.getText().equals("")
                    || this.txtTypeBoite.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs", "Erreur",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                int numLigne = this.tableUser.getSelectedRow();
                int idFormule = Integer.parseInt(this.tableUser.getValueAt(numLigne, 0).toString());

                String nom = this.txtNom.getText();
                // on convertit le String en Float
                Float prix = Float.parseFloat(this.txtPrix.getText());
                Float nbHeures = Float.parseFloat(this.txtNbHeures.getText());
                String typeBoite = this.txtTypeBoite.getText();

                // on instancie une Formule
                Formule uneFormule = new Formule(idFormule, nom, prix, nbHeures, typeBoite);

                // on la modifie dans la base de données
                C_Formule.updateFormule(uneFormule);

                // on recharge la JTable
                Object ligne[] = { uneFormule.getId_f(), uneFormule.getNom_f(), uneFormule.getPrix_f(),
                        uneFormule.getNb_heures(), uneFormule.getType_boite() };
                this.unTableau.updateLigne(numLigne, ligne);
                // on affiche un message de confirmation
                JOptionPane.showMessageDialog(this, "Formule modifié avec succès");

                // on vide les champs
                this.viderChamps();

                // on remet le bouton enregistrer en mode "Enregistrer"
                this.btnEnregistrer.setText("Enregistrer");
            }
        }
    }

}
