package co.edu.iudigital.app.infrastructure.persistence.jpa.repository;

import co.edu.iudigital.app.infrastructure.persistence.jpa.entity.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorJpaRepository
        extends JpaRepository<ProveedorEntity, Long> {
}
