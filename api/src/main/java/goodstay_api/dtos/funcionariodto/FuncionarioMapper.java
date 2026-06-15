package goodstay_api.dtos.funcionariodto;

import goodstay_api.model.*;
import goodstay_api.model.Funcionario;

public class FuncionarioMapper {

    public static FuncionarioDto toDto(Funcionario e) {
        if (e == null) return null;

        return FuncionarioDto.builder()
                .id(e.getId())
                .idUser(e.getIdUser() != null ? e.getIdUser().getId() : null)
                .idTipofunc(e.getIdTipofunc() != null ? e.getIdTipofunc().getId() : null)
                .iban(e.getIban())
                .nif(e.getNif())
                .rua(e.getRua())
                .porta(e.getPorta())
                .dtNasc(e.getDtNasc())
                .sexo(e.getSexo())
                .nome(e.getNome())
                .email(e.getEmail())
                .codPostal(e.getCodPostal() != null ? e.getCodPostal().getCodPostal() != null ? null : null : null)
                .idNacional(e.getIdNacional() != null ? e.getIdNacional().getId() : null)
                .build();
    }

    public static Funcionario toEntity(FuncionarioDto dto) {
        if (dto == null) return null;

        Funcionario e = new Funcionario();

        e.setIban(dto.getIban());
        e.setNif(dto.getNif());
        e.setRua(dto.getRua());
        e.setPorta(dto.getPorta());
        e.setDtNasc(dto.getDtNasc());
        e.setSexo(dto.getSexo());
        e.setNome(dto.getNome());
        e.setEmail(dto.getEmail());

        return e;
    }
}