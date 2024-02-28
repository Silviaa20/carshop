package it.contrader.carshop.dao;

import it.contrader.carshop.model.Anagrafica;
import it.contrader.carshop.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AnagraficaRepository extends JpaRepository<Anagrafica, Long> {

    public Anagrafica findByUtenteId(Long idutente);



}