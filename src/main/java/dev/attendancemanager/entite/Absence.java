package dev.attendancemanager.entite;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDate beginDate;
	
	/** endDate : LocalDate*/
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDate endDate;
	
	/** motif : String */
	private String motif;
	
	/** status : String */
	private String status;
	
	/** type : TypeAbscence 
	 * @see TypeAbscence
	*/
	private TypeAbscence type;
	
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
	public Absence(LocalDate beginDate, LocalDate endDate, String motif, String status, TypeAbscence type) {
		super();
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.motif = motif;
		this.status = status;
		this.setType(type);
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
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/** Getter for type
	 * @return the type
	 */
	public TypeAbscence getType() {
		return type;
	}
	/** Setter for type
	 * @param type the type to set
	 */
	public void setType(TypeAbscence type) {
		this.type = type;
	}

	


	
}
