package it.contrader.carshop.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Acquisto {

    @Id
    private Long id;

    private Date data_acquisto;


    @ManyToOne
    @JoinColumn(name = "id_utente", nullable = true)
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "id_prodotto", nullable = true)
    private Prodotto prodotto;



}
