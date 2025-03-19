package org.movies.service.models.movies;

import org.movies.service.models.people.Role;

import java.io.Serializable;

public class MoviePersonId implements Serializable {
    private Long movie;
    private Long person;
    private Role role;
}
