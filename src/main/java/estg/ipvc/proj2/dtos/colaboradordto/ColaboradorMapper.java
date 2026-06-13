package estg.ipvc.proj2.dtos.colaboradordto;

import estg.ipvc.proj2.model.Colaborador;

public class ColaboradorMapper {

    private ColaboradorMapper() {}

    public static ColaboradorDto toDto(Colaborador c) {
        if (c == null) return null;

        ColaboradorDto dto = new ColaboradorDto();

        dto.setId(c.getId());
        dto.setNome(c.getNome());
        dto.setTelefone(c.getTelefone());
        dto.setEmail(c.getEmail());
        dto.setRua(c.getRua());
        dto.setNporta(c.getNporta());
        dto.setIban(c.getIban());

        if (c.getIdTipocolab() != null)
            dto.setIdTipocolab(c.getIdTipocolab().getId());

        if (c.getCodPostal() != null)
            dto.setCodPostal(c.getCodPostal().getCodPostal());

        return dto;
    }

    public static Colaborador toEntity(ColaboradorDto dto) {
        if (dto == null) return null;

        Colaborador c = new Colaborador();

        c.setNome(dto.getNome());
        c.setTelefone(dto.getTelefone());
        c.setEmail(dto.getEmail());
        c.setRua(dto.getRua());
        c.setNporta(dto.getNporta());
        c.setIban(dto.getIban());

        return c;
    }
}