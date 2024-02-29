package it.contrader.carshop.converter;

import it.contrader.carshop.dto.AcquistoDTO;
import it.contrader.carshop.dto.ConcessionarioDTO;
import it.contrader.carshop.model.Acquisto;
import it.contrader.carshop.model.Concessionario;
import it.contrader.carshop.model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConcessionarioConverter {

    @Autowired
    private UtenteConverter utenteConverter;
 public Concessionario toEntity (ConcessionarioDTO concessionarioDTO){
     Concessionario concessionario = null;
     Utente utente1 = new Utente();
     utente1.setIdutente(concessionarioDTO.getId_utente());
     return concessionarioDTO != null ? Concessionario.builder()
             .id(concessionarioDTO.getId())
             .nome(concessionarioDTO.getNome())
             .indirizzo(concessionarioDTO.getIndirizzo())
             .citta(concessionarioDTO.getCitta())
             .utente(utente1)
             .build() : null;
 }

    public ConcessionarioDTO toDTO (Concessionario concessionario){
        return concessionario != null ? ConcessionarioDTO.builder()
                .id(concessionario.getId())
                .nome(concessionario.getNome())
                .indirizzo(concessionario.getIndirizzo())
                .citta(concessionario.getCitta())
                .id_utente(concessionario.getUtente().getIdutente())
                .build() : null;
    }

    public List<Concessionario> toListConcessionario(List<ConcessionarioDTO> concessionarioDTOList){
        return concessionarioDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    };

    public List<ConcessionarioDTO> toListConcessionarioDTO(List<Concessionario> concessionarioList){
        return concessionarioList.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    };

    public Page<ConcessionarioDTO> convertToPage(List<ConcessionarioDTO> concessionari, Pageable pageable) {
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), concessionari.size());

        return new PageImpl<>(concessionari.subList(start, end), pageable, concessionari.size());
    }

    public Page <ConcessionarioDTO> toDTOpage (Page <Concessionario> concessionarioPage){
        return concessionarioPage.map(c -> toDTO(c));
                                //mappiamo ogni elemento (c) di concessionarioPage e lo trasformiamo in tipo dto
    }



}
