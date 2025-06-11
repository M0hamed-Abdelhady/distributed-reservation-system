package org.movies.service.utils.mappers.people;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.movies.service.dtos.people.PersonResponseDto;
import org.movies.service.models.people.Person;

@Mapper(componentModel = "spring")
public interface PersonResponseMapper {

    @Mapping(target = "uuid", source = "id")
    Person toEntity(PersonResponseDto dto);

    @Mapping(target = "id", source = "uuid")
    PersonResponseDto toDto(Person entity);
}