package org.movies.service.utils.mappers.movies;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.movies.service.dtos.movies.GenreDto;
import org.movies.service.models.movies.Genre;

@Mapper(componentModel = "spring")
public interface GenreMapper {

    @Mapping(target = "uuid", source = "id")
    Genre toEntity(GenreDto dto);

    @Mapping(target = "id", source = "uuid")
    GenreDto toDto(Genre entity);
}