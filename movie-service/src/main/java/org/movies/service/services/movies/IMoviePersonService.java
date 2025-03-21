package org.movies.service.services.movies;

import org.movies.service.dtos.Response;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface IMoviePersonService {
    public ResponseEntity<Response> getMovieCrew(Integer page, Integer size, String movieId, Set<String> roles);

    public ResponseEntity<Response> getMoviePerson(String movieId, String personId);

    public ResponseEntity<Response> addMoviePerson(String movieId, String personId);

    public ResponseEntity<Response> removeMoviePerson(String movieId, String personId);
}
