package it.contrader.carshop.converter;
import it.contrader.carshop.model.Prodotto;
import it.contrader.carshop.dto.ProdottoDTO;

import org.modelmapper.ModelMapper;
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
    protected Class<ProdottoDTO> getDTOClass() {
        return ProdottoDTO.class;
    }
@Autowired
private final ModelMapper modelMapper = new ModelMapper();


    public ProdottoDTO toDTO (Prodotto prodotto){
       ProdottoDTO prodottoDTO = null;
       if (prodotto != null){
           prodottoDTO = new ProdottoDTO(
                   prodotto.getId(),
                   prodotto.getMarchio(),
                   prodotto.getModello(),
                   prodotto.getPrezzo(),
                   prodotto.getQuantita(),
                   converter.toDTO(prodotto.getConcessionario()));
       }
        return prodottoDTO;
    }
    public Prodotto toEntity(ProdottoDTO prodottoDTO) {
        Prodotto prodotto = null;
        if (prodottoDTO != null) {
            prodotto = new Prodotto (
                    prodottoDTO.getId(),
                    prodottoDTO.getMarchio(),
                    prodottoDTO.getModello(),
                    prodottoDTO.getPrezzo(),
                    prodottoDTO.getQuantita(),
                    converter.toEntity(prodottoDTO.getConcessionario()));


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

    public static Page<ProdottoDTO> convertToPage(List<ProdottoDTO> list, Pageable pageable) {
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), list.size());

        List<ProdottoDTO> subList = start >= end ? new ArrayList<>() : list.subList(start, end);
        return new PageImpl<>(subList, pageable, list.size());
    }

    public Page<ProdottoDTO> convertToDTOPage(Page<Prodotto> page) {
        return page.map(entity -> modelMapper.map(entity, getDTOClass()));
    }



}

