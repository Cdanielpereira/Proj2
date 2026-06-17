package goodstay_api.dtos.servicodto;

import goodstay_api.model.*;

public class ServicoMapper {

    public static ServicoDto toDto(Servico e) {
        if (e == null) return null;

        return ServicoDto.builder()
                .id(e.getId())
                .valorpagar(e.getValorpagar())
                .dtMarc(e.getDtMarc())
                .dtRea(e.getDtRea())
                .idEstadoser(e.getIdEstadoser() != null ? e.getIdEstadoser().getId() : null)
                .idColab(e.getIdColab() != null ? e.getIdColab().getId() : null)
                .idFunc(e.getIdFunc() != null ? e.getIdFunc().getId() : null)
                .idFaturap(e.getIdFaturap())
                .build();
    }

    public static Servico toEntity(ServicoDto dto) {
        if (dto == null) return null;

        Servico e = new Servico();

        e.setId(dto.getId());
        e.setValorpagar(dto.getValorpagar());
        e.setDtMarc(dto.getDtMarc());
        e.setDtRea(dto.getDtRea());

        if (dto.getIdEstadoser() != null) {
            EstadoServico es = new EstadoServico();
            es.setId(dto.getIdEstadoser());
            e.setIdEstadoser(es);
        }

        if (dto.getIdColab() != null) {
            Colaborador c = new Colaborador();
            c.setId(dto.getIdColab());
            e.setIdColab(c);
        }

        if (dto.getIdFunc() != null) {
            Funcionario f = new Funcionario();
            f.setId(dto.getIdFunc());
            e.setIdFunc(f);
        }

        // FK como Integer (correto)
        e.setIdFaturap(dto.getIdFaturap());

        return e;
    }
}