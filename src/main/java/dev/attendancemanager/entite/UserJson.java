package dev.attendancemanager.entite;

import java.util.List;

public class UserJson {

	private String matricule;
	private String nom;
	private String prenom;
	private String email;
	private String dateNaissance;
	private String sexe;
	private String adresse;
	private String password;
	private String photo;
	private String[] subalternes;
	private String departement;

	/** Getter for matricule
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}
	/** Setter for matricule
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	/** Getter for nom
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/** Setter for nom
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/** Getter for prenom
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/** Setter for prenom
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/** Getter for email
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/** Setter for email
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/** Getter for dateNaissance
	 * @return the dateNaissance
	 */
	public String getDateNaissance() {
		return dateNaissance;
	}
	/** Setter for dateNaissance
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	/** Getter for sexe
	 * @return the sexe
	 */
	public String getSexe() {
		return sexe;
	}
	/** Setter for sexe
	 * @param sexe the sexe to set
	 */
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	/** Getter for adresse
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}
	/** Setter for adresse
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	/** Getter for password
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/** Setter for password
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/** Getter for photo
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}
	/** Setter for photo
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/** Getter for subalternes
	 * @return the subalternes
	 */
	public String[] getSubalternes() {
		return subalternes;
	}
	/** Setter for subalternes
	 * @param subalternes the subalternes to set
	 */
	public void setSubalternes(String[] subalternes) {
		this.subalternes = subalternes;
	}
	/** Getter for departement
	 * @return the departement
	 */
	public String getDepartement() {
		return departement;
	}
	/** Setter for departement
	 * @param departement the departement to set
	 */
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	
}
