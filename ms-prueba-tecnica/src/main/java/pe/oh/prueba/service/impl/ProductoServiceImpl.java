package pe.oh.prueba.service.impl;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import pe.oh.prueba.entity.Producto;
import pe.oh.prueba.exception.ResourceNotFoundException;
import pe.oh.prueba.mapper.ProductoMapper;
import pe.oh.prueba.dto.*;
import pe.oh.prueba.repository.ProductoRepository;
import java.util.List;
import java.util.stream.Collectors;
import pe.oh.prueba.service.ProductoService;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {
	private final ProductoRepository repository;

	
	@Override
	public List<ProductoResponse> listar() {
		return repository.findAllByActivoTrue().stream().map(ProductoMapper::toResponse).collect(Collectors.toList());
	}
	@Override
	public ProductoResponse buscarPorId(Long id) {
	    return ProductoMapper.toResponse(obtenerProductoActivo(id));
	}
	
	@Override
    public ProductoResponse crear(ProductoRequest request) {
        return ProductoMapper.toResponse(repository.save(ProductoMapper.toEntity(request)));
    }
	@Override
	public ProductoResponse actualizar(Long id, ProductoRequest request) {
	    Producto producto = obtenerProductoActivo(id);
	    producto.setNombre(request.getNombre());
	    producto.setPrecio(request.getPrecio());
	    return ProductoMapper.toResponse(repository.save(producto));
	}
	@Override
    public void eliminar(Long id) {
        Producto producto = obtenerProductoActivo(id);
        producto.setActivo(false);
        repository.save(producto);
    }
	private Producto obtenerProductoActivo(Long id) {
	    return repository.findByIdAndActivoTrue(id)
	            .orElseThrow(() ->
	                    new ResourceNotFoundException("Producto no encontrado con ID: " + id));
	}
}
