package it.contrader.carshop.dao;

import it.contrader.carshop.model.Acquisto;
import it.contrader.carshop.model.Prodotto;
import it.contrader.carshop.model.Utente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface AcquistoRepository extends JpaRepository <Acquisto, Long>{

    List<Acquisto> findByProdotto_Modello(String modello);

    List<Acquisto> findByProdottoConcessionarioId(Long concessionario);

   public Page<Acquisto> findAllByUtenteIdutente(Pageable pageable, Long idUtente);


}
