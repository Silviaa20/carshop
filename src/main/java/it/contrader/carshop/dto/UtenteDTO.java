package it.contrader.carshop.dto;

import javax.persistence.*;

import it.contrader.carshop.model.Utente.Usertype;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class UtenteDTO {

    private Long idutente;

    private String email;

    private String password;

    private Usertype usertype;
}
