package it.contrader.carshop.converter;


import it.contrader.carshop.dto.AcquistoDTO;
import it.contrader.carshop.model.Acquisto;
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
        return acquistoDTO != null ? Acquisto.builder()
                .id(acquistoDTO.getId())
                .data_acquisto(acquistoDTO.getData_acquisto())
                .utente(utenteConverter.toEntity(acquistoDTO.getUtente()))
                .prodotto(prodottoConverter.toEntity(acquistoDTO.getProdotto()))
                .build() : null;
    }

    public AcquistoDTO toDTO (Acquisto acquisto){
        return acquisto != null ? AcquistoDTO.builder()
                .id(acquisto.getId())
                .data_acquisto(acquisto.getData_acquisto())
                .utente(utenteConverter.toDTO(acquisto.getUtente()))
                .prodotto(prodottoConverter.toDTO(acquisto.getProdotto()))
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

    public Page<AcquistoDTO> convertToPage(List<AcquistoDTO> acquisti, Pageable pageable) {
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), acquisti.size());

        return new PageImpl<>(acquisti.subList(start, end), pageable, acquisti.size());
    }
}
