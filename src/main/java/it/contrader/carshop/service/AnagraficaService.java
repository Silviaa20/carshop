package it.contrader.carshop.service;

import it.contrader.carshop.converter.AnagraficaConverter;
import it.contrader.carshop.dao.AnagraficaRepository;
import it.contrader.carshop.dto.AnagraficaDTO;
import it.contrader.carshop.model.Anagrafica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class AnagraficaService {

    @Autowired
    public AnagraficaRepository repository;

    @Autowired
    public AnagraficaConverter converter;


    public AnagraficaDTO findById(Long id) {
        Anagrafica a = repository.findById(id).get();
        return converter.toDTO(a);
    }

    public List<AnagraficaDTO> getAll(){
        return converter.toAnagraficaDTOList(repository.findAll());
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

    public AnagraficaDTO save(AnagraficaDTO anagraficaDTO) {
        return converter.toDTO(repository.save(converter.toEntity(anagraficaDTO)));
    }


}
