package co.edu.iudigital.app.infrastructure.persistence.jpa.repository;

import co.edu.iudigital.app.infrastructure.persistence.jpa.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoJpaRepository
        extends JpaRepository<ProductoEntity, Long> {
}
