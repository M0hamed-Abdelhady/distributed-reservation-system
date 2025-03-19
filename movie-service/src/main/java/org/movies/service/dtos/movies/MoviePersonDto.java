package org.movies.service.dtos.movies;

import lombok.*;
import org.hibernate.validator.constraints.UUID;

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
    private String role;
}
