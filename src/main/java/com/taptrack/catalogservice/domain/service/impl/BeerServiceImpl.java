package com.taptrack.catalogservice.domain.service.impl;

import com.taptrack.catalogservice.application.dto.request.BeerRequest;
import com.taptrack.catalogservice.application.dto.response.BeerResponse;
import com.taptrack.catalogservice.application.mapper.BeerMapper;
import com.taptrack.catalogservice.domain.model.Beer;
import com.taptrack.catalogservice.domain.model.Brewery;
import com.taptrack.catalogservice.domain.model.enums.BeerStyle;
import com.taptrack.catalogservice.domain.repository.BeerRepository;
import com.taptrack.catalogservice.domain.repository.BreweryRepository;
import com.taptrack.catalogservice.domain.service.BeerService;
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
public class BeerServiceImpl implements BeerService {

  private final BeerMapper beerMapper;
  private final BeerRepository beerRepository;
  private final BreweryRepository breweryRepository;

  @Override
  @Transactional
  public BeerResponse createBeer(BeerRequest request) {
    Brewery brewery = breweryRepository.findById(request.breweryId())
      .orElseThrow(() -> new ResourceNotFoundException("Cervejaria com ID " + request.breweryId() + " não encontrada"));

    Beer beer = beerMapper.toEntity(request);
    beer.setBrewery(brewery);
    beer.setCreatedDate(LocalDateTime.now());
    beer.setUpdateDate(LocalDateTime.now());

    Beer beerSaved = beerRepository.save(beer);
    return beerMapper.toResponse(beerSaved);
  }

  @Override
  @Transactional
  public BeerResponse updateBeer(Long id, BeerRequest request) {

    Beer beer = beerRepository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("Cerveja com ID " + id + " não encontrada"));

    beerMapper.updateFromRequest(request, beer);
    beer.setUpdateDate(LocalDateTime.now());

    if (request.breweryId() != null) {
      Brewery brewery = breweryRepository.findById(request.breweryId())
        .orElseThrow(() -> new ResourceNotFoundException("Cervejaria com ID " + request.breweryId() + " não encontrada"));
      beer.setBrewery(brewery);
    }

    return beerMapper.toResponse(beerRepository.save(beer));
  }

  @Override
  @Transactional
  public void deleteBeer(Long id) {
    if (!beerRepository.existsById(id))
      throw new ResourceNotFoundException("Cerveja com ID " + id + " não encontrada");
    beerRepository.deleteById(id);
  }

  @Override
  @Transactional(readOnly = true)
  public BeerResponse findBeerById(Long id) {
    Beer beer = beerRepository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("Cerveja com ID " + id + " não encontrada"));
    return beerMapper.toResponse(beer);
  }

  @Override
  @Transactional(readOnly = true)
  public List<BeerResponse> findAllBeers() {
    return beerRepository.findAll()
      .stream().map(beerMapper::toResponse).toList();
  }

  @Override
  @Transactional(readOnly = true)
  public List<BeerResponse> findBeerByStyle(BeerStyle style) {
    return beerRepository.findByBeerStyle(style)
      .stream().map(beerMapper::toResponse).toList();
  }

  @Override
  @Transactional(readOnly = true)
  public List<BeerResponse> findBeerByBrewery(String breweryName) {
    return beerRepository.findByBrewery_Name(breweryName)
      .stream().map(beerMapper::toResponse).toList();
  }

  @Override
  @Transactional(readOnly = true)
  public List<BeerResponse> findBeerByNameContaining(String namePart) {
    return beerRepository.findByBeerNameContainingIgnoreCase(namePart)
      .stream().map(beerMapper::toResponse).toList();
  }

}
