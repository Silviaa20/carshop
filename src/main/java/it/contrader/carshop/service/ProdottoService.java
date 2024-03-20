package it.contrader.carshop.service;

import it.contrader.carshop.converter.ProdottoConverter;
import it.contrader.carshop.dao.ProdottoRepository;
import it.contrader.carshop.dto.ProdottoDTO;
import it.contrader.carshop.exception.SomethingNotFoundException;
import it.contrader.carshop.model.Prodotto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdottoService {

    @Autowired
    ConcessionarioService concessionarioService;

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


    public ProdottoDTO read (long id) {

        return prodottoConverter.toDTO(prodottoRepository.findById(id).orElseThrow(() -> new SomethingNotFoundException("prodotto non trovato")));}



    public List<ProdottoDTO> ProdottiByConcessionario(Long concessionario) {
        return prodottoConverter.toDTOList(prodottoRepository.findByConcessionarioId(concessionario));
    }
    public Page<ProdottoDTO> getAllPaginata(Pageable pageable) {
        return prodottoConverter.toDTOpage(prodottoRepository.findAll(pageable));
    }

    public List <ProdottoDTO> readModello(String modello) {
        List<Prodotto> prodotti = prodottoRepository.findByModello(modello);
        return prodotti.stream()
                .map(prodottoConverter::toDTO) // Assumi che toDTO sia un metodo che converte Prodotto in ProdottoDTO
                .collect(Collectors.toList());
    }
    public List <ProdottoDTO> readMarchio(String marchio) {
        return prodottoConverter.toDTOList(prodottoRepository.findByMarchio(marchio));
    }

    public List <ProdottoDTO> readModelloAndMarchio (String modello,String marchio){
        return prodottoConverter.toDTOList(prodottoRepository.findByModelloAndMarchio(modello,marchio));
    }

    public List <ProdottoDTO> findByPrezzoBetween (Double minPrezzo, Double maxPrezzo){
        return prodottoConverter.toDTOList(prodottoRepository.findByPrezzoBetween(minPrezzo,maxPrezzo));
    }

}
