package org.movies.service.utils.mappers.movies;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.movies.service.dtos.movies.MovieUpdateDto;
import org.movies.service.models.movies.Movie;

@Mapper(componentModel = "spring")
public interface MovieUpdateMapper {

    @Mapping(target = "uuid", source = "id")
    Movie toEntity(MovieUpdateDto dto);

    @Mapping(target = "id", source = "uuid")
    MovieUpdateDto toDto(Movie entity);
}
