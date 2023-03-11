package controleur;

public class User {
	private int id_u;
	private String nom_u, prenom_u, datenaissance_u, email_u, tel_u, adresse_u,
			ville_u, codepos_u, sexe_u, role_u, mdp_u, security_question, security_answer, dateembauche,
			dateobtentionbafm;

	public User(String nom_u, String prenom_u, String datenaissance_u, String email_u, String tel_u,
			String adresse_u, String ville_u, String codepos_u, String sexe_u, String role_u, String mdp_u,
			String security_question, String security_answer, String dateembauche, String dateobtentionbafm) {
		this.id_u = 0;
		this.nom_u = nom_u;
		this.prenom_u = prenom_u;
		this.datenaissance_u = datenaissance_u;
		this.email_u = email_u;
		this.tel_u = tel_u;
		this.adresse_u = adresse_u;
		this.ville_u = ville_u;
		this.codepos_u = codepos_u;
		this.sexe_u = sexe_u;
		this.role_u = role_u;
		this.mdp_u = mdp_u;
		this.security_question = security_question;
		this.security_answer = security_answer;
		this.dateembauche = dateembauche;
		this.dateobtentionbafm = dateobtentionbafm;
	}

	public User(int id_u, String nom_u, String prenom_u, String datenaissance_u, String email_u, String tel_u,
			String adresse_u, String ville_u, String codepos_u, String sexe_u, String role_u, String mdp_u,
			String security_question, String security_answer) {
		this.id_u = id_u;
		this.nom_u = nom_u;
		this.prenom_u = prenom_u;
		this.datenaissance_u = datenaissance_u;
		this.email_u = email_u;
		this.tel_u = tel_u;
		this.adresse_u = adresse_u;
		this.ville_u = ville_u;
		this.codepos_u = codepos_u;
		this.sexe_u = sexe_u;
		this.role_u = role_u;
		this.mdp_u = mdp_u;
		this.security_question = security_question;
		this.security_answer = security_answer;
	}

	public User(String nom_u, String prenom_u, String datenaissance_u, String email_u, String tel_u, String adresse_u,
			String ville_u, String codepos_u, String sexe_u, String role_u, String mdp_u, String security_question,
			String security_answer) {
		this.id_u = 0;
		this.nom_u = nom_u;
		this.prenom_u = prenom_u;
		this.datenaissance_u = datenaissance_u;
		this.email_u = email_u;
		this.tel_u = tel_u;
		this.adresse_u = adresse_u;
		this.ville_u = ville_u;
		this.codepos_u = codepos_u;
		this.sexe_u = sexe_u;
		this.role_u = role_u;
		this.mdp_u = mdp_u;
		this.security_question = security_question;
		this.security_answer = security_answer;
	}

	public User() {
		this.id_u = 0;
		this.nom_u = "";
		this.prenom_u = "";
		this.datenaissance_u = "";
		this.email_u = "";
		this.tel_u = "";
		this.adresse_u = "";
		this.ville_u = "";
		this.codepos_u = "";
		this.sexe_u = "";
		this.role_u = "";
		this.mdp_u = "";
		this.security_question = "";
		this.security_answer = "";
	}

	public int getId_u() {
		return id_u;
	}

	public void setId_u(int id_u) {
		this.id_u = id_u;
	}

	public String getNom_u() {
		return nom_u;
	}

	public void setNom_u(String nom_u) {
		this.nom_u = nom_u;
	}

	public String getPrenom_u() {
		return prenom_u;
	}

	public void setPrenom_u(String prenom_u) {
		this.prenom_u = prenom_u;
	}

	public String getDatenaissance_u() {
		return datenaissance_u;
	}

	public void setDatenaissance_u(String datenaissance_u) {
		this.datenaissance_u = datenaissance_u;
	}

	public String getEmail_u() {
		return email_u;
	}

	public void setEmail_u(String email_u) {
		this.email_u = email_u;
	}

	public String getTel_u() {
		return tel_u;
	}

	public void setTel_u(String tel_u) {
		this.tel_u = tel_u;
	}

	public String getAdresse_u() {
		return adresse_u;
	}

	public void setAdresse_u(String adresse_u) {
		this.adresse_u = adresse_u;
	}

	public String getVille_u() {
		return ville_u;
	}

	public void setVille_u(String ville_u) {
		this.ville_u = ville_u;
	}

	public String getCodepos_u() {
		return codepos_u;
	}

	public void setCodepos_u(String codepos_u) {
		this.codepos_u = codepos_u;
	}

	public String getSexe_u() {
		return sexe_u;
	}

	public void setSexe_u(String sexe_u) {
		this.sexe_u = sexe_u;
	}

	public String getRole_u() {
		return role_u;
	}

	public void setRole_u(String role_u) {
		this.role_u = role_u;
	}

	public String getMdp_u() {
		return mdp_u;
	}

	public void setMdp_u(String mdp_u) {
		this.mdp_u = mdp_u;
	}

	public String getSecurity_question() {
		return security_question;
	}

	public void setSecurity_question(String security_question) {
		this.security_question = security_question;
	}

	public String getSecurity_answer() {
		return security_answer;
	}

	public void setSecurity_answer(String security_answer) {
		this.security_answer = security_answer;
	}

	public String getDateembauche() {
		return dateembauche;
	}

	public void setDateembauche(String dateembauche) {
		this.dateembauche = dateembauche;
	}

	public String getDateObtentionBafm() {
		return dateobtentionbafm;
	}

	public void setDateObtentionBafm(String dateobtentionbafm) {
		this.dateobtentionbafm = dateobtentionbafm;
	}

}
