package org.movies.service.models.movies;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.movies.service.models.people.Person;
import org.movies.service.models.people.Role;

@Entity
@Getter
@Setter
@IdClass(MoviePersonId.class)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class MoviePerson {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @Id
    private Role role;

    private String characterName;
}
