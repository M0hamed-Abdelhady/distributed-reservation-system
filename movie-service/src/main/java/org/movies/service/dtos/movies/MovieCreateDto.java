package org.movies.service.dtos.movies;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieCreateDto {
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
    private List<MoviePersonDto> crew;

    @NotNull
    private Set<GenreDto> genres;
}
