package org.movies.service.controllers.movies;

import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.movies.service.dtos.Response;
import org.movies.service.dtos.movies.MovieCreateDto;
import org.movies.service.dtos.movies.MovieUpdateDot;
import org.movies.service.utils.Constants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(Constants.API_VERSION + "/movies")
public class MovieController {

    @GetMapping
    public ResponseEntity<Response> getMovies(@RequestParam(required = false, defaultValue = "1") @Min(value = 1) Integer page,
                                              @RequestParam(required = false, defaultValue = "10") @Range(min = 1, max = 100) Integer size) {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getMovieById(@PathVariable String id) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Response> createMovie(@RequestBody MovieCreateDto movieCreateDto) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> updateMovie(@PathVariable String id, @RequestBody MovieUpdateDot movieUpdateDot) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteMovie(@PathVariable String id) {
        return null;
    }
}
