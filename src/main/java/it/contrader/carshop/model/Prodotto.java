package it.contrader.carshop.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table (name = "prodotto")

public class Prodotto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String marchio;
    private String modello;
    private Double prezzo;
    private Long quantita;

    @ManyToOne
    @JoinColumn (name = "id_concessionario",nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private String concessionario;


}
