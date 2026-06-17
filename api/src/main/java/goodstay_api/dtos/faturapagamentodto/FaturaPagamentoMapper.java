package goodstay_api.dtos.faturapagamentodto;

import goodstay_api.model.*;

public class FaturaPagamentoMapper {

    public static FaturaPagamentoDto toDto(FaturaPagamento e) {
        if (e == null) return null;

        return FaturaPagamentoDto.builder()
                .id(e.getId())
                .iban(e.getIban())
                .valorpago(e.getValorpago())
                .dtPag(e.getDtPag())
                .idFunc(e.getIdFunc() != null ? e.getIdFunc().getId() : null)
                .idMetodo(e.getIdMetodo() != null ? e.getIdMetodo().getId() : null)
                .build();
    }

    public static FaturaPagamento toEntity(FaturaPagamentoDto dto) {
        if (dto == null) return null;

        FaturaPagamento e = new FaturaPagamento();

        e.setId(dto.getId());
        e.setIban(dto.getIban());
        e.setValorpago(dto.getValorpago());
        e.setDtPag(dto.getDtPag());

        if (dto.getIdFunc() != null) {
            Funcionario f = new Funcionario();
            f.setId(dto.getIdFunc());
            e.setIdFunc(f);
        }

        if (dto.getIdMetodo() != null) {
            MetodoPagamento m = new MetodoPagamento();
            m.setId(dto.getIdMetodo());
            e.setIdMetodo(m);
        }

        return e;
    }
}