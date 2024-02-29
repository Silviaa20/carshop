package it.contrader.carshop.controller;

import it.contrader.carshop.dto.ConcessionarioDTO;
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

    @GetMapping("/read")
    public ConcessionarioDTO read (@RequestParam Long id){
        return  service.read(id);
    }

    @PostMapping("/insert")
    public ConcessionarioDTO insert (@RequestBody ConcessionarioDTO dto){
        return service.insert(dto);
    }

    @PutMapping("/update")
    public ConcessionarioDTO update (@RequestBody ConcessionarioDTO dto){
        return service.update(dto);
    }

    @DeleteMapping("/delete")
    public void delete (@RequestParam Long id){
        service.delete(id);
    }

    @GetMapping("/getAll")
    public List<ConcessionarioDTO> getAll(){
        return  service.getAll();
    }
    @GetMapping("/getAllPage")
    public Page<ConcessionarioDTO> getAllPage (@RequestParam ("pageNumber") int pageNumber,@RequestParam ("pageSize") int pageSize){
        return service.getAllPaginata(PageRequest.of(pageNumber,pageSize));
    }
    //i parametri di tipo pageable vengono qui spacchettati e poi riuniti con "PageRequest.of"
}
