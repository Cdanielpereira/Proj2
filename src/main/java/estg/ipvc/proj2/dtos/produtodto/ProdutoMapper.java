package estg.ipvc.proj2.dtos.produtodto;

import estg.ipvc.proj2.model.*;

public class ProdutoMapper {

    private ProdutoMapper() {}

    /**
     * ENTITY -> DTO
     */
    public static ProdutoDto toDto(Produto e) {
        if (e == null) return null;

        return ProdutoDto.builder()
                .id(e.getId())
                .nome(e.getNome())
                .valor(e.getValor())
                .qtdstock(e.getQtdstock())
                .qtdmin(e.getQtdmin())
                .idIva(e.getIdiva() != null ? e.getIdiva().getId() : null)
                .build();
    }

    /**
     * DTO -> ENTITY
     */
    public static Produto toEntity(ProdutoDto dto) {
        if (dto == null) return null;

        Produto e = new Produto();

        e.setNome(dto.getNome());
        e.setValor(dto.getValor());
        e.setQtdstock(dto.getQtdstock());
        e.setQtdmin(dto.getQtdmin());

        // FK (apenas ID placeholder — resolver no Service)
        if (dto.getIdIva() != null) {
            TipoIVA iva = new TipoIVA();
            iva.setId(dto.getIdIva());
            e.setIdiva(iva);
        }

        return e;
    }

    /**
     * UPDATE parcial
     */
    public static void updateEntityFromDto(ProdutoDto dto, Produto e) {
        if (dto == null || e == null) return;

        if (dto.getNome() != null) e.setNome(dto.getNome());
        if (dto.getValor() != null) e.setValor(dto.getValor());
        if (dto.getQtdstock() != null) e.setQtdstock(dto.getQtdstock());
        if (dto.getQtdmin() != null) e.setQtdmin(dto.getQtdmin());
        // IVA normalmente não se altera aqui
    }
}