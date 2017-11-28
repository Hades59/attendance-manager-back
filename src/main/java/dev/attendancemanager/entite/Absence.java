package dev.attendancemanager.entite;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	/** beginDate : LocalDateTime */
	@Column(name = "begin_date")
	private LocalDateTime beginDate;
	
	/** endDate : LocalDateTime */
	@Column(name = "end_date")
	private LocalDateTime endDate;
	
	/** motif : String */
	@Column
	private String motif;
	
	/** type : AbscenceType 
	 * @see AbscenceType
	*/
	@Column
	private AbscenceType type;
	
	/**
	 * status : AbsenceStatus
	 * @see AbsenceStatus
	 */
	@Column
	private AbsenceStatus status;

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
	 * @param type
	 */
	public Absence(LocalDateTime beginDate, LocalDateTime endDate, String motif, AbscenceType type) {
		super();
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.motif = motif;
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
	public LocalDateTime getBeginDate() {
		return beginDate;
	}
	/** Setter for beginDate
	 * @param beginDate the beginDate to set
	 */
	public void setBeginDate(LocalDateTime beginDate) {
		this.beginDate = beginDate;
	}

	/** Getter for endDate
	 * @return the endDate
	 */
	public LocalDateTime getEndDate() {
		return endDate;
	}
	/** Setter for endDate
	 * @param endDate the endDate to set
	 */
	public void setEndDate(LocalDateTime endDate) {
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
	 *  Getter for status
	 * @return
	 */
	public AbsenceStatus getStatus() {
		return status;
	}

	/**
	 * Setter for status
	 * @param status
	 */
	public void setStatus(AbsenceStatus status) {
		this.status = status;
	}

	
}
