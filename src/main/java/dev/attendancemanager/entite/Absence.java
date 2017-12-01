package dev.attendancemanager.entite;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Florent Callaou
 * Manage absence of an user 
 * @see User
 */
@Entity
public class Absence {

	/** id : Integer */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** beginDate : LocalDate*/
	@Column
	private LocalDate beginDate;
	
	/** endDate : LocalDate*/
	@Column
	private LocalDate endDate;
	
	/** motif : String */
	private String motif;

	/** type : AbscenceType 
	 * @see AbscenceType **/
	private AbscenceType type;
	
	/**
	 * status : AbsenceStatus
	 * @see AbsenceStatus
	 */
	private AbsenceStatus status;

	/**
	 * user : User
	 * @See User
	 */
	@ManyToOne
	@JsonIgnore
	private User user;

	/**
	 * Empty constructor
	 */
	public Absence() {
		super();
	}

	/**
	 * Constructor using fields
	 * @param beginDate
	 * @param endDate
	 * @param motif
	 * @param status
	 * @param type
	 */
	public Absence(LocalDate beginDate, LocalDate endDate, String motif, AbscenceType type, AbsenceStatus status) {
		super();
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.motif = motif;
		this.type = type;
		this.status = status;
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

	/** Getter for beginDate
	 * @return the beginDate
	 */
	public LocalDate getBeginDate() {
		return beginDate;
	}
	/** Setter for beginDate
	 * @param beginDate the beginDate to set
	 */
	public void setBeginDate(LocalDate beginDate) {
		this.beginDate = beginDate;
	}

	/** Getter for endDate
	 * @return the endDate
	 */
	public LocalDate getEndDate() {
		return endDate;
	}
	/** Setter for endDate
	 * @param endDate the endDate to set
	 */
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	/** Getter for motif
	 * @return the motif
	 */
	public String getMotif() {
		return motif;
	}
	/** Setter for motif
	 * @param motif the motif to set
	 */
	public void setMotif(String motif) {
		this.motif = motif;
	}
	
	/** Setter for status
	 * @param status the status to set
	 */
	public AbsenceStatus getStatus() {
		return status;
	}

	public void setStatus(AbsenceStatus status) {
		this.status = status;
	}

	/** Getter for type
	 * @return the type
	 */
	public AbscenceType getType() {
		return type;
	}
	/** Setter for type
	 * @param type the type to set
	 */
	public void setType(AbscenceType type) {
		this.type = type;
	}

	/**
	 * Getter for user 
	 * @return user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Setter for user
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
}
