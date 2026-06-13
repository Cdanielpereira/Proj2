package estg.ipvc.proj2.dtos.encomendadto;

import estg.ipvc.proj2.model.Encomenda;

public class EncomendaMapper {

    private EncomendaMapper() {}

    public static EncomendaDto toDto(Encomenda e) {
        if (e == null) return null;

        EncomendaDto dto = new EncomendaDto();

        dto.setId(e.getId());
        dto.setValortotal(e.getValortotal());

        if (e.getIdServico() != null)
            dto.setIdServico(e.getIdServico().getId());

        return dto;
    }

    public static Encomenda toEntity(EncomendaDto dto) {
        if (dto == null) return null;

        Encomenda e = new Encomenda();

        e.setValortotal(dto.getValortotal());

        return e;
    }
}