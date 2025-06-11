package org.movies.service.utils.mappers.movies;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.movies.service.dtos.movies.MoviePersonDto;
import org.movies.service.models.people.Person;

@Mapper(componentModel = "spring")
public interface MoviePersonMapper {

    @Mapping(target = "uuid", source = "id")
    Person toEntity(MoviePersonDto dto);

    @Mapping(target = "id", source = "uuid")
    MoviePersonDto toDto(Person entity);
}