package dev.attendancemanager.entite;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Florent Callaou
 *	An user on the application
 */	
@Entity
public class User {
	
	/** id : Integer */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** matricule : String */
	private String matricule;
	
	/** firstname : String */
	private String firstname;
	
	/** lastname : String */
	private String lastname;
	
	/** email : String */
	private String email;
	
	/** password : String */
	private String password;
	
	/** subalternes : List<User> */
	@OneToMany
	private List<User> subalternes;
	
	/** departement : Departement 
	 * @see Departement
	*/
	@Enumerated
	private Departement departement;

	/**
	 * Empty constructor
	 */
	public User() {
		super();
	}
	
	/**
	 * Constructor using fields
	 * @param matricule
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param password
	 * @param subalternes
	 * @param departement
	 */
	public User(String matricule, String firstname, String lastname, String email, String password,
			List<User> subalternes, Departement departement) {
		super();
		this.matricule = matricule;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.subalternes = subalternes;
		this.departement = departement;
	}

	/** Getter for id
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/** Setter for id
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
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

	/** Getter for firstname
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/** Setter for firstname
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/** Getter for lastname
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/** Setter for lastname
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	/** Getter for subalternes
	 * @return the subalternes
	 */
	public List<User> getSubalternes() {
		return subalternes;
	}
	/** Setter for subalternes
	 * @param subalternes the subalternes to set
	 */
	public void setSubalternes(List<User> subalternes) {
		this.subalternes = subalternes;
	}

	/** Getter for departement
	 * @return the departement
	 */
	public Departement getDepartement() {
		return departement;
	}
	/** Setter for departement
	 * @param departement the departement to set
	 */
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	
}
