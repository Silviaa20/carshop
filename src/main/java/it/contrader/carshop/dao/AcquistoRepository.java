package it.contrader.carshop.dao;

import it.contrader.carshop.model.Acquisto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AcquistoRepository extends JpaRepository <Acquisto, Long>{
}
