package estg.ipvc.proj2.dtos.contratodto;

import estg.ipvc.proj2.model.Contrato;

public class ContratoMapper {

    private ContratoMapper() {}

    public static ContratoDto toDto(Contrato c) {
        if (c == null) return null;

        ContratoDto dto = new ContratoDto();

        dto.setId(c.getId());
        dto.setSalario(c.getSalario());
        dto.setDtCriado(c.getDtCriado());
        dto.setDtAssinado(c.getDtAssinado());
        dto.setDtIni(c.getDtIni());
        dto.setDtFim(c.getDtFim());

        if (c.getIdFunc() != null)
            dto.setIdFunc(c.getIdFunc().getId());

        if (c.getIdEstadoc() != null)
            dto.setIdEstadoc(c.getIdEstadoc().getId());

        return dto;
    }

    public static Contrato toEntity(ContratoDto dto) {
        if (dto == null) return null;

        Contrato c = new Contrato();

        c.setSalario(dto.getSalario());
        c.setDtCriado(dto.getDtCriado());
        c.setDtAssinado(dto.getDtAssinado());
        c.setDtIni(dto.getDtIni());
        c.setDtFim(dto.getDtFim());

        return c;
    }
}