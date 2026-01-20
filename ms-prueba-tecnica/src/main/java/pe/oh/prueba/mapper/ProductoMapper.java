package pe.oh.prueba.mapper;

import pe.oh.prueba.dto.ProductoRequest;
import pe.oh.prueba.dto.ProductoResponse;
import pe.oh.prueba.entity.Producto;

public class ProductoMapper {

    private ProductoMapper() {
    }

    public static ProductoResponse toResponse(Producto producto) {

        if (producto == null) {
            return null;
        }

        return ProductoResponse.builder()
                .id(producto.getId())
                .nombre(producto.getNombre())
                .precio(producto.getPrecio())
                .build();
    }

    public static Producto toEntity(ProductoRequest request) {

        if (request == null) {
            return null;
        }

        return Producto.builder()
                .nombre(request.getNombre())
                .precio(request.getPrecio())
                .activo(true)
                .build();
    }
}