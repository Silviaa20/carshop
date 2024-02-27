package it.contrader.carshop.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class AnagraficaDTO {

    private Long id;

    private String nome;

    private String cognome;

    private LocalDate data_di_nascita;

    private String genere;

    private String nazione;

    private String provincia;

    private String citta_di_residenza;

    private String indirizzo_di_residenza;

    private UtenteDTO idutente;
}
