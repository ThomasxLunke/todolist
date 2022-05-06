package sidambarom.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sidambarom.todolist.entity.Users;

/**
 * Date : Mai 05-2022
 * Classe qui sert de lien entre la BD et l'ENTITY pour l'objet USERS.
 * Elle permet également de créé des requêtes personaliser, autre que celle de base proposé par l'interface JpaRepository
 * Il s'agit d'un Repository
 * @author Thomas Sidambarom
 * @version 1.0
 *
 */
public interface UsersRepository extends JpaRepository<Users,Integer> {
	
	@Query("SELECT u FROM Users u WHERE u.login = ?1")
    public Users findByLogin(String login);
}
