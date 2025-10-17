package com.taptrack.catalogservice.domain.repository;

import com.taptrack.catalogservice.domain.model.Beer;
import com.taptrack.catalogservice.domain.model.enums.BeerStyle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * catalog-service
 *
 * @author Juliane Maran
 * @since 17/10/2025
 */
@Repository
public interface BeerRepository extends JpaRepository<Beer, Long> {

  // Buscar cerveja pleo nome exato
  Optional<Beer> findByBeerName(String beerName);

  // Buscar cervejas pelo nome contendo parte do texto (case insensitive)
  List<Beer> findByBeerNameContainingIgnoreCase(String beerNamePart);

  // Buscar todas as cervejas de um determinado estilo
  List<Beer> findByBeerStyle(BeerStyle beerStyle);

  // Buscar todas as cervejas ativas
  List<Beer> findByActiveTrue();

  // Buscar cervejas de uma cervejaria específica
  List<Beer> findByBrewery_Name(String breweryName);

}
