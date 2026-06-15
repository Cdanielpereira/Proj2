package goodstay_api.dtos.clientedto;

import goodstay_api.model.Cliente;

public class ClienteMapper {

    private ClienteMapper() {}

    public static ClienteDto toDto(Cliente c) {
        if (c == null) return null;

        ClienteDto dto = new ClienteDto();

        dto.setId(c.getId());
        dto.setNif(c.getNif());
        dto.setNome(c.getNome());
        dto.setDtNasc(c.getDtNasc());
        dto.setRua(c.getRua());
        dto.setPorta(c.getPorta());
        dto.setSexo(c.getSexo());
        dto.setEmail(c.getEmail());

        if (c.getIdUser() != null)
            dto.setIdUser(c.getIdUser().getId());

        if (c.getCodPostal() != null)
            dto.setCodPostal(c.getCodPostal().getCodPostal());

        if (c.getIdNacional() != null)
            dto.setIdNacional(c.getIdNacional().getId());

        return dto;
    }

    public static Cliente toEntity(ClienteDto dto) {
        if (dto == null) return null;

        Cliente c = new Cliente();

        c.setNif(dto.getNif());
        c.setNome(dto.getNome());
        c.setDtNasc(dto.getDtNasc());
        c.setRua(dto.getRua());
        c.setPorta(dto.getPorta());
        c.setSexo(dto.getSexo());
        c.setEmail(dto.getEmail());

        return c;
    }
}