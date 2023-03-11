package controleur;

import javax.swing.table.AbstractTableModel;

public class Tableau extends AbstractTableModel {
    private Object[][] donnees;
    private String entetes[];

    public Tableau(Object[][] donnees, String entetes[]) {
        this.donnees = donnees;
        this.entetes = entetes;
    }

    @Override
    public int getRowCount() {
        return this.donnees.length;
    }

    @Override
    public int getColumnCount() {
        return this.entetes.length;
    }

    @Override
    public Object getValueAt(int ligne, int colonne) {
        return this.donnees[ligne][colonne];
    }

    @Override
    public String getColumnName(int colonne) {
        return this.entetes[colonne];
    }

    // ajouter une ligne à la matrice de données
    public void insertLigne(Object[] donnees) {
        Object[][] matrice = new Object[this.donnees.length + 1][this.entetes.length];
        for (int i = 0; i < this.donnees.length; i++) {
            matrice[i] = this.donnees[i];
        }
        matrice[this.donnees.length] = donnees;
        this.donnees = matrice;
        this.fireTableDataChanged(); // mise à jour des données
    }

    // supprimer une ligne de la matrice de données
    public void deleteLigne(int numLigne) {
        Object[][] matrice = new Object[this.donnees.length - 1][this.entetes.length];
        for (int i = 0; i < numLigne; i++) {
            matrice[i] = this.donnees[i];
        }
        for (int i = numLigne + 1; i < this.donnees.length; i++) {
            matrice[i - 1] = this.donnees[i];
        }
        this.donnees = matrice;
        this.fireTableDataChanged();
    }

    // modifier une ligne de la matrice de données
    public void updateLigne(int numLigne, Object[] ligne) {
        this.donnees[numLigne] = ligne;
        this.fireTableDataChanged();
    }
}
