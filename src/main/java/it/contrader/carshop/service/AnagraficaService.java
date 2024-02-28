package it.contrader.carshop.service;

import it.contrader.carshop.converter.AnagraficaConverter;
import it.contrader.carshop.dao.AnagraficaRepository;
import it.contrader.carshop.dto.AnagraficaDTO;
import it.contrader.carshop.dto.UtenteDTO;
import it.contrader.carshop.model.Anagrafica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class AnagraficaService {

    @Autowired
    public AnagraficaRepository repository;

    @Autowired
    public AnagraficaConverter converter;


    public AnagraficaDTO findByUtenteId(Long idutente) {
        Anagrafica a = repository.findByUtenteId(idutente);
        return converter.toDTO(a);
    }

    public Page<AnagraficaDTO> getAllPaginata(Pageable pageable) {
        Page<Anagrafica> page = repository.findAll(pageable);
        return converter.convertToDTOPage(page);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public AnagraficaDTO read(Long id){
        return converter.toDTO(repository.findById(id).orElse(null));
    }

    public AnagraficaDTO save(AnagraficaDTO anagraficaDTO, Long id) {
        return converter.toDTO(repository.save(converter.toEntity(anagraficaDTO)));
    }


}
