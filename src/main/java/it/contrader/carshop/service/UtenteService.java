package it.contrader.carshop.service;

import it.contrader.carshop.converter.UtenteConverter;
import it.contrader.carshop.dao.UtenteRepository;
import it.contrader.carshop.dto.UtenteDTO;
import it.contrader.carshop.exceptions.InvalidCredentialsException;
import it.contrader.carshop.model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class UtenteService {

    @Autowired
    public UtenteConverter converter;

    @Autowired
    public UtenteRepository repository;


    public UtenteDTO findByEmailAndPassword(String email, String password) {
        return converter.toDTO(((UtenteRepository)repository).findByEmailAndPassword(email, password)
                .orElseThrow(() -> new InvalidCredentialsException("Credenziali Errate")));
    }

    public Page<UtenteDTO> getAllPaginata(Pageable pageable) {
        Page<Utente> page = ((UtenteRepository) repository).findAll(pageable);
        return ((UtenteConverter)converter).convertToDTOPage(page);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public UtenteDTO read(Long id){
        return converter.toDTO(repository.findById(id).orElse(null));
    }


    public Page<UtenteDTO> getAllPaginataAdmin(Pageable pageable, String idutente) {
        return null;
    }

    public UtenteDTO save(UtenteDTO utenteDTO, Long id) {
        return converter.toDTO(repository.save(converter.toEntity(utenteDTO)));
    }

}
