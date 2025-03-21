package org.movies.service.controllers.movies;

import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.movies.service.dtos.Response;
import org.movies.service.dtos.movies.MoviePersonDto;
import org.movies.service.utils.Constants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(Constants.API_VERSION + "/movies")
public class MoviePersonController {

    @GetMapping("/{movieId}/people")
    public ResponseEntity<Response> getMovieCrew(@RequestParam(required = false, defaultValue = "1") @Min(value = 1) Integer page,
                                                 @RequestParam(required = false, defaultValue = "10") @Range(min = 1, max = 100) Integer size,
                                                 @PathVariable String movieId, @RequestParam(required = false) Set<String> roles) {
        return null;
    }

    @GetMapping("/{movieId}/people/{personId}")
    public ResponseEntity<Response> getMoviePerson(@PathVariable String movieId, @PathVariable String personId) {
        return null;
    }

    @PostMapping("/{movieId}/people")
    public ResponseEntity<Response> addMoviePerson(@PathVariable String movieId, @RequestBody MoviePersonDto moviePersonDto) {
        return null;
    }

    @DeleteMapping("/{movieId}/people/{personId}")
    public ResponseEntity<Response> removeMoviePerson(@PathVariable String movieId, @PathVariable String personId) {
        return null;
    }
}
