package it.contrader.carshop.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Acquisto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data_acquisto;


    @ManyToOne
    @JoinColumn(name = "id_utente", nullable = true)
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "id_prodotto", nullable = true)
    private Prodotto prodotto;



}
