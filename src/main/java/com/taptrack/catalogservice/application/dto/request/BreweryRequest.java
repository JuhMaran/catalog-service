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
  String name,
  String city,
  String state,
  String description
) implements Serializable {
}
