package org.movies.service.services.movies;

import org.movies.service.dtos.Response;
import org.movies.service.dtos.movies.MovieCreateDto;
import org.movies.service.dtos.movies.MovieUpdateDot;
import org.springframework.http.ResponseEntity;

public interface IMovieService {
    public ResponseEntity<Response> getAllMovies(Integer page, Integer size);

    public ResponseEntity<Response> getMovieById(String id);

    public ResponseEntity<Response> createMovie(MovieCreateDto movieCreateDto);

    public ResponseEntity<Response> updateMovie(String id, MovieUpdateDot movieUpdateDot);

    public ResponseEntity<Response> deleteMovie(String id);

}
