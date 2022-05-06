package sidambarom.todolist.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Date : Mai 05-2022
 * Classe qui permet de mapper l'entité "ETIQUETTE" de la BD.
 * Il s'agit d'une Entity
 * @author Thomas Sidambarom
 * @version 1.0
 *
 */
@Entity
@Table(name = "etiquette")
public class Etiquette {
	
	 /**
     * int : id de l'objet ETIQUETTE
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int etiquette_id;
	
	/**
     * String : nom de l'ETIQUETTE
     */
	private String nom;
	
	/**
     * Tache : id de la TACHE à laquelle l'"ETIQUETTE" est lié (clé étrangère)
     */
	@ManyToOne(cascade = CascadeType.ALL , optional = true)
	@JoinColumn(name = "tache_id")
	private Tache tache;
	
	public Etiquette() {}

	public int getEtiquette_id() {
		return etiquette_id;
	}

	public void setEtiquette_id(int etiquette_id) {
		this.etiquette_id = etiquette_id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Tache getTache() {
		return tache;
	}

	public void setTache(Tache tache) {
		this.tache = tache;
	}
	
	
	
}
