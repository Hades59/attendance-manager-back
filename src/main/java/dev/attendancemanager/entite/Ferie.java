/**
 * 
 */
package dev.attendancemanager.entite;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author ETY8
 *
 */
@Entity
public class Ferie {

	/** id : Integer */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** Date : LocalDate*/
	@Column
	private LocalDate date;
	
	/** commentaire: String */
	private String commentaire;
	
	/** type : FerieType 
	 * @see FerieType **/
	private FerieType type;
	
	/**
	 * Empty constructor
	 */
	public Ferie () {
		super();
	}
	
	/**
	 * Constructor using fields
	 * @param date
	 * @param type
	 * @param commentaire
	 */
	public Ferie (LocalDate date, FerieType type, String commentaire) {
		super();
		this.date = date;
		this.commentaire = commentaire;
		this.type = type;
		
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

	/** Getter for date
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/** Setter for date
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/** Getter for commentaire
	 * @return the commentaire
	 */
	public String getCommentaire() {
		return commentaire;
	}

	/** Setter for commentaire
	 * @param commentaire the commentaire to set
	 */
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	/** Getter for type
	 * @return the type
	 */
	public FerieType getType() {
		return type;
	}
	
	/** Setter for type
	 * @param type the type to set
	 */
	public void setType(FerieType type) {
		this.type = type;
	}

}
