package it.contrader.carshop.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder

public class Utente {

    public enum Usertype {
        ADMIN,
        USER
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idutente;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private Usertype usertype;
}
