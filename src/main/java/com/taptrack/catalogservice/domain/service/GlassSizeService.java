package com.taptrack.catalogservice.domain.service;

import com.taptrack.catalogservice.application.dto.request.GlassSizeRequest;
import com.taptrack.catalogservice.application.dto.response.GlassSizeResponse;
import com.taptrack.catalogservice.domain.model.enums.GlassType;

import java.util.List;

/**
 * catalog-service
 *
 * @author Juliane Maran
 * @since 17/10/2025
 */
public interface GlassSizeService {

  GlassSizeResponse createGlassSize(GlassSizeRequest request);

  GlassSizeResponse updateGlassSize(Long id, GlassSizeRequest request);

  void delete(Long id);

  GlassSizeResponse findGlassSizeById(Long id);

  List<GlassSizeResponse> findAllGlassSize();

  GlassSizeResponse findGlassSizeByType(GlassType type);

}
