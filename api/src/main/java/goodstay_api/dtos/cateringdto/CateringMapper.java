package goodstay_api.dtos.cateringdto;

import goodstay_api.model.Catering;

public class CateringMapper {

    private CateringMapper() {}

    public static CateringDto toDto(Catering catering) {
        if (catering == null) return null;

        CateringDto dto = new CateringDto();

        dto.setId(catering.getId());
        dto.setNhospedes(catering.getNhospedes());
        dto.setPrecohosp(catering.getPrecohosp());

        if (catering.getIdServico() != null)
            dto.setIdServico(catering.getIdServico().getId());

        if (catering.getIdiva() != null) {
            dto.setIdiva(catering.getIdiva().getId());
            dto.setIvaatual(catering.getIvaatual());
        }

        return dto;
    }

    public static Catering toEntity(CateringDto dto) {
        if (dto == null) return null;

        Catering c = new Catering();

        c.setNhospedes(dto.getNhospedes());
        c.setPrecohosp(dto.getPrecohosp());

        return c;
    }

    public static void updateEntityFromDto(CateringDto dto, Catering c) {
        if (dto == null || c == null) return;

        if (dto.getNhospedes() != null)
            c.setNhospedes(dto.getNhospedes());

        if (dto.getPrecohosp() != null)
            c.setPrecohosp(dto.getPrecohosp());
    }
}