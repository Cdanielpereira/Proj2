package goodstay_api.dtos.quartodto;

import goodstay_api.model.*;

public class QuartoMapper {

    private QuartoMapper() {}

    public static QuartoDto toDto(Quarto e) {
        if (e == null) return null;

        return QuartoDto.builder()
                .id(e.getId())
                .preco(e.getPreco())
                .idZona(e.getIdZona() != null ? e.getIdZona().getId() : null)
                .idTipoq(e.getIdTipoq() != null ? e.getIdTipoq().getId() : null)
                .idTipoIVA(e.getIdiva() != null ? e.getIdiva().getId() : null)
                .build();
    }

    public static Quarto toEntity(QuartoDto dto) {
        if (dto == null) return null;

        Quarto e = new Quarto();
        e.setId(dto.getId());
        e.setPreco(dto.getPreco());

        if (dto.getIdZona() != null) {
            Zona z = new Zona();
            z.setId(dto.getIdZona());
            e.setIdZona(z);
        }

        if (dto.getIdTipoq() != null) {
            TipoQuarto t = new TipoQuarto();
            t.setId(dto.getIdTipoq());
            e.setIdTipoq(t);
        }

        if (dto.getIdTipoIVA() != null) {
            TipoIVA iva = new TipoIVA();
            iva.setId(dto.getIdTipoIVA());
            e.setIdiva(iva);
        }

        return e;
    }

    public static void updateEntityFromDto(QuartoDto dto, Quarto e) {
        if (dto == null || e == null) return;

        if (dto.getPreco() != null) e.setPreco(dto.getPreco());

        if (dto.getIdZona() != null) {
            Zona z = new Zona();
            z.setId(dto.getIdZona());
            e.setIdZona(z);
        }

        if (dto.getIdTipoq() != null) {
            TipoQuarto t = new TipoQuarto();
            t.setId(dto.getIdTipoq());
            e.setIdTipoq(t);
        }

        if (dto.getIdTipoIVA() != null) {
            TipoIVA iva = new TipoIVA();
            iva.setId(dto.getIdTipoIVA());
            e.setIdiva(iva);
        }
    }
}