package sidambarom.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sidambarom.todolist.entity.Etiquette;

/**
 * Date : Mai 05-2022
 * Classe qui sert de lien entre la BD et l'ENTITY pour l'objet ETIQUETTE.
 * Elle permet également de créé des requêtes personaliser, autre que celle de base proposé par l'interface JpaRepository
 * Il s'agit d'un Repository
 * @author Thomas Sidambarom
 * @version 1.0
 *
 */
public interface EtiquetteRepository extends JpaRepository<Etiquette,Integer> {

}
