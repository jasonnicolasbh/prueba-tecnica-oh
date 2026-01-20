package pe.oh.prueba.exception;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
public class ErrorResponse {
    private String codigo;
    private String mensaje;
    private int estado;
    private String path;
    private String method;
    private LocalDateTime timestamp;
    private Map<String, String> detalles;
}