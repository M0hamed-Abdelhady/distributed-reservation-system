package org.movies.service.utils.mappers.people;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.movies.service.dtos.people.PersonRequestDto;
import org.movies.service.dtos.people.PersonResponseDto;
import org.movies.service.models.people.Person;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class PersonMapper {

    @Mapping(target = "id", source = "uuid")
    public abstract PersonResponseDto toResponseDto(Person person);

    @Mapping(target = "uuid", source = "id")
    public abstract Person toEntity(PersonRequestDto dto);
}
