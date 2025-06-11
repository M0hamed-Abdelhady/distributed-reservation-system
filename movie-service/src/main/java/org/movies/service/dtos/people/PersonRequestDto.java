package org.movies.service.dtos.people;

import jakarta.validation.constraints.NotNull;
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
    @NotNull
    @UUID
    private String id;

    @NotNull
    private String name;

    private String biography;

    private LocalDate birthDate;

    private LocalDate deathDate;

    @NotNull
    private Set<Role> roles;

    private Map<String, String> socialMediaLinks;
}
