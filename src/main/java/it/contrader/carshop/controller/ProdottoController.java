package it.contrader.carshop.controller;
<<<<<<<<< Temporary merge branch 1
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import it.contrader.carshop.service.ProdottoService;
import it.contrader.carshop.dto.ProdottoDTO;
import java.util.List;
@RestController


@RequestMapping("/prodotto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProdottoController {

@Autowired
ProdottoService prodottoService;


@PostMapping("/insert")
    public ProdottoDTO insert(@RequestBody ProdottoDTO dto){
    return prodottoService.insert(dto);}
        
    @GetMapping("/prodottoConc")
    public ResponseEntity<List<ProdottoDTO>> ProdottiByConcessionario(@RequestParam Long concessionario) {
        List<ProdottoDTO> prodotti = prodottoService.ProdottiByConcessionario(concessionario);
        return ResponseEntity.ok(prodotti);
    }

    @DeleteMapping("/delete")
    public void delete (@RequestParam  long id ) {
    prodottoService.delete(id);
}

    @PutMapping("/update")
    public ProdottoDTO update (@RequestBody ProdottoDTO dto){
    return prodottoService.update(dto);
}

    @GetMapping("/getAllPage")
    public Page<ProdottoDTO> getAllPage (@RequestParam ("pageNumber") int pageNumber, @RequestParam ("pageSize") int pageSize){
        return prodottoService.getAllPaginata(PageRequest.of(pageNumber,pageSize));
    }
    @GetMapping("/read")
    public ProdottoDTO read (@RequestParam Long id ) {
    return prodottoService.read(id);
}

    @GetMapping("/getAll")
    public List <ProdottoDTO> getAll (){
        return  prodottoService.getAll();
    }

    @GetMapping("/findByPrezzoBetween")
    public List <ProdottoDTO> findByPrezzoBetween (@RequestParam Double minPrezzo, @RequestParam Double maxPrezzo){
        return prodottoService.findByPrezzoBetween(minPrezzo, maxPrezzo);
    }

//    @GetMapping("/countByMarchioAndModello")
//    public Long countByMarchioAndModello (@RequestParam String marchio, @RequestParam String modello, @RequestParam Long id){
//        return prodottoService.countByMarchioAndModello(marchio, modello, id);
//    }

}
    @GetMapping("/readModello")
    public ResponseEntity<List<ProdottoDTO>> readModello(@RequestParam String modello){
        List<ProdottoDTO> prodottiDTO = prodottoService.readModello(modello);
        return ResponseEntity.ok(prodottiDTO);
    }

   @GetMapping("/readMarchio")
    public List<ProdottoDTO> readMarchio (@RequestParam String marchio){
        return prodottoService.readMarchio(marchio);
    }

    @GetMapping("/readModelloAndMarchio")
    public List<ProdottoDTO> readModelloAndMarchio (@RequestParam String modello, @RequestParam String marchio){
        return prodottoService.readModelloAndMarchio(modello, marchio);
    }

}
//    @GetMapping("/readnome_c")
//    public String readnome_c (@RequestParam Long id) {
//        return  service.nomeConcessionario(id);
//    }
>>>>>>>>> Temporary merge branch 2

