package pe.oh.prueba.service;

import pe.oh.prueba.dto.*;
import java.util.List;

public interface ProductoService {
    List<ProductoResponse> listar();
    ProductoResponse buscarPorId(Long id);
    ProductoResponse crear(ProductoRequest request);
    ProductoResponse actualizar(Long id, ProductoRequest request);
    void eliminar(Long id);
}
