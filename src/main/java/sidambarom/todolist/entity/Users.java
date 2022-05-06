package sidambarom.todolist.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Date : Mai 05-2022
 * Classe qui permet de mapper l'entité "USERS" de la BD.
 * Il s'agit d'une Entity
 * @author Thomas Sidambarom
 * @version 1.0
 *
 */
@Entity
@Table(name = "users")
public class Users {
	/**
     * int : id de l'objet USERS
     */
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int users_id;
	
	/**
     * String : login de l'objet USERS
     */
	
	private String login;
	/**
     * String : mot de passe de l'objet USERS
     */
	
	private String mdp;
	/**
     * String : nom de l'objet USERS
     */
	
	private String nom;
	/**
     * String : prénom de l'objet USERS
     */
	
	private String prenom;
	
	/**
     * List<Tache> : liste de TACHE de l'objet USERS
     */
	@OneToMany(targetEntity = Tache.class, mappedBy = "user")
	private List<Tache> taches;
	
	public List<Tache> getTaches() {
		return taches;
	}

	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}

	public Users() {}
	
	public int getUsers_id() {
		return users_id;
	}

	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	
	  
}
