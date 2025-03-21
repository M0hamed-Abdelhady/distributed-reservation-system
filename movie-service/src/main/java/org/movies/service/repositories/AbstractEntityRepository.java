package org.movies.service.repositories;

import org.movies.service.models.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbstractEntityRepository<T extends AbstractEntity> extends JpaRepository<T, String> {
}
