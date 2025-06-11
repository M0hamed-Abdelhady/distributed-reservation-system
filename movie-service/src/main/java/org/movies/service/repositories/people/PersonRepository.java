package org.movies.service.repositories.people;


import org.movies.service.models.people.Person;
import org.movies.service.repositories.AbstractEntityRepository;

import java.util.Optional;

public interface PersonRepository extends AbstractEntityRepository<Person> {
    Optional<Person> findByUuid(String uuid);
}