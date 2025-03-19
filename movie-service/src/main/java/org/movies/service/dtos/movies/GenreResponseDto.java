package org.movies.service.dtos.movies;

import lombok.*;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenreResponseDto {
    private String id;

    private String name;
}
