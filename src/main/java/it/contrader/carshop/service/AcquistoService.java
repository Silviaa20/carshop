package it.contrader.carshop.service;

import it.contrader.carshop.converter.AcquistoConverter;
import it.contrader.carshop.dao.AcquistoRepository;
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
public class AcquistoService {

    @Autowired
    AcquistoConverter acquistoConverter;
    @Autowired
    AcquistoRepository acquistoRepository;

    public AcquistoDTO insert (AcquistoDTO dto){
        return acquistoConverter.toDTO(acquistoRepository.save(acquistoConverter.toEntity(dto)));
    }

    public AcquistoDTO update (AcquistoDTO dto) {
        return acquistoConverter.toDTO(acquistoRepository.save(acquistoConverter.toEntity(dto)));
    }

    public AcquistoDTO read (Long id){
        return acquistoConverter.toDTO(acquistoRepository.findById(id).orElseThrow(()-> new RuntimeException("acquisto non trovato")));
    }

    public List<AcquistoDTO> getAll(){
        return acquistoConverter.toListAcquistoDTO(acquistoRepository.findAll());
    }

    public void delete(long id) {
        acquistoRepository.deleteById(id);
    }

    public Page<AcquistoDTO> getAllPaginata(Pageable pageable) {
        return acquistoConverter.toDTOpage(acquistoRepository.findAll(pageable));
    }


//    public Page<AcquistoDTO> getAllPaginata(Pageable pageable) {
//        Page<Acquisto> page = acquistoRepository.findAll(pageable);
//        List<AcquistoDTO> acquistoDTO = page.getContent().stream()
//                .map(acquistoConverter::toDTO)
//                .collect(Collectors.toList());
//        return new PageImpl<>(acquistoDTO, pageable, page.getTotalElements());
//    } GETALL PAGINATA non usata
}
