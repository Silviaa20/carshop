package it.contrader.carshop.dao;

import it.contrader.carshop.model.Utente;
import it.contrader.carshop.model.Anagrafica;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


/**
 * Estende CrudRepository ed eredita tutti i metodi di CRUD. 
 * Definisce il metodo di login.
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 *
 * @see CrudRepository
 *
 */
@Repository
@Transactional
public interface UtenteRepository extends JpaRepository<Utente, Long> {

	//Optional<Utente> findByEmailAndPassword(String email, String password);

	//Utente findByEmail(String email);

	//Page<Utente> findAll(Pageable pageable);

	//List<Utente> findByUsertype(Utente.Usertype usertype);


}
