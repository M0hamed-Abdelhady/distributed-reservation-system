package org.movies.service.dtos.people;

import lombok.*;
import org.hibernate.validator.constraints.UUID;
import org.movies.service.models.people.Role;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonRequestDto {
    @NonNull
    @UUID
    private String id;

    @NonNull
    private String name;

    private String biography;

    private LocalDate birthDate;

    private LocalDate deathDate;

    @NonNull
    private Set<Role> roles;

    @NonNull
    private Map<String, String> socialMediaLinks;
}
