package com.taptrack.catalogservice.application.dto.request;

import com.taptrack.catalogservice.domain.model.enums.BeerStyle;
import lombok.Builder;

import java.io.Serializable;

/**
 * catalog-service
 *
 * @author Juliane Maran
 * @since 17/10/2025
 */
@Builder
public record BeerRequest(

  // TODO: Validar campos

  // Mínimo 3 e máximo 150 caracteres
  // Campo obrigatório
  String beerName,

  BeerStyle beerStyle,

  // Mínimo 0 (valor default)
  Integer ibu,

  // Mínimo 0.0 (valor default)
  Double abv,
  Long breweryId,

  // Valor default = true
  Boolean active
) implements Serializable {
}
