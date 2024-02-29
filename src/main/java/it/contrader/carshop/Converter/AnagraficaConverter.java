package it.contrader.carshop.converter;


import it.contrader.carshop.dto.AnagraficaDTO;
import it.contrader.carshop.model.Anagrafica;
import it.contrader.carshop.model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AnagraficaConverter {


    @Autowired
    public UtenteConverter userConverter;


    public Anagrafica toEntity(AnagraficaDTO anagraficaDTO) {
        Anagrafica anagrafica = null;
        Utente utente1 = new Utente();
        utente1.setIdutente(anagraficaDTO.getId_utente());
        return anagraficaDTO != null ? Anagrafica.builder()
                .id(anagraficaDTO.getId())
                .nome(anagraficaDTO.getNome())
                .cognome(anagraficaDTO.getCognome())
                .data_di_nascita(anagraficaDTO.getData_di_nascita())
                .genere(anagraficaDTO.getGenere())
                .nazione(anagraficaDTO.getNazione())
                .provincia(anagraficaDTO.getProvincia())
                .citta_di_residenza(anagraficaDTO.getCitta_di_residenza())
                .indirizzo_di_residenza(anagraficaDTO.getIndirizzo_di_residenza())
                .utente(utente1)
                .build() : null;
    }


    public AnagraficaDTO toDTO(Anagrafica anagrafica) {
        return anagrafica != null ? AnagraficaDTO.builder()
                .id(anagrafica.getId())
                .nome(anagrafica.getNome())
                .cognome(anagrafica.getCognome())
                .data_di_nascita(anagrafica.getData_di_nascita())
                .genere(anagrafica.getGenere())
                .nazione(anagrafica.getNazione())
                .provincia(anagrafica.getProvincia())
                .citta_di_residenza(anagrafica.getCitta_di_residenza())
                .indirizzo_di_residenza(anagrafica.getIndirizzo_di_residenza())
                .id_utente(anagrafica.getUtente().getIdutente())
                .build() : null;
    }


    protected Class<AnagraficaDTO> getDTOClass() {
        return AnagraficaDTO.class;
    }


    public List<Anagrafica> toAnagraficaList(List<AnagraficaDTO> list) {
        return list.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }


    public List<AnagraficaDTO> toAnagraficaDTOList(List<Anagrafica> list) {
        return list.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());


    }

}