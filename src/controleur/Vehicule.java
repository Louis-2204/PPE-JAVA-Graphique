package controleur;

public class Vehicule {
	private Float km;
	private String type_v, model_v, marque_v, anneimmatri_v, anneachat_v,type_boite,matricule;

	public Vehicule(String matricule, String type_v, String model_v, String marque_v,
			String anneimmatri_v, String anneachat_v, String type_boite, Float km) {
		this.matricule = matricule;
		this.type_v = type_v;
		this.model_v = model_v;
		this.marque_v = marque_v;
		this.anneimmatri_v = anneimmatri_v;
		this.anneachat_v = anneachat_v;
		this.type_boite = type_boite;
		this.km = km;
	}

	public Vehicule(String type_v, String model_v, String marque_v,
			String anneimmatri_v, String anneachat_v, String type_boite, Float km) {
		this.matricule = "";
		this.type_v = type_v;
		this.model_v = model_v;
		this.marque_v = marque_v;
		this.anneimmatri_v = anneimmatri_v;
		this.anneachat_v = anneachat_v;
		this.type_boite = type_boite;
		this.km = km;
	}

	public Vehicule() {
		this.matricule = "";
		this.type_v = "";
		this.model_v = "";
		this.marque_v = "";
		this.anneimmatri_v = "";
		this.anneachat_v = "";
		this.type_boite = "";
		this.km = (float) 0;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
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

	public String getAnneimmatri_v() {
		return anneimmatri_v;
	}

	public void setAnneimmatri_v(String anneimmatri_v) {
		this.anneimmatri_v = anneimmatri_v;
	}

	public String getAnneachat_v() {
		return anneachat_v;
	}

	public void setAnneachat_v(String anneachat_v) {
		this.anneachat_v = anneachat_v;
	}

	public String getType_boite() {
		return type_boite;
	}

	public void setType_boite(String type_boite) {
		this.type_boite = type_boite;
	}

	public Float getKm() {
		return km;
	}

	public void setKm(Float km) {
		this.km = km;
	}
}
