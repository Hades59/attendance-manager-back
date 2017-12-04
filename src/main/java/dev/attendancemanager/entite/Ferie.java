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
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	
	/** jour: String */
	private String jour;
	
	/** commentaire: String */
	private String commentaire;
	
	/** type : FerieType 
	 * @see FerieType **/
	private FerieType type;
	
	@ManyToOne
	@JsonIgnore
	private User user;

	/**
	 * Empty constructor
	 */
	public Ferie () {
		super();
	}
	
	public Ferie (LocalDate date, String jour, String commentaire, FerieType type) {
		super();
		this.date = date;
		this.jour = jour;
		this.commentaire = commentaire;
		this.type = type;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public FerieType getType() {
		return type;
	}

	public void setType(FerieType type) {
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
