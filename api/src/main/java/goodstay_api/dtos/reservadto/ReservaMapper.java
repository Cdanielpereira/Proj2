package goodstay_api.dtos.reservadto;

import goodstay_api.model.Reserva;

public class ReservaMapper {

    public static ReservaDto toDto(Reserva e) {
        if (e == null) return null;

        return ReservaDto.builder()
                .idMarc(e.getIdMarc() != null ? e.getIdMarc().getId() : null)
                .nquarto(e.getNquarto() != null ? e.getNquarto().getId() : null)
                .precoatual(e.getPrecoatual())
                .ivaatual(e.getIvaatual())
                .build();
    }

    public static Reserva toEntity(ReservaDto dto) {
        if (dto == null) return null;

        Reserva e = new Reserva();
        e.setPrecoatual(dto.getPrecoatual());
        e.setIvaatual(dto.getIvaatual());
        return e;
    }
}