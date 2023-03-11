package controleur;

public class Formule {
    private int id_f;
    private String nom_f, type_boite;
    private float prix_f, nb_heures;

    // Full avec type boite
    public Formule(int id_f, String nom_f, float prix_f, float nb_heures, String type_boite) {
        this.id_f = id_f;
        this.nom_f = nom_f;
        this.prix_f = prix_f;
        this.nb_heures = nb_heures;
        this.type_boite = type_boite;
    }

    // Full sans type boite
    public Formule(int id_f, String nom_f, float prix_f, float nb_heures) {
        this.id_f = id_f;
        this.nom_f = nom_f;
        this.prix_f = prix_f;
        this.nb_heures = nb_heures;
        this.type_boite = "null";
    }

    // Sans id avec type boite
    public Formule(String nom_f, float prix_f, float nb_heures, String type_boite) {
        this.id_f = 0;
        this.nom_f = nom_f;
        this.prix_f = prix_f;
        this.nb_heures = nb_heures;
        this.type_boite = type_boite;
    }

    // Sans id sans type boite
    public Formule(String nom_f, float prix_f, float nb_heures) {
        this.id_f = 0;
        this.nom_f = nom_f;
        this.prix_f = prix_f;
        this.nb_heures = nb_heures;
        this.type_boite = "null";
    }

    // vide
    public Formule() {
        this.id_f = 0;
        this.nom_f = "";
        this.prix_f = 0;
        this.nb_heures = 0;
        this.type_boite = "null";
    }

    public int getId_f() {
        return id_f;
    }

    public void setId_f(int id_f) {
        this.id_f = id_f;
    }

    public String getNom_f() {
        return nom_f;
    }

    public void setNom_f(String nom_f) {
        this.nom_f = nom_f;
    }

    public float getPrix_f() {
        return prix_f;
    }

    public void setPrix_f(float prix_f) {
        this.prix_f = prix_f;
    }

    public float getNb_heures() {
        return nb_heures;
    }

    public void setNb_heures(float nb_heures) {
        this.nb_heures = nb_heures;
    }

    public String getType_boite() {
        return type_boite;
    }

    public void setType_boite(String type_boite) {
        this.type_boite = type_boite;
    }

}
