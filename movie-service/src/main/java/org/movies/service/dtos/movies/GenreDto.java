package org.movies.service.dtos.movies;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.UUID;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenreDto {
    @UUID
    @NotNull
    private String id;

    @NotNull
    private String name;
}
