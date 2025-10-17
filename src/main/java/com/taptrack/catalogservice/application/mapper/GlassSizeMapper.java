package com.taptrack.catalogservice.application.mapper;

import com.taptrack.catalogservice.application.dto.request.GlassSizeRequest;
import com.taptrack.catalogservice.application.dto.response.GlassSizeResponse;
import com.taptrack.catalogservice.domain.model.GlassSize;
import org.mapstruct.*;

/**
 * catalog-service
 *
 * @author Juliane Maran
 * @since 17/10/2025
 */
@Mapper(componentModel = "spring")
public interface GlassSizeMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "version", ignore = true)
  @Mapping(target = "createdDate", ignore = true)
  @Mapping(target = "updateDate", ignore = true)
  GlassSize toEntity(GlassSizeRequest request);

  GlassSizeResponse toResponse(GlassSize entity);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "version", ignore = true)
  @Mapping(target = "createdDate", ignore = true)
  @Mapping(target = "updateDate", ignore = true)
  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateFromRequest(GlassSizeRequest request, @MappingTarget GlassSize entity);

}
