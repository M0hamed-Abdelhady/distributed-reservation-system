package org.movies.service.utils.mappers.movies;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.movies.service.dtos.movies.*;
import org.movies.service.models.movies.Movie;

@Mapper(componentModel = "spring")
public interface MovieCreateMapper {

    @Mapping(target = "uuid", ignore = true)
    Movie toEntity(MovieCreateDto dto);
}