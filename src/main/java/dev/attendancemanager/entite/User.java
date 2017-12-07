package dev.attendancemanager.entite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Florent Callaou
 *	An user on the application
 */	
/**
 * @author Florent Callaou
 *
 */
@Entity
public class User {
	
	/** id : Integer */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** matricule : String */
	@Column
	private String matricule;
	
	/** firstname : String */
	@Column
	private String firstname;
	
	/** lastname : String */
	@Column
	private String lastname;
	
	/** email : String */
	@Column
	private String email;
	
	/** password : String */
	@Column
	private String password;
	
	private boolean actif = true;
	
	/** subalternes : List<User> */
	@JsonIgnore
	@Transient
	@OneToMany
	private List<User> subalternes = new ArrayList<>();
	
	/**
	 * absences : List<Absence>
	 */
	@OneToMany(mappedBy="user")
	@JsonIgnore
	private List<Absence> absences = new ArrayList<>();
	
	/** departement : Departement 
	 * @see Departement
	*/
	/** departement : Departement */
	@Column
	@Enumerated
	private Departement departement;
	
	/** role : Role */
	@Column
	@Enumerated(EnumType.STRING)
	private Role role;

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
	public User(String matricule, String firstname, String lastname, String email, String password, Departement departement, Role role) {
		super();
		this.matricule = matricule;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.departement = departement;
		this.role = role;
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

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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
	
	/** Getter for absences
	 * @return the absences
	 */
	public List<Absence> getAbsences() {
		return absences;
	}

	/** Setter for absences
	 * @param absences the absences to set
	 */
	public void setAbsences(List<Absence> absences) {
		this.absences = absences;
	}

	public List<String> getMatriculeSubalternes(){
		return subalternes.stream().map(User::getMatricule).collect(Collectors.toList());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricule == null) ? 0 : matricule.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (matricule == null) {
			if (other.matricule != null)
				return false;
		} else if (!matricule.equals(other.matricule))
			return false;
		return true;
	}
	
}
