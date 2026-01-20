package pe.oh.prueba.repository;

import pe.oh.prueba.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
	List<Producto> findAllByActivoTrue();
	Optional<Producto> findByIdAndActivoTrue(Long id);
}