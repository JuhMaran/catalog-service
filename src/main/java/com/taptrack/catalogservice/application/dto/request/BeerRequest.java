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
  String beerName,
  BeerStyle beerStyle,
  Integer ibu,
  Double abv,
  Long breweryId,
  Boolean active
) implements Serializable {
}
