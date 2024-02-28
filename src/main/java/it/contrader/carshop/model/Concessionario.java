package it.contrader.carshop.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Concessionario {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

private String nome;
private String indirizzo;
private String citta;


    @ManyToOne
    @JoinColumn(name = "id_admin", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Utente utente;
}

