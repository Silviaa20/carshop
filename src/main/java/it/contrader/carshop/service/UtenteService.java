package it.contrader.carshop.service;

import it.contrader.carshop.converter.UtenteConverter;
import it.contrader.carshop.dao.UtenteRepository;
import it.contrader.carshop.dto.UtenteDTO;
import it.contrader.carshop.exception.InvalidCredentials;
import it.contrader.carshop.exception.UserNotFoundException;
import it.contrader.carshop.model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {

    @Autowired
    public UtenteConverter converter;

    @Autowired
    public UtenteRepository repository;

    @Autowired
    AnagraficaService anagraficaService;


    public UtenteDTO findByEmailAndPassword(String email, String password) {
        return converter.toDTO(((UtenteRepository) repository).findByEmailAndPassword(email, password)
                .orElseThrow(() -> new InvalidCredentials("Credenziali Errate")));
    }

    public Page<UtenteDTO> getAllPaginata(Pageable pageable) {
        Page<Utente> page = ((UtenteRepository) repository).findAll(pageable);
        return ((UtenteConverter) converter).convertToDTOPage(page);
    }

    public List<UtenteDTO> getAll(){
        return converter.toDTOList(repository.findAll());
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public UtenteDTO read(Long id) {
        return converter.toDTO(repository.findById(id).orElseThrow(() -> new UserNotFoundException("utente non trovato")));
    }


    public UtenteDTO save(UtenteDTO utenteDTO) {
        return converter.toDTO(repository.save(converter.toEntity(utenteDTO)));
    }

    public UtenteDTO reademail(String email) {
        return converter.toDTO(((UtenteRepository) repository).findByEmail(email).orElseThrow(() -> new InvalidCredentials("Email sbagliata coglione")));
    }


}
