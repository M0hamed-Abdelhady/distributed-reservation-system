package org.movies.service.models.people;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.movies.service.models.AbstractEntity;
import org.movies.service.models.movies.MoviePerson;
import org.movies.service.utils.MapJSONConverter;
import org.movies.service.utils.RoleSetJSONConverter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Person extends AbstractEntity {

    @Column(nullable = false)
    private String name;

    private String biography;

    private String nationality;

    private LocalDate birthDate;

    private LocalDate deathDate;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<MoviePerson> moviePersons = new HashSet<>();

    @Convert(converter = RoleSetJSONConverter.class)
    @Column(columnDefinition = "TEXT")
    private Set<Role> roles = new HashSet<>();

    @Convert(converter = MapJSONConverter.class)
    @Column(columnDefinition = "TEXT")
    private Map<String, String> socialMediaLinks;
}
