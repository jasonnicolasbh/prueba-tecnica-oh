package pe.oh.prueba.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ProductoRequest {
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    
    @Positive(message = "El precio debe ser mayor a 0")
    private Double precio;
}