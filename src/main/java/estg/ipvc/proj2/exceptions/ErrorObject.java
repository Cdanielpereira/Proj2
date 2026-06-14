package estg.ipvc.proj2.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorObject {

    private int statusCode;
    private String message;
    private LocalDateTime timestamp;
}