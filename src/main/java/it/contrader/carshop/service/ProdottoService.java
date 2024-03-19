package it.contrader.carshop.service;

import it.contrader.carshop.converter.ProdottoConverter;
import it.contrader.carshop.dao.ConcessionarioRepository;
import it.contrader.carshop.dao.ProdottoRepository;
import it.contrader.carshop.dto.ConcessionarioDTO;
import it.contrader.carshop.dto.ProdottoDTO;
import it.contrader.carshop.model.Prodotto;
import it.contrader.carshop.dto.ProdottoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdottoService {

    @Autowired
    ProdottoRepository prodottoRepository;

    @Autowired
    ProdottoConverter prodottoConverter;


    public ProdottoDTO insert (ProdottoDTO prodottoDTO){
        return prodottoConverter.toDTO(prodottoRepository.save(prodottoConverter.toEntity(prodottoDTO)));
    }

    public ProdottoDTO update (ProdottoDTO prodottoDTO){
        return prodottoConverter.toDTO(prodottoRepository.save(prodottoConverter.toEntity(prodottoDTO)));
    }

    public void delete (long id) {prodottoRepository.deleteById(id);}


    public List <ProdottoDTO> getAll() {return prodottoConverter.toDTOList(prodottoRepository.findAll());}


    public ProdottoDTO read (long id) {return prodottoConverter.toDTO(prodottoRepository.findById(id).get());}

    public Page<ProdottoDTO> getAllPaginata(Pageable pageable) {
        Page<Prodotto> page = prodottoRepository.findAll(pageable);
        return prodottoConverter.toDTOpage(page);
    }

}
