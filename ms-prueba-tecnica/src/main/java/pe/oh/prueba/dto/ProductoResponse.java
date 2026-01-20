package pe.oh.prueba.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductoResponse {
    private Long id;
    private String nombre;
    private Double precio;
}