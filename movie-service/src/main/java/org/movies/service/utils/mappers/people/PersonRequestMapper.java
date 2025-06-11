package org.movies.service.utils.mappers.people;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.movies.service.dtos.people.PersonRequestDto;
import org.movies.service.models.people.Person;

@Mapper(componentModel = "spring")
public interface PersonRequestMapper {

    @Mapping(target = "uuid", source = "id")
    Person toEntity(PersonRequestDto dto);

    @Mapping(target = "id", source = "uuid")
    PersonRequestDto toDto(Person entity);
}