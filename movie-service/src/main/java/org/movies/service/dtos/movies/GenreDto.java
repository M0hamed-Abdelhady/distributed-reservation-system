package org.movies.service.dtos.movies;

import lombok.*;
import org.hibernate.validator.constraints.UUID;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenreDto {
    @UUID
    @NonNull
    private String id;

    @NonNull
    private String name;
}
