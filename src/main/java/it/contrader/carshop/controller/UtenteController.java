package it.contrader.carshop.controller;


import it.contrader.carshop.dto.AnagraficaDTO;
import it.contrader.carshop.dto.LoginDTO;
import it.contrader.carshop.dto.UtenteDTO;
import it.contrader.carshop.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/utente")
@CrossOrigin(origins = "http://localhost:4200")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @PostMapping(value = "/login")
    public ResponseEntity<UtenteDTO> login(@RequestBody @Valid LoginDTO loginDTO) {
        UtenteDTO user = utenteService.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("getAllPaginata")
    public ResponseEntity<Page<UtenteDTO>> getall(@RequestParam("pageSize") int pageSize, @RequestParam("pageNumber") int pageNumber ) {
        return new ResponseEntity<>(utenteService.getAllPaginata(PageRequest.of(pageNumber, pageSize)), HttpStatus.OK);
    }

    @GetMapping("/reademail")
    public UtenteDTO reademail(String email) {
        return utenteService.reademail(email);
    }

    @DeleteMapping("/delete")
    public void  delete (@RequestParam Long id){
        utenteService.delete(id);
    }

    @PostMapping("/insert")
    public ResponseEntity<UtenteDTO> insert (@RequestBody UtenteDTO utenteDTO) {
        return new ResponseEntity<>(utenteService.save(utenteDTO), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public List<UtenteDTO> getAll(){
        return utenteService.getAll();
    }

    @PutMapping("/update")
    public ResponseEntity<UtenteDTO> update (@RequestBody UtenteDTO utenteDTO) {
        return new ResponseEntity<>(utenteService.save(utenteDTO), HttpStatus.OK);
    }

    @GetMapping("/read")
    public  UtenteDTO read (@RequestParam Long id) {
        return utenteService.read(id);
    }


}
