package it.contrader.carshop.controller;

import it.contrader.carshop.dto.AcquistoDTO;
import it.contrader.carshop.service.AcquistoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acquisto")
@CrossOrigin(origins = "http://localhost:4200")
public class AcquistoController {
@Autowired
    AcquistoService service;

    @PostMapping("/insert")
    public AcquistoDTO insert (@RequestBody AcquistoDTO dto){
        return service.insert(dto);
    }

    @PutMapping("/update")
    public AcquistoDTO update (@RequestBody AcquistoDTO dto){
        return service.update(dto);
    }

    @GetMapping("/read")
    public AcquistoDTO read (@RequestParam Long id){
        return service.read(id);
    }

    @GetMapping("/getAll")
    public List<AcquistoDTO> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete")
    public void delete(Long id){service.delete(id);};

//    @GetMapping("/getAllPaginata")
//    public Page<AcquistoDTO> getAllPaginata (@RequestParam("pageSize") int pageSize, @RequestParam("pageNumber") int pageNumber){
//        return service.getAllPaginata(pageSize, pageNumber);
//    }

}