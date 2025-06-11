package org.movies.service.dtos.movies;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

import org.hibernate.validator.constraints.UUID;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieUpdateDto {
    @NotNull
    @UUID
    private String id;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private String posterUrl;

    @NotNull
    private LocalDate releaseDate;

    @NotNull
    private Integer duration;

    @NotNull
    private String rating;

    @NotNull
    private String language;

    @NotNull
    private String country;

    private String trailerUrl;

    @NotNull
    private Set<GenreDto> genres;
}
