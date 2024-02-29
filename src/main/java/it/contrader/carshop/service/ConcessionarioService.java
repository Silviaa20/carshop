package it.contrader.carshop.service;

import it.contrader.carshop.converter.ConcessionarioConverter;
import it.contrader.carshop.dao.ConcessionarioRepository;
import it.contrader.carshop.dto.AcquistoDTO;
import it.contrader.carshop.dto.ConcessionarioDTO;
import it.contrader.carshop.model.Acquisto;
import it.contrader.carshop.model.Concessionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConcessionarioService {

    @Autowired
    ConcessionarioRepository concessionarioRepository;

    @Autowired
    ConcessionarioConverter concessionarioConverter;

    public ConcessionarioDTO insert (ConcessionarioDTO dto){
        return concessionarioConverter.toDTO(concessionarioRepository.save(concessionarioConverter.toEntity(dto)));
    }

    public ConcessionarioDTO update (ConcessionarioDTO dto) {
        return concessionarioConverter.toDTO(concessionarioRepository.save(concessionarioConverter.toEntity(dto)));
    }

    public ConcessionarioDTO read (Long id){
        return concessionarioConverter.toDTO(concessionarioRepository.findById(id).orElseThrow(()-> new RuntimeException("concessionario non trovato")));
    }

    public List<ConcessionarioDTO> getAll(){
        return concessionarioConverter.toListConcessionarioDTO(concessionarioRepository.findAll());
    }

    public void delete(long id) {
        concessionarioRepository.deleteById(id);
    }


    public Page<ConcessionarioDTO> getAllPaginata(Pageable pageable) {
       return concessionarioConverter.toDTOpage(concessionarioRepository.findAll(pageable));
    }

    //dal repository prendo la find all di tipo Pageable che sarà un'entità
    //La converto grazie al nostro converter in DTO

}
