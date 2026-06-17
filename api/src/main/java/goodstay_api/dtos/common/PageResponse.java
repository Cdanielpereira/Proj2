package goodstay_api.dtos.common;

import java.util.List;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageResponse<T> {

    private List<T> content;

    private int pageNo;
    private int pageSize;

    private long totalElements;
    private int totalPages;

    private boolean last;
}