package com.taptrack.catalogservice.application.mapper;

import com.taptrack.catalogservice.application.dto.request.BeerRequest;
import com.taptrack.catalogservice.application.dto.response.BeerResponse;
import com.taptrack.catalogservice.domain.model.Beer;
import org.mapstruct.*;

/**
 * catalog-service
 *
 * @author Juliane Maran
 * @since 17/10/2025
 */
@Mapper(componentModel = "spring")
public interface BeerMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "version", ignore = true)
  @Mapping(target = "createdDate", ignore = true)
  @Mapping(target = "updateDate", ignore = true)
  @Mapping(target = "brewery", source = "breweryId")
  Beer toEntity(BeerRequest request);

  @Mapping(target = "breweryId", source = "brewery")
  BeerResponse toResponse(Beer entity);


  @Mapping(target = "id", ignore = true)
  @Mapping(target = "version", ignore = true)
  @Mapping(target = "createdDate", ignore = true)
  @Mapping(target = "updateDate", ignore = true)
  @Mapping(target = "brewery", source = "breweryId")
  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateFromRequest(BeerRequest request, @MappingTarget Beer entity);

}
