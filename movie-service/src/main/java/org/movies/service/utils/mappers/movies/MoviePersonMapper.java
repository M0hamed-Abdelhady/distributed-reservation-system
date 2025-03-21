package org.movies.service.utils.mappers.movies;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.movies.service.dtos.movies.MoviePersonDto;
import org.movies.service.models.movies.MoviePerson;
import org.movies.service.models.people.Person;
import org.movies.service.repositories.people.PersonRepository;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class MoviePersonMapper {
    protected PersonRepository personRepository;

    @Mapping(target = "id", source = "person.uuid")
    @Mapping(target = "role", expression = "java(moviePerson.getRole().name())")
    public abstract MoviePersonDto toDto(MoviePerson moviePerson);

    @Mapping(target = "person", source = "id", qualifiedByName = "personIdToPerson")
    public abstract MoviePerson toEntity(MoviePersonDto dto);

    @Named("personIdToPerson")
    public Person personIdToPerson(String personId) {
        if (personId == null) {
            return null;
        }
        return personRepository.findById(personId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid person ID: " + personId));
    }
}
