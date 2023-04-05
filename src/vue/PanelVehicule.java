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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import controleur.C_Vehicule;
import controleur.Tableau;
import controleur.Vehicule;

public class PanelVehicule extends PanelPrincipal implements ActionListener {

    private JPanel panelForm = new JPanel();
    private JPanel panelWrap = new JPanel();
    private JTextField txtType = new JTextField();
    private JTextField txtModele = new JTextField();
    private JTextField txtMarque = new JTextField();
    private JTextField txtAnneeImmat = new JTextField();
    private JTextField txtAnneeAchat = new JTextField();

    private JButton btnAnnuler = new JButton("Annuler");
    private JButton btnEnregistrer = new JButton("Enregistrer");

    private JTable tableUser;
    private Tableau unTableau;

    public PanelVehicule() {
        super();
        this.titre.setText("_______ Véhicules _______");

        // construction du panel form

        this.panelForm.setBounds(40, 60, 350, 250);
        this.panelForm.setBackground(new Color(43, 140, 82));
        this.panelForm.setLayout(new GridLayout(6, 2, 10, 10));

        this.panelForm.add(new JLabel("Type: "));
        this.panelForm.add(this.txtType);
        this.panelForm.add(new JLabel("Modèle: "));
        this.panelForm.add(this.txtModele);
        this.panelForm.add(new JLabel("Marque: "));
        this.panelForm.add(this.txtMarque);
        this.panelForm.add(new JLabel("Année d'immatriculation: "));
        this.panelForm.add(this.txtAnneeImmat);
        this.panelForm.add(new JLabel("Année d'achat: "));
        this.panelForm.add(this.txtAnneeAchat);
        this.panelForm.add(this.btnAnnuler);
        this.panelForm.add(this.btnEnregistrer);

        // construction de la JTable
        String entetes[] = { "Id", "Type", "Modèle", "Marque", "Année d'immatriculation", "Année d'achat" };
        Object donnees[][] = this.getDonnees();

        this.unTableau = new Tableau(donnees, entetes);
        this.tableUser = new JTable(unTableau);

        this.tableUser.setShowGrid(false);
        this.tableUser.setShowVerticalLines(true);

        JScrollPane unScroll = new JScrollPane(this.tableUser);
        unScroll.setBounds(400, 60, 350, 250);

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
                int idVehicule = Integer.parseInt(tableUser.getValueAt(numLigne, 0).toString());
                if (e.getClickCount() >= 2) {
                    viderChamps();
                    btnEnregistrer.setText("Enregistrer");
                    int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce véhicule?",
                            "Suppression formule", JOptionPane.YES_NO_OPTION);
                    if (retour == 0) {
                        C_Vehicule.deleteVehicule(idVehicule);
                        unTableau.deleteLigne(numLigne);
                        JOptionPane.showMessageDialog(null, "Véhicule supprimé avec succès");
                    }
                } else if (e.getClickCount() == 1) {
                    txtType.setText(tableUser.getValueAt(numLigne, 1).toString());
                    txtModele.setText(tableUser.getValueAt(numLigne, 2).toString());
                    txtMarque.setText(tableUser.getValueAt(numLigne, 3).toString());
                    txtAnneeImmat.setText(tableUser.getValueAt(numLigne, 4).toString());
                    txtAnneeAchat.setText(tableUser.getValueAt(numLigne, 5).toString());
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
        ArrayList<Vehicule> lesVehicules = C_Vehicule.selectAllVehicules();
        Object[][] matrice = new Object[lesVehicules.size()][6];
        int i = 0;
        for (Vehicule unVehicule : lesVehicules) {
            matrice[i][0] = unVehicule.getId_v();
            matrice[i][1] = unVehicule.getType_v();
            matrice[i][2] = unVehicule.getModel_v();
            matrice[i][3] = unVehicule.getMarque_v();
            matrice[i][4] = unVehicule.getAnneimmatri_v();
            matrice[i][5] = unVehicule.getAnneachat_v();
            i++;
        }
        return matrice;
    }

    public void viderChamps() {
        this.txtType.setText("");
        this.txtModele.setText("");
        this.txtMarque.setText("");
        this.txtAnneeImmat.setText("");
        this.txtAnneeAchat.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btnAnnuler) {
            this.viderChamps();
        } else if (e.getSource() == this.btnEnregistrer && this.btnEnregistrer.getText().equals("Enregistrer")) {
            if (this.txtType.getText().equals("")
                    || this.txtModele.getText().equals("")
                    || this.txtMarque.getText().equals("")
                    || this.txtAnneeImmat.getText().equals("")
                    || this.txtAnneeAchat.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs", "Erreur",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                String type = this.txtType.getText();
                String modele = this.txtModele.getText();
                String marque = this.txtMarque.getText();
                String anneeImmat = this.txtAnneeImmat.getText();
                String anneeAchat = this.txtAnneeAchat.getText();

                // instancier un Vehicule
                Vehicule unVehicule = new Vehicule(type, modele, marque, anneeImmat, anneeAchat);

                // on l'enregistre dans la base de donnÃ©es
                C_Vehicule.insertVehicule(unVehicule);

                // récupérer l'id du véhicule inséré à partir de la BDD
                unVehicule = C_Vehicule.selectWhereVehicule(type, modele, marque, anneeImmat, anneeAchat);

                // on recharge la JTable
                Object ligne[] = { unVehicule.getId_v(), unVehicule.getType_v(), unVehicule.getModel_v(),
                        unVehicule.getMarque_v(), unVehicule.getAnneimmatri_v(), unVehicule.getAnneachat_v() };
                this.unTableau.insertLigne(ligne);

                // on affiche un message de confirmation
                JOptionPane.showMessageDialog(this, "Le véhicule a été enregistré avec succès");

                // on vide les champs
                this.viderChamps();
            }
        } else if (e.getSource() == this.btnEnregistrer && this.btnEnregistrer.getText().equals("Modifier")) {
            if (this.txtType.getText().equals("")
                    || this.txtModele.getText().equals("")
                    || this.txtMarque.getText().equals("")
                    || this.txtAnneeImmat.getText().equals("")
                    || this.txtAnneeAchat.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs", "Erreur",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                int numLigne = this.tableUser.getSelectedRow();
                int idVehicule = Integer.parseInt(this.tableUser.getValueAt(numLigne, 0).toString());

                String type = this.txtType.getText();
                String modele = this.txtModele.getText();
                String marque = this.txtMarque.getText();
                String anneeImmat = this.txtAnneeImmat.getText();
                String anneeAchat = this.txtAnneeAchat.getText();

                // on instancie un Vehicule
                Vehicule unVehicule = new Vehicule(idVehicule, type, modele, marque, anneeImmat, anneeAchat);

                // on le modifie dans la base de donnÃ©es
                C_Vehicule.updateVehicule(unVehicule);

                // on recharge la JTable
                Object ligne[] = { unVehicule.getId_v(), unVehicule.getType_v(), unVehicule.getModel_v(),
                        unVehicule.getMarque_v(), unVehicule.getAnneimmatri_v(), unVehicule.getAnneachat_v() };
                this.unTableau.updateLigne(numLigne, ligne);
                // on affiche un message de confirmation
                JOptionPane.showMessageDialog(this, "Véhicule modifié avec succès");

                // on vide les champs
                this.viderChamps();

                // on remet le bouton enregistrer en mode "Enregistrer"
                this.btnEnregistrer.setText("Enregistrer");
            }
        }
    }

}
