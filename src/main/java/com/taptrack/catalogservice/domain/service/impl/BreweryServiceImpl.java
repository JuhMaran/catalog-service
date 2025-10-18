package com.taptrack.catalogservice.domain.service.impl;

import com.taptrack.catalogservice.application.dto.request.BreweryRequest;
import com.taptrack.catalogservice.application.dto.response.BreweryResponse;
import com.taptrack.catalogservice.application.mapper.BreweryMapper;
import com.taptrack.catalogservice.domain.model.Brewery;
import com.taptrack.catalogservice.domain.repository.BreweryRepository;
import com.taptrack.catalogservice.domain.service.BreweryService;
import com.taptrack.catalogservice.exceptions.ResourceNotFoundException;
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
public class BreweryServiceImpl implements BreweryService {

  private final BreweryMapper breweryMapper;
  private final BreweryRepository breweryRepository;

  @Override
  @Transactional
  public BreweryResponse createBrewery(BreweryRequest request) {
    Brewery brewery = breweryMapper.toEntity(request);
    brewery.setCreatedDate(LocalDateTime.now());
    brewery.setUpdateDate(LocalDateTime.now());
    return breweryMapper.toResponse(breweryRepository.save(brewery));
  }

  @Override
  @Transactional
  public BreweryResponse updateBrewery(Long id, BreweryRequest request) {
    Brewery brewery = breweryRepository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("Cervejaria com ID " + id + " não encontrada"));
    breweryMapper.updateFromRequest(request, brewery);
    brewery.setUpdateDate(LocalDateTime.now());
    return breweryMapper.toResponse(breweryRepository.save(brewery));
  }

  @Override
  @Transactional
  public void deleteBrewery(Long id) {
    if (!breweryRepository.existsById(id))
      throw new ResourceNotFoundException("Cervejaria com ID " + id + " não encontrada");
    breweryRepository.deleteById(id);
  }

  @Override
  @Transactional(readOnly = true)
  public BreweryResponse findBreweryById(Long id) {
    Brewery brewery = breweryRepository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("Cervejaria com ID " + id + " não encontrada"));
    return breweryMapper.toResponse(brewery);
  }

  @Override
  @Transactional(readOnly = true)
  public List<BreweryResponse> findAllBrewery() {
    return breweryRepository.findAll()
      .stream().map(breweryMapper::toResponse).toList();
  }

  @Override
  @Transactional(readOnly = true)
  public List<BreweryResponse> findBreweryByNameContaining(String namePart) {
    return breweryRepository.findByNameContainingIgnoreCase(namePart)
      .stream().map(breweryMapper::toResponse).toList();
  }

}
