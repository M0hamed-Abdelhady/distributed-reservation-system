package org.movies.service.utils.mappers.movies;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.movies.service.dtos.movies.MovieCreateDto;
import org.movies.service.dtos.movies.MovieResponseDto;
import org.movies.service.dtos.movies.MovieUpdateDot;
import org.movies.service.models.movies.Movie;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {GenreMapper.class, MoviePersonMapper.class})
public abstract class MovieMapper {

    public abstract Movie toEntity(MovieCreateDto dto);

    public abstract Movie toEntity(MovieUpdateDot dto);

    @Mapping(target = "id", source = "uuid")
    public abstract MovieResponseDto toResponseDto(Movie movie);
}
