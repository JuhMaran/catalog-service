package com.taptrack.catalogservice.domain.service;

import com.taptrack.catalogservice.application.dto.request.BreweryRequest;
import com.taptrack.catalogservice.application.dto.response.BreweryResponse;

import java.util.List;

/**
 * catalog-service
 *
 * @author Juliane Maran
 * @since 17/10/2025
 */
public interface BreweryService {

  /**
   * Cadastrar Cervejaria
   */
  BreweryResponse createBrewery(BreweryRequest request);

  /**
   * Atualizar Cervejaria por ID
   */
  BreweryResponse updateBrewery(Long id, BreweryRequest request);

  /**
   * Excluir Cervejaria por ID
   */
  void deleteBrewery(Long id);

  /**
   * Encontrar Cervejaria por ID
   */
  BreweryResponse findBreweryById(Long id);

  /**
   * Encontrar todas as Cervejarias
   */
  List<BreweryResponse> findAllBrewery();

  /**
   * Encontrar Cervejaria por Nome que contém...
   */
  List<BreweryResponse> findBreweryByNameContaining(String namePart);

}
