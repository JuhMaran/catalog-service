package com.taptrack.catalogservice.application.dto.response;

import com.taptrack.catalogservice.domain.model.enums.BeerStyle;
import lombok.Builder;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * catalog-service
 *
 * @author Juliane Maran
 * @since 17/10/2025
 */
@Builder
public record BeerResponse(
  Long id,
  String beerName,
  BeerStyle beerStyle,
  Integer ibu,
  Double abv,
  Long breweryId,
  Boolean active,
  LocalDateTime createdDate,
  LocalDateTime updateDate
) implements Serializable {
}
