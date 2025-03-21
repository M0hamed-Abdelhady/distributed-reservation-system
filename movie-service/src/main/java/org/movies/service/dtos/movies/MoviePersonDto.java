package org.movies.service.dtos.movies;

import lombok.*;
import org.hibernate.validator.constraints.UUID;
import org.movies.service.models.people.Role;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MoviePersonDto {
    @NonNull
    @UUID
    private String id;

    private String characterName;

    @NonNull
    private Role role;
}
