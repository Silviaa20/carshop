package it.contrader.carshop.controller;
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
    System.out.println(dto.toString());
    return prodottoService.insert(dto);
}

@DeleteMapping("/delete")
    public void delete (@RequestParam  long id ) {
    prodottoService.delete(id);
}

@PutMapping("/update")
    public ProdottoDTO update (@RequestBody ProdottoDTO dto){
    return prodottoService.update(dto);
}

@GetMapping("/getall")
    public List <ProdottoDTO> getall() {
    return prodottoService.getAll();
}
@GetMapping("/read")
    public ProdottoDTO read (@RequestParam Long id ) {
    return prodottoService.read(id);
}


}
//    @GetMapping("/readnome_c")
//    public String readnome_c (@RequestParam Long id) {
//        return  service.nomeConcessionario(id);
//    }
//}
