package it.contrader.carshop.dao;
import it.contrader.carshop.dto.ProdottoDTO;
import it.contrader.carshop.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto,Long> {

    List <Prodotto> findByModello (String modello);

    List <Prodotto> findByMarchio (String marchio);

    List <Prodotto> findByModelloAndMarchio (String modello,String marchio);

    List<Prodotto> findByConcessionarioId(Long concessionario);
}
