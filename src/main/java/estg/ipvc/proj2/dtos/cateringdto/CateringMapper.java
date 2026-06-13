package estg.ipvc.proj2.dtos.cateringdto;

import estg.ipvc.proj2.model.Catering;

public class CateringMapper {

    private CateringMapper() {
        // utility class
    }

    /**
     * ENTITY -> DTO
     */
    public static CateringDto toDto(Catering catering) {
        if (catering == null) {
            return null;
        }

        CateringDto dto = new CateringDto();

        dto.setId(catering.getId());
        dto.setNhospedes(catering.getNhospedes());
        dto.setPrecohosp(catering.getPrecohosp());

        // FK para serviço
        if (catering.getIdServico() != null) {
            dto.setIdServico(catering.getIdServico().getId());
        }

        // IVA apenas informativo
        if (catering.getIdiva() != null) {
            dto.setIdiva(catering.getIdiva().getId());
            dto.setIvaatual(catering.getIvaatual());
        }

        return dto;
    }

    /**
     * DTO -> ENTITY (criação)
     * NOTA: não define Serviço nem IVA aqui (isso é feito no Service)
     */
    public static Catering toEntity(CateringDto dto) {
        if (dto == null) {
            return null;
        }

        Catering catering = new Catering();

        catering.setNhospedes(dto.getNhospedes());
        catering.setPrecohosp(dto.getPrecohosp());

        // NÃO setar:
        // - idServico (vem no Service)
        // - idiva (vem do sistema)
        // - ivaatual (calculado no Service)

        return catering;
    }

    /**
     * UPDATE parcial
     */
    public static void updateEntityFromDto(CateringDto dto, Catering catering) {
        if (dto == null || catering == null) {
            return;
        }

        if (dto.getNhospedes() != null) {
            catering.setNhospedes(dto.getNhospedes());
        }

        if (dto.getPrecohosp() != null) {
            catering.setPrecohosp(dto.getPrecohosp());
        }

        // NÃO atualizar:
        // - Serviço
        // - IVA
    }
}