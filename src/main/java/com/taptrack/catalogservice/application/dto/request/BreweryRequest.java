package com.taptrack.catalogservice.application.dto.request;

import lombok.Builder;

import java.io.Serializable;

/**
 * catalog-service
 *
 * @author Juliane Maran
 * @since 17/10/2025
 */
@Builder
public record BreweryRequest(

  // TODO: Validar campos

  // Mínimo 3 e máximo 150 caracteres
  // Campo obrigatório
  String name,
  String city,
  String state,
  String description
) implements Serializable {
}
