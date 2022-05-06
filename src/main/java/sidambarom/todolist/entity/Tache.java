package sidambarom.todolist.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Date : Mai 05-2022
 * Classe qui permet de mapper l'entité "TACHE" de la BD.
 * Il s'agit d'une Entity
 * @author Thomas Sidambarom
 * @version 1.0
 *
 */
@Entity
@Table(name = "tache")
public class Tache {
	/**
     * int : id de l'objet TACHE
     */
	@Id
	@GeneratedValue
	private int tacheId;
	
	/**
     * String : titre de la TACHE
     */
	private String titre;
	/**
     * String : description de la TACHE
     */
	private String description;
	
	/**
     * boolean : si = 0 alors tache PAS TERMINE , si = 1 alors tache TERMINE
     */
	private boolean etat;
	
	/**
     * Date : date de la création d'une TACHE
     */
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	/**
     * User : id du USER à laquelle la TACHE est lié (clé étrangère)
     */
	@ManyToOne(cascade = CascadeType.ALL , optional = true)
	@JoinColumn(name = "users_id")
	private Users user;
	
	/**
     * List<String> : Liste des étiquette lié à une TACHE
     */
	@Transient
	private List<String> etiquettes = new ArrayList<String>();

	
	public Tache() {}
	

	public List<String> getEtiquettes() {
		return etiquettes;
	}


	public void setEtiquettes(List<String> etiquettes) {
		this.etiquettes = etiquettes;
	}


	public long getTacheId() {
		return tacheId;
	}

	public void setTacheId(int tacheId) {
		this.tacheId = tacheId;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}


}
