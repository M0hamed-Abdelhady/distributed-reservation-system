package org.movies.service.dtos.movies;

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
    @NonNull
    private String title;

    @NonNull
    private String description;

    @NonNull
    private String posterUrl;

    @NonNull
    private LocalDate releaseDate;

    @NonNull
    private Integer duration;

    @NonNull
    private Double rating;

    @NonNull
    private String language;

    @NonNull
    private String country;

    private String trailerUrl;

    @NonNull
    private List<MoviePersonDto> crew;

    @NonNull
    private Set<GenreDto> genres;
}
