package estg.ipvc.proj2.dtos.nacionalidadedto;

import estg.ipvc.proj2.model.Nacionalidade;

public class NacionalidadeMapper {

    public static NacionalidadeDto toDto(Nacionalidade e) {
        if (e == null) return null;

        return NacionalidadeDto.builder()
                .id(e.getId())
                .state(e.getNacionalidade())
                .build();
    }

    public static Nacionalidade toEntity(NacionalidadeDto dto) {
        if (dto == null) return null;

        Nacionalidade e = new Nacionalidade();
        e.setNacionalidade(dto.getState());
        return e;
    }
}