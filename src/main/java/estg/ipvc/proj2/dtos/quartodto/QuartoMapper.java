package estg.ipvc.proj2.dtos.quartodto;

import estg.ipvc.proj2.model.*;

public class QuartoMapper {

    private QuartoMapper() {}

    // ENTITY -> DTO
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

    // DTO -> ENTITY (CREATE)
    public static Quarto toEntity(QuartoDto dto) {
        if (dto == null) return null;

        Quarto e = new Quarto();
        e.setPreco(dto.getPreco());

        if (dto.getIdZona() != null) {
            Zona z = new Zona();
            z.setId(dto.getIdZona());
            e.setIdZona(z);
        }

        if (dto.getIdTipoq() != null) {
            TipoQuarto tq = new TipoQuarto();
            tq.setId(dto.getIdTipoq());
            e.setIdTipoq(tq);
        }

        if (dto.getIdTipoIVA() != null) {
            TipoIVA iva = new TipoIVA();
            iva.setId(dto.getIdTipoIVA());
            e.setIdiva(iva);
        }

        return e;
    }

    // UPDATE parcial (agora consistente)
    public static void updateEntityFromDto(QuartoDto dto, Quarto e) {
        if (dto == null || e == null) return;

        if (dto.getPreco() != null) {
            e.setPreco(dto.getPreco());
        }

        if (dto.getIdZona() != null) {
            Zona z = new Zona();
            z.setId(dto.getIdZona());
            e.setIdZona(z);
        }

        if (dto.getIdTipoq() != null) {
            TipoQuarto tq = new TipoQuarto();
            tq.setId(dto.getIdTipoq());
            e.setIdTipoq(tq);
        }

        if (dto.getIdTipoIVA() != null) {
            TipoIVA iva = new TipoIVA();
            iva.setId(dto.getIdTipoIVA());
            e.setIdiva(iva);
        }
    }
}