package it.contrader.carshop.controller;

import it.contrader.carshop.dto.ProdottoDTO;
import it.contrader.carshop.service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prodotto")
@CrossOrigin("localhost://4200")
public class ProdottoController {

    @Autowired
    ProdottoService service;

    @GetMapping("/read")
    public ProdottoDTO read (@RequestParam Long id){
        return service.read(id);
    }

//    @GetMapping("/readnome_c")
//    public String readnome_c (@RequestParam Long id) {
//        return  service.nomeConcessionario(id);
//    }
}
