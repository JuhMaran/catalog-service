package com.taptrack.catalogservice.application.dto.response;

import com.taptrack.catalogservice.domain.model.enums.GlassType;
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
public record GlassSizeResponse(
  Long id,
  GlassType name,
  Integer volumeMl,
  LocalDateTime createdDate,
  LocalDateTime updateDate
) implements Serializable {
}
