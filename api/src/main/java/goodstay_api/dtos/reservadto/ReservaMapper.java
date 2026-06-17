package goodstay_api.dtos.reservadto;

import goodstay_api.model.Reserva;
import goodstay_api.model.Marcacao;
import goodstay_api.model.Quarto;

public class ReservaMapper {

    private ReservaMapper() {}

    public static ReservaDto toDto(Reserva e) {
        if (e == null) return null;

        ReservaDto dto = new ReservaDto();

        dto.setIdMarc(e.getIdMarc() != null ? e.getIdMarc().getId() : null);
        dto.setNquarto(e.getNquarto() != null ? e.getNquarto().getId() : null);
        dto.setPrecoatual(e.getPrecoatual());
        dto.setIvaatual(e.getIvaatual());

        return dto;
    }

    public static Reserva toEntity(ReservaDto dto) {
        if (dto == null) return null;

        Reserva e = new Reserva();

        // NOTE: NÃO estás a mapear id próprio porque DTO não o tem
        e.setPrecoatual(dto.getPrecoatual());
        e.setIvaatual(dto.getIvaatual());

        if (dto.getIdMarc() != null) {
            Marcacao m = new Marcacao();
            m.setId(dto.getIdMarc());
            e.setIdMarc(m);
        }

        if (dto.getNquarto() != null) {
            Quarto q = new Quarto();
            q.setId(dto.getNquarto());
            e.setNquarto(q);
        }

        return e;
    }

    public static void updateEntityFromDto(ReservaDto dto, Reserva e) {
        if (dto == null || e == null) return;

        if (dto.getPrecoatual() != null) {
            e.setPrecoatual(dto.getPrecoatual());
        }

        if (dto.getIvaatual() != null) {
            e.setIvaatual(dto.getIvaatual());
        }

        if (dto.getIdMarc() != null) {
            Marcacao m = new Marcacao();
            m.setId(dto.getIdMarc());
            e.setIdMarc(m);
        }

        if (dto.getNquarto() != null) {
            Quarto q = new Quarto();
            q.setId(dto.getNquarto());
            e.setNquarto(q);
        }
    }
}