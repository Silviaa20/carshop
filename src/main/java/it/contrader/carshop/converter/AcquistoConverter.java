package it.contrader.carshop.converter;


import it.contrader.carshop.dto.AcquistoDTO;
import it.contrader.carshop.model.Acquisto;
import it.contrader.carshop.model.Concessionario;
import it.contrader.carshop.model.Prodotto;
import it.contrader.carshop.model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AcquistoConverter {

    @Autowired
    private UtenteConverter utenteConverter;

    @Autowired
    private ProdottoConverter prodottoConverter;

    public Acquisto toEntity (AcquistoDTO acquistoDTO){
        //nel DTO adesso abbiamo un Long
        Utente utente1 = new Utente();  //creiamo un oggetto di tipo utente, ovviamente ancora vuoto
        utente1.setIdutente(acquistoDTO.getId_utente()); //settiamo l'id a partire dal DTO

        Prodotto prodotto1 = new Prodotto();
        prodotto1.setId(acquistoDTO.getId_prodotto());
        return acquistoDTO != null ? Acquisto.builder()
                .id(acquistoDTO.getId())
                .data_acquisto(acquistoDTO.getData_acquisto())
                .utente(utente1)
                .prodotto(prodotto1)
                .build() : null;
    }

    public AcquistoDTO toDTO (Acquisto acquisto){
        return acquisto != null ? AcquistoDTO.builder()
                .id(acquisto.getId())
                .data_acquisto(acquisto.getData_acquisto())
                .id_utente(acquisto.getUtente().getIdutente())
                .id_prodotto(acquisto.getProdotto().getId()) //nell'entità è rimasto l'oggetto quindi così prendo solo l'id
                .build() : null;
    }


    public List<Acquisto> toListAcquisto(List<AcquistoDTO> acquistoDTOList){
        return acquistoDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    };

    public List<AcquistoDTO> toListAcquistoDTO(List<Acquisto> acquistoList){
        return acquistoList.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    };

    public Page <AcquistoDTO> toDTOpage (Page <Acquisto> acquistoPage){
        return acquistoPage.map(c -> toDTO(c));
        //mappiamo ogni elemento (c) di concessionarioPage e lo trasformiamo in tipo dto
    }

}
