package org.movies.service.dtos.people;

import lombok.*;
import org.movies.service.models.people.Role;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonResponseDto {
    private String id;
    private String name;
    private String biography;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Set<Role> roles;
    private Map<String, String> socialMediaLinks;
}
