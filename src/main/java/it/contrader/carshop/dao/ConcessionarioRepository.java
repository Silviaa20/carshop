package it.contrader.carshop.dao;

import it.contrader.carshop.model.Concessionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcessionarioRepository extends JpaRepository <Concessionario, Long> {
}
