package org.movies.service.utils.mappers.movies;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.movies.service.dtos.movies.MovieResponseDto;
import org.movies.service.models.movies.Movie;

@Mapper(componentModel = "spring")
public interface MovieResponseMapper {

    @Mapping(target = "uuid", source = "id")
    Movie toEntity(MovieResponseDto dto);

    @Mapping(target = "id", source = "uuid")
    MovieResponseDto toDto(Movie entity);
}
