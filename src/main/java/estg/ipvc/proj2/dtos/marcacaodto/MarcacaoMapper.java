package estg.ipvc.proj2.dtos.marcacaodto;

import estg.ipvc.proj2.model.Marcacao;

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

        dto.setIdEstadom(entity.getIdEstadom().getId());
        dto.setIdCliente(entity.getIdCliente().getId());

        if (entity.getIfFaturar() != null) {
            dto.setIfFaturar(entity.getIfFaturar().getId());
        }

        return dto;
    }
}