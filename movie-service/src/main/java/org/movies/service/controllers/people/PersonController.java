package org.movies.service.controllers.people;

import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.movies.service.dtos.Response;
import org.movies.service.dtos.people.PersonRequestDto;
import org.movies.service.utils.Constants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(Constants.API_VERSION + "/people")
public class PersonController {
    @GetMapping()
    public ResponseEntity<Response> getPeople(@RequestParam(required = false, defaultValue = "1") @Min(value = 1) Integer page,
                                              @RequestParam(required = false, defaultValue = "10") @Range(min = 1, max = 100) Integer size) {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getPersonById(@PathVariable String id) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Response> createPerson(@RequestBody PersonRequestDto personRequestDto) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> updatePerson(@PathVariable String id, @RequestBody PersonRequestDto personRequestDto) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deletePerson(@PathVariable String id) {
        return null;
    }
}
