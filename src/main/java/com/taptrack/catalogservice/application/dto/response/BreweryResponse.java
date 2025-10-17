package com.taptrack.catalogservice.application.dto.response;

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
public record BreweryResponse(
  Long id,
  String name,
  String city,
  String state,
  String description,
  LocalDateTime createdDate,
  LocalDateTime updateDate
) implements Serializable {
}
