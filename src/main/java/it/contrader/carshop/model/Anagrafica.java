package it.contrader.carshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder

public class Anagrafica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String cognome;

    @Column
    private LocalDate data_di_nascita;

    @Column
    private String genere;

    @Column
    private String nazione;

    @Column
    private String provincia;

    @Column
    private String citta_di_residenza;

    @Column
    private String indirizzo_di_residenza;

    @OneToOne(mappedBy = "idutente", cascade = CascadeType.ALL, orphanRemoval = true)
    private Utente utente;
}
