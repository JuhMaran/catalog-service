package com.taptrack.catalogservice.domain.repository;

import com.taptrack.catalogservice.domain.model.GlassSize;
import com.taptrack.catalogservice.domain.model.enums.GlassType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * catalog-service
 *
 * @author Juliane Maran
 * @since 17/10/2025
 */
@Repository
public interface GlassSizeRepository extends JpaRepository<GlassSize, Long> {

  // Buscar glass size pelo tipo (HALF, PINT, GROWLER)
  Optional<GlassSize> findByName(GlassType name);

}
