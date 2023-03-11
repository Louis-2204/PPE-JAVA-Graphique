package controleur;

public class Vehicule {
    private int id_v;
    private String type_v, model_v, marque_v, annneimmatri_v, anneachat_v;

    public Vehicule(int id_v, String type_v, String model_v, String marque_v,
            String annneimmatri_v, String anneachat_v) {
        this.id_v = id_v;
        this.type_v = type_v;
        this.model_v = model_v;
        this.marque_v = marque_v;
        this.annneimmatri_v = annneimmatri_v;
        this.anneachat_v = anneachat_v;
    }

    public Vehicule(String type_v, String model_v, String marque_v,
            String annneimmatri_v, String anneachat_v) {
        this.id_v = 0;
        this.type_v = type_v;
        this.model_v = model_v;
        this.marque_v = marque_v;
        this.annneimmatri_v = annneimmatri_v;
        this.anneachat_v = anneachat_v;
    }

    public Vehicule() {
        this.id_v = 0;
        this.type_v = "";
        this.model_v = "";
        this.marque_v = "";
        this.annneimmatri_v = "";
        this.anneachat_v = "";
    }

	public int getId_v() {
		return id_v;
	}

	public void setId_v(int id_v) {
		this.id_v = id_v;
	}

	public String getType_v() {
		return type_v;
	}

	public void setType_v(String type_v) {
		this.type_v = type_v;
	}

	public String getModel_v() {
		return model_v;
	}

	public void setModel_v(String model_v) {
		this.model_v = model_v;
	}

	public String getMarque_v() {
		return marque_v;
	}

	public void setMarque_v(String marque_v) {
		this.marque_v = marque_v;
	}

	public String getAnnneimmatri_v() {
		return annneimmatri_v;
	}

	public void setAnnneimmatri_v(String annneimmatri_v) {
		this.annneimmatri_v = annneimmatri_v;
	}

	public String getAnneachat_v() {
		return anneachat_v;
	}

	public void setAnneachat_v(String anneachat_v) {
		this.anneachat_v = anneachat_v;
	}
        
}
