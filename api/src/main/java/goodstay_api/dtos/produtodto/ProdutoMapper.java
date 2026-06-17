package goodstay_api.dtos.produtodto;

import goodstay_api.model.Produto;
import goodstay_api.model.TipoIVA;

public final class ProdutoMapper {

    private ProdutoMapper() {}

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

    public static Produto toEntity(ProdutoDto dto) {
        if (dto == null) return null;

        Produto e = new Produto();
        e.setId(dto.getId());
        e.setNome(dto.getNome());
        e.setValor(dto.getValor());
        e.setQtdstock(dto.getQtdstock());
        e.setQtdmin(dto.getQtdmin());

        if (dto.getIdIva() != null) {
            TipoIVA iva = new TipoIVA();
            iva.setId(dto.getIdIva());
            e.setIdiva(iva);
        }

        return e;
    }

    public static void updateEntityFromDto(ProdutoDto dto, Produto e) {
        if (dto == null || e == null) return;

        if (dto.getNome() != null) e.setNome(dto.getNome());
        if (dto.getValor() != null) e.setValor(dto.getValor());
        if (dto.getQtdstock() != null) e.setQtdstock(dto.getQtdstock());
        if (dto.getQtdmin() != null) e.setQtdmin(dto.getQtdmin());

        if (dto.getIdIva() != null) {
            TipoIVA iva = new TipoIVA();
            iva.setId(dto.getIdIva());
            e.setIdiva(iva);
        }
    }
}