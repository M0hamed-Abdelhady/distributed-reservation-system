package org.movies.service.repositories.movies;

import org.movies.service.models.movies.Genre;
import org.movies.service.repositories.AbstractEntityRepository;

import java.util.Optional;

public interface GenreRepository extends AbstractEntityRepository<Genre> {
    Optional<Genre> findByUuid(String uuid);
}
