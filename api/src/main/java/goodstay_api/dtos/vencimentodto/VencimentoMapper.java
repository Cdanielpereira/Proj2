package goodstay_api.dtos.vencimentodto;

import goodstay_api.model.Vencimento;
import goodstay_api.model.Contrato;
import goodstay_api.model.MetodoPagamento;

public class VencimentoMapper {

    public static VencimentoDto toDto(Vencimento e) {
        if (e == null) return null;

        return VencimentoDto.builder()
                .id(e.getId())
                .valor(e.getValor())
                .dtPag(e.getDtPag())
                .mes(e.getMes())
                .premio(e.getPremio())
                .iban(e.getIban())
                .idContrato(e.getIdContrato() != null ? e.getIdContrato().getId() : null)
                .idMetodo(e.getIdMetodo() != null ? e.getIdMetodo().getId() : null)
                .build();
    }

    public static Vencimento toEntity(VencimentoDto dto) {
        if (dto == null) return null;

        Vencimento e = new Vencimento();

        e.setId(dto.getId());
        e.setValor(dto.getValor());
        e.setDtPag(dto.getDtPag());
        e.setMes(dto.getMes());
        e.setPremio(dto.getPremio());
        e.setIban(dto.getIban());

        if (dto.getIdContrato() != null) {
            Contrato contrato = new Contrato();
            contrato.setId(dto.getIdContrato());
            e.setIdContrato(contrato);
        }

        if (dto.getIdMetodo() != null) {
            MetodoPagamento metodo = new MetodoPagamento();
            metodo.setId(dto.getIdMetodo());
            e.setIdMetodo(metodo);
        }

        return e;
    }
}