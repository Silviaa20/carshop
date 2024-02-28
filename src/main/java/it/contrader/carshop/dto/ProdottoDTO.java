package it.contrader.carshop.dto;
import it.contrader.carshop.model.Concessionario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProdottoDTO {
    private Long id;
    private String marchio;
    private String modello;
    private Double prezzo;
    private Long quantita;
    private Concessionario concessionario;
}
