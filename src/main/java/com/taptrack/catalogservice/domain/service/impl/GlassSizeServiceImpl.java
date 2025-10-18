package com.taptrack.catalogservice.domain.service.impl;

import com.taptrack.catalogservice.application.dto.request.GlassSizeRequest;
import com.taptrack.catalogservice.application.dto.response.GlassSizeResponse;
import com.taptrack.catalogservice.application.mapper.GlassSizeMapper;
import com.taptrack.catalogservice.domain.model.GlassSize;
import com.taptrack.catalogservice.domain.model.enums.GlassType;
import com.taptrack.catalogservice.domain.repository.GlassSizeRepository;
import com.taptrack.catalogservice.domain.service.GlassSizeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * catalog-service
 *
 * @author Juliane Maran
 * @since 17/10/2025
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class GlassSizeServiceImpl implements GlassSizeService {

  private final GlassSizeMapper glassSizeMapper;
  private final GlassSizeRepository glassSizeRepository;

  @Override
  @Transactional
  public GlassSizeResponse createGlassSize(GlassSizeRequest request) {
    GlassSize glass = glassSizeMapper.toEntity(request);
    glass.setCreatedDate(LocalDateTime.now());
    glass.setUpdateDate(LocalDateTime.now());
    return glassSizeMapper.toResponse(glassSizeRepository.save(glass));
  }

  @Override
  @Transactional
  public GlassSizeResponse updateGlassSize(Long id, GlassSizeRequest request) {
    GlassSize glass = glassSizeRepository.findById(id)
      .orElseThrow(() -> new IllegalArgumentException("Glass size not found with ID: " + id));
    glassSizeMapper.updateFromRequest(request, glass);
    glass.setUpdateDate(LocalDateTime.now());
    return glassSizeMapper.toResponse(glassSizeRepository.save(glass));
  }

  @Override
  @Transactional
  public void delete(Long id) {
    if (!glassSizeRepository.existsById(id)) {
      throw new IllegalArgumentException("Glass size not found with ID: " + id);
    }
    glassSizeRepository.deleteById(id);
  }

  @Override
  @Transactional(readOnly = true)
  public GlassSizeResponse findGlassSizeById(Long id) {
    return glassSizeRepository.findById(id)
      .map(glassSizeMapper::toResponse)
      .orElseThrow(() -> new IllegalArgumentException("Glass size not found with ID: " + id));
  }

  @Override
  @Transactional(readOnly = true)
  public List<GlassSizeResponse> findAllGlassSize() {
    return glassSizeRepository.findAll()
      .stream().map(glassSizeMapper::toResponse).toList();
  }

  @Override
  @Transactional(readOnly = true)
  public GlassSizeResponse findGlassSizeByType(GlassType type) {
    GlassSize glass = glassSizeRepository.findByName(type)
      .orElseThrow(() -> new IllegalArgumentException("Glass size not found with type: " + type));
    return glassSizeMapper.toResponse(glass);
  }

}