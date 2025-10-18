package com.taptrack.catalogservice.application.dto.request;

import com.taptrack.catalogservice.domain.model.enums.GlassType;
import lombok.Builder;

import java.io.Serializable;

/**
 * catalog-service
 *
 * @author Juliane Maran
 * @since 17/10/2025
 */
@Builder
public record GlassSizeRequest(

  // TODO: Validar campos

  GlassType name,

  // Mínimo 0 (valor default)
  Integer volumeMl
) implements Serializable {
}
