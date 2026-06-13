package estg.ipvc.proj2.dtos.faturarecibodto;

import estg.ipvc.proj2.model.FaturaRecibo;
import estg.ipvc.proj2.model.MetodoPagamento;

public class FaturaReciboMapper {

    public static FaturaReciboDto toDto(FaturaRecibo e) {
        if (e == null) return null;

        return FaturaReciboDto.builder()
                .id(e.getId())
                .valor(e.getValor())
                .dtPagamento(e.getDtPagamento())
                .nif(e.getNif())
                .idMetodo(e.getIdMetodo() != null ? e.getIdMetodo().getId() : null)
                .build();
    }

    public static FaturaRecibo toEntity(FaturaReciboDto dto) {
        if (dto == null) return null;

        FaturaRecibo e = new FaturaRecibo();
        e.setValor(dto.getValor());
        e.setDtPagamento(dto.getDtPagamento());
        e.setNif(dto.getNif());
        return e;
    }
}