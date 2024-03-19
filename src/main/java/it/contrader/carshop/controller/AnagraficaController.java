package it.contrader.carshop.controller;

import it.contrader.carshop.dto.AnagraficaDTO;
import it.contrader.carshop.service.AnagraficaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anag")
@CrossOrigin(origins = "http://localhost:4200")
public class AnagraficaController {

    @Autowired
    private AnagraficaService service;


    @PostMapping("/insert")
    public ResponseEntity<AnagraficaDTO> insert (@RequestBody AnagraficaDTO anagraficaDTO) {
        return new ResponseEntity<>(service.save(anagraficaDTO), HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<AnagraficaDTO> update (@RequestBody AnagraficaDTO anagraficaDTO) {
        return new ResponseEntity<>(service.save(anagraficaDTO), HttpStatus.OK);
    }

    @GetMapping("/read")
    public  AnagraficaDTO read (@RequestParam Long id) {
        return service.read(id);
    }

    @DeleteMapping("/delete")
    public void  delete (@RequestParam Long id){
        service.delete(id);
    }

    @GetMapping("/getAll")
    public List<AnagraficaDTO> getAll(){
        return service.getAll();
    }


    @GetMapping("/getAllPaginata")
    public ResponseEntity<Page<AnagraficaDTO>> getallPageable(@RequestParam("pageSize") int pageSize, @RequestParam("pageNumber") int pageNumber) {
        return new ResponseEntity<>(service.getAllPaginata(PageRequest.of(pageNumber, pageSize)), HttpStatus.OK);
    }
    

}
