package it.contrader.carshop.dao;

import it.contrader.carshop.model.Concessionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ConcessionarioRepository extends JpaRepository <Concessionario, Long> {
}
