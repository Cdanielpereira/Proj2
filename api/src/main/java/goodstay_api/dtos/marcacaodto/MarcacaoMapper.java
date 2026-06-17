package goodstay_api.dtos.marcacaodto;

import goodstay_api.model.*;

public class MarcacaoMapper {

    public static MarcacaoDto toDto(Marcacao entity) {
        if (entity == null) return null;

        MarcacaoDto dto = new MarcacaoDto();

        dto.setId(entity.getId());
        dto.setDtMarc(entity.getDtMarc());
        dto.setDtFim(entity.getDtFim());
        dto.setDtCheckin(entity.getDtCheckin());
        dto.setDtCheckout(entity.getDtCheckout());
        dto.setValort(entity.getValort());

        dto.setIdEstadom(entity.getIdEstadom() != null ? entity.getIdEstadom().getId() : null);
        dto.setIdCliente(entity.getIdCliente() != null ? entity.getIdCliente().getId() : null);

        if (entity.getIfFaturar() != null) {
            dto.setIfFaturar(entity.getIfFaturar().getId());
        }

        return dto;
    }

    public static Marcacao toEntity(MarcacaoDto dto) {
        if (dto == null) return null;

        Marcacao entity = new Marcacao();

        entity.setId(dto.getId());
        entity.setDtMarc(dto.getDtMarc());
        entity.setDtFim(dto.getDtFim());
        entity.setDtCheckin(dto.getDtCheckin());
        entity.setDtCheckout(dto.getDtCheckout());
        entity.setValort(dto.getValort());

        if (dto.getIdEstadom() != null) {
            EstadoMarcacao em = new EstadoMarcacao();
            em.setId(dto.getIdEstadom());
            entity.setIdEstadom(em);
        }

        if (dto.getIdCliente() != null) {
            Cliente c = new Cliente();
            c.setId(dto.getIdCliente());
            entity.setIdCliente(c);
        }

        if (dto.getIfFaturar() != null) {
            FaturaRecibo fr = new FaturaRecibo();
            fr.setId(dto.getIfFaturar());
            entity.setIfFaturar(fr);
        }

        return entity;
    }
}