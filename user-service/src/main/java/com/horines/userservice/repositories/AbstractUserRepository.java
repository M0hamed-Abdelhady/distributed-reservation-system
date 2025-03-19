package com.horines.userservice.repositories;

import com.horines.userservice.models.AbstractUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AbstractUserRepository extends JpaRepository<AbstractUser, Integer> {
    Optional<AbstractUser> findByUuid(String uuid);
    Optional<AbstractUser> findByEmail(String email);
    boolean existsByEmail(String email);
}