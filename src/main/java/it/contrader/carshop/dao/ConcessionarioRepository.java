package it.contrader.carshop.dao;

import it.contrader.carshop.model.Concessionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ConcessionarioRepository extends JpaRepository <Concessionario, Long> {

    @Query("SELECT SUM(p.quantita) FROM Prodotto p WHERE p.concessionario.id = :idConcessionario")
    Long sommaProdottiByConcessionario ( Long idConcessionario);

    List<Concessionario> findByUtenteEmail(String email);


}
