package com.taptrack.catalogservice.domain.repository;

import com.taptrack.catalogservice.domain.model.Brewery;
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
public interface BreweryRepository extends JpaRepository<Brewery, Long> {

  // Buscar cervejaria pelo nome exato
  Optional<Brewery> findByName(String name);

  // Buscar cervejarias pelo nome contendo parte do texto (case insensitive)
  Optional<Brewery> findByNameContainingIgnoreCase(String namePart);

}
