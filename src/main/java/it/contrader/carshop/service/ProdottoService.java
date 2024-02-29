package it.contrader.carshop.service;

import it.contrader.carshop.converter.ProdottoConverter;
import it.contrader.carshop.dao.ConcessionarioRepository;
import it.contrader.carshop.dao.ProdottoRepository;
import it.contrader.carshop.dto.ProdottoDTO;
import it.contrader.carshop.model.Prodotto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdottoService {

    @Autowired
   ConcessionarioService concessionarioService;

    @Autowired
    ProdottoRepository prodottoRepository;

    @Autowired
    ProdottoConverter prodottoConverter;

    public ProdottoDTO read (Long id){
        return prodottoConverter.toDTO(prodottoRepository.findById(id).orElseThrow(()-> new RuntimeException("prodotto non trovato")));
    }

//    public String nomeConcessionario (Long idprod){
//        return concessionarioService.read(read(idprod).getId_concessionario()).getNome();
//
//    }
}
