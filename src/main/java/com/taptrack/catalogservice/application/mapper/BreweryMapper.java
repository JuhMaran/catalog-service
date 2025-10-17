package com.taptrack.catalogservice.application.mapper;

import com.taptrack.catalogservice.application.dto.request.BreweryRequest;
import com.taptrack.catalogservice.application.dto.response.BreweryResponse;
import com.taptrack.catalogservice.domain.model.Brewery;
import org.mapstruct.*;

/**
 * catalog-service
 *
 * @author Juliane Maran
 * @since 17/10/2025
 */
@Mapper(componentModel = "spring")
public interface BreweryMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "version", ignore = true)
  @Mapping(target = "createdDate", ignore = true)
  @Mapping(target = "updateDate", ignore = true)
  @Mapping(target = "beers", ignore = true)
  Brewery toEntity(BreweryRequest request);

  BreweryResponse toResponse(Brewery entity);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "version", ignore = true)
  @Mapping(target = "createdDate", ignore = true)
  @Mapping(target = "updateDate", ignore = true)
  @Mapping(target = "beers", ignore = true)
  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateFromRequest(BreweryRequest request, @MappingTarget Brewery entity);


}
