package it.contrader.carshop.controller;

import it.contrader.carshop.dto.AcquistoDTO;
import it.contrader.carshop.dto.ProdottoDTO;
import it.contrader.carshop.model.Acquisto;
import it.contrader.carshop.service.AcquistoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/acquistiModelli")
    public List<AcquistoDTO> AcquistiByProdottoModello(@RequestParam String modello) {
        return service.AcquistiByProdottoModello(modello);
    }

    @GetMapping("/acquistoConc")
    public ResponseEntity<List<AcquistoDTO>> AcquistiByConcessionario(@RequestParam Long concessionario) {
        List<AcquistoDTO> acquisti = service.AcquistiByConcessionario(concessionario);
        return ResponseEntity.ok(acquisti);
    }

    @GetMapping("/getAll")
    public List<AcquistoDTO> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete")
    public void delete(Long id){service.delete(id);};

    @GetMapping("/getAllPage")
    public Page<AcquistoDTO> getAllPage (@RequestParam ("pageNumber") int pageNumber, @RequestParam ("pageSize") int pageSize){
        return service.getAllPaginata(PageRequest.of(pageNumber,pageSize));
    }

    @GetMapping("/storicoUtente")
    public Page<AcquistoDTO> storicoUtente ( @RequestParam ("pageNumber") int pageNumber, @RequestParam ("pageSize") int pageSize, @RequestParam Long idUtente){
        return service.findAllByUtenteIdUtente  (PageRequest.of(pageNumber,pageSize), idUtente);
    }


//    @GetMapping("/getAllPaginata")
//    public Page<AcquistoDTO> getAllPaginata (@RequestParam("pageSize") int pageSize, @RequestParam("pageNumber") int pageNumber){
//        return service.getAllPaginata(pageSize, pageNumber);
//    }

}
