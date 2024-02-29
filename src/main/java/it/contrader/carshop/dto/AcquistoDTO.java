package it.contrader.carshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AcquistoDTO {
    private Long id;

    private LocalDate data_acquisto;

    private Long id_utente;

    private Long id_prodotto;
}
