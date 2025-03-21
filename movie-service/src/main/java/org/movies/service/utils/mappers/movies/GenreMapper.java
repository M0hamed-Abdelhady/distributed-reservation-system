package org.movies.service.utils.mappers.movies;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.movies.service.dtos.movies.GenreDto;
import org.movies.service.models.movies.Genre;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class GenreMapper {

    @Mapping(target = "id", source = "uuid")
    public abstract GenreDto toDto(Genre genre);

    @Mapping(target = "uuid", source = "id")
    public abstract Genre toEntity(GenreDto dto);
}
