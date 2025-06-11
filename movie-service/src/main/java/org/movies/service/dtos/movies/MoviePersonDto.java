package org.movies.service.dtos.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Builder;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UUID;
import org.movies.service.models.people.Role;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MoviePersonDto {
    @NotNull
    @UUID
    private String id;

    @NotNull
    private String name;

    @NotNull
    private String characterName;

    @NotNull
    private Role role;
}
