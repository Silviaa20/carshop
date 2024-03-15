package it.contrader.carshop.controller;

import it.contrader.carshop.dto.ConcessionarioDTO;
import it.contrader.carshop.dto.ProdottoDTO;
import it.contrader.carshop.service.ConcessionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/concessionario")
@CrossOrigin(origins = "http://localhost:4200")
public class ConcessionarioController {

    @Autowired
    ConcessionarioService service;

    @GetMapping("/getAllPage")
    public Page<ConcessionarioDTO> getAllPage (@RequestParam ("pageNumber") int pageNumber,@RequestParam ("pageSize") int pageSize){
        return service.getAllPaginata(PageRequest.of(pageNumber,pageSize));
    }

    //i parametri di tipo pageable vengono qui spacchettati e poi riuniti con "PageRequest.of"


    @GetMapping("/sommaProdotti")
    public Long sommaProdotti (@RequestParam Long id){
        return service.sommaProdotti(id);
    }


    @GetMapping("/emailconc")
    public List<ConcessionarioDTO> findByEmailUtente (@RequestParam String email){
        return service.findByEmail(email);
    }



}
