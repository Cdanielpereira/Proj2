package goodstay_api.dtos.common;

import org.springframework.data.domain.Page;
import java.util.List;
import java.util.function.Function;

public class PageMapper {

    public static <E, D> PageResponse<D> toPageResponse(Page<E> page, Function<E, D> mapper) {

        List<D> content = page.getContent()
                .stream()
                .map(mapper)
                .toList();

        return PageResponse.<D>builder()
                .content(content)
                .pageNo(page.getNumber())
                .pageSize(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .last(page.isLast())
                .build();
    }
}