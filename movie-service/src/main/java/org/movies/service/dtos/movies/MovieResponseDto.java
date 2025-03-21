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
public class MovieResponseDto {
    private String id;
    private String title;
    private String description;
    private String posterUrl;
    private String trailerUrl;
    private LocalDate releaseDate;
    private Integer duration;
    private Double rating;
    private String language;
    private String country;
    private List<MoviePersonDto> crew;
    private Set<GenreDto> genres;
}
