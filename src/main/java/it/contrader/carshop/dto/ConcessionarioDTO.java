package it.contrader.carshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConcessionarioDTO {
    private Long id;

    private String nome;

    private String indirizzo;

    private String citta;

    private UtenteDTO utente;
}
