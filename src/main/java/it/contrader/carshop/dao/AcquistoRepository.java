package it.contrader.carshop.dao;

import it.contrader.carshop.model.Acquisto;
import it.contrader.carshop.model.Utente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface AcquistoRepository extends JpaRepository <Acquisto, Long>{

   public Page<Acquisto> findAllByUtenteIdutente(Pageable pageable, Long idUtente);


}
