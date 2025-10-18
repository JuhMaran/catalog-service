package com.taptrack.catalogservice.domain.service;

import com.taptrack.catalogservice.application.dto.request.BeerRequest;
import com.taptrack.catalogservice.application.dto.response.BeerResponse;
import com.taptrack.catalogservice.domain.model.enums.BeerStyle;

import java.util.List;

/**
 * catalog-service
 *
 * @author Juliane Maran
 * @since 17/10/2025
 */
public interface BeerService {

  /**
   * Cadastrar Cerveja
   */
  BeerResponse createBeer(BeerRequest request);

  /**
   * Atualizar Cerveja por ID
   */
  BeerResponse updateBeer(Long id, BeerRequest request);

  /**
   * Excluir Cerveja por ID
   */
  void deleteBeer(Long id);

  /**
   * Encontrar Cerveja por ID
   */
  BeerResponse findBeerById(Long id);

  /**
   * Encontrar todas as Cervejas
   */
  List<BeerResponse> findAllBeers();

  /**
   * Encontrar Cerveja por Estilo
   */
  List<BeerResponse> findBeerByStyle(BeerStyle style);

  /**
   * Encontrar Cerveja por Cervejaria
   */
  List<BeerResponse> findBeerByBrewery(String breweryName);

  /**
   * Encontrar Cerveja por Nome que contém...
   */
  List<BeerResponse> findBeerByNameContaining(String namePart);

}
