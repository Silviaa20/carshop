package it.contrader.carshop.converter;
import it.contrader.carshop.dto.ConcessionarioDTO;
import it.contrader.carshop.model.Concessionario;
import it.contrader.carshop.model.Prodotto;
import it.contrader.carshop.dto.ProdottoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProdottoConverter {
@Autowired
    private ConcessionarioConverter converter;

    public ProdottoDTO toDTO (Prodotto prodotto){
       ProdottoDTO prodottoDTO = null;
       if (prodotto != null){
           prodottoDTO = new ProdottoDTO(
                   prodotto.getId(),
                   prodotto.getMarchio(),
                   prodotto.getModello(),
                   prodotto.getPrezzo(),
                   prodotto.getQuantita(),
                   prodotto.getConcessionario().getId());
       }
        return prodottoDTO;
    }
    public Prodotto toEntity(ProdottoDTO prodottoDTO) {
        Prodotto prodotto = null;
        Concessionario concessionario = new Concessionario();
        concessionario.setId(prodottoDTO.getId_concessionario());
        if (prodottoDTO != null) {
            prodotto = new Prodotto (
                    prodottoDTO.getId(),
                    prodottoDTO.getMarchio(),
                    prodottoDTO.getModello(),
                    prodottoDTO.getPrezzo(),
                    prodottoDTO.getQuantita(),
                    concessionario);


        }
        return prodotto;
    }

    public List<ProdottoDTO> toDTOList(List<Prodotto> listEntity) {
        List<ProdottoDTO> list = new ArrayList<ProdottoDTO>();

        if (listEntity != null) {
            list = listEntity.stream()
                    .map(this::toDTO)
                    .collect(Collectors.toList());
        }
        return list;
    }

    public List<Prodotto> toEntityList(List<ProdottoDTO> listDTO) {
        List<Prodotto> list = new ArrayList<>();

        if (listDTO != null) {
            list = listDTO.stream()
                    .map(this::toEntity)
                    .collect(Collectors.toList());
        }
        return list;
    }
    public Page <ProdottoDTO> toDTOpage (Page <Prodotto> prodottoPage){
        return prodottoPage.map(c -> toDTO(c));
        //mappiamo ogni elemento (c) di concessionarioPage e lo trasformiamo in tipo dto
    }
}

