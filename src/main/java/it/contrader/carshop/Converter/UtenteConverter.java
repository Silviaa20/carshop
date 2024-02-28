package it.contrader.carshop.Converter;

import it.contrader.carshop.dto.AnagraficaDTO;
import it.contrader.carshop.dto.UtenteDTO;
import it.contrader.carshop.model.Anagrafica;
import it.contrader.carshop.model.Utente;
import it.contrader.carshop.model.Utente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UtenteConverter {


    public Utente toEntity(UtenteDTO utenteDTO) {
        return utenteDTO != null ? Utente.builder()
                .idutente(utenteDTO.getIdutente())
                .email(utenteDTO.getEmail())
                .password(utenteDTO.getPassword())
                .usertype(utenteDTO.getUsertype())
                .build() : null;
    }


    public UtenteDTO toDTO(Utente utente) {
        return utente != null ? UtenteDTO.builder()
                .idutente(utente.getIdutente())
                .email(utente.getEmail())
                .password(utente.getPassword())
                .usertype(utente.getUsertype())
                .build() : null;
    }

    private final ModelMapper modelMapper = new ModelMapper();

    public Page<UtenteDTO> convertToDTOPage(Page<Utente> utentePage) {
        return utentePage.map(user -> modelMapper.map(user, UtenteDTO.class));
    }

    public List<UtenteDTO> toDTOList(List<Utente> list) {
        return list.stream()
                .map(this::toUtenteDTO)
                .collect(Collectors.toList());


    }

    public List<Utente> toList(List<UtenteDTO> list) {
        return list.stream()
                .map(this::toUtente)
                .collect(Collectors.toList());
    }
    protected Class<UtenteDTO> getDTOClass() {
        return UtenteDTO.class;
    }
}


