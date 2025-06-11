package org.movies.service.services.movies;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.movies.service.dtos.Response;
import org.movies.service.dtos.movies.MovieCreateDto;
import org.movies.service.dtos.movies.MovieResponseDto;
import org.movies.service.dtos.movies.MovieUpdateDto;
import org.movies.service.models.movies.Movie;
import org.movies.service.repositories.movies.GenreRepository;
import org.movies.service.repositories.movies.MovieRepository;
import org.movies.service.utils.Constants;
import org.movies.service.utils.RepositoryUtils;
import org.movies.service.utils.ResponseEntityBuilder;
import org.movies.service.utils.mappers.movies.GenreMapper;
import org.movies.service.utils.mappers.movies.MovieCreateMapper;
import org.movies.service.utils.mappers.movies.MovieResponseMapper;
import org.movies.service.utils.mappers.movies.MovieUpdateMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Setter
public class MovieService implements IMovieService {
        private final MovieRepository movieRepository;
        private final GenreRepository genreRepository;
        private final RepositoryUtils repositoryUtils;
        private final MovieResponseMapper movieResponseMapper;
        private final MovieCreateMapper movieCreateMapper;
        private final MovieUpdateMapper movieUpdateMapper;
        private final GenreMapper genreMapper;

        @Override
        public ResponseEntity<Response> getAllMovies(Integer page, Integer size) {
                Pageable pageable = repositoryUtils.getPageable(page, size, Sort.Direction.ASC, "createdAt");
                Page<Movie> movies = movieRepository.findAll(pageable);

                List<MovieResponseDto> response = movies
                                .map(movieResponseMapper::toDto)
                                .toList();

                return ResponseEntityBuilder.create()
                                .withStatus(HttpStatus.OK)
                                .withMessage("Movies retrieved successfully")
                                .withData("movies", response)
                                .build();
        }

        @Override
        public ResponseEntity<Response> getMovieById(String id) {
                Movie movie = movieRepository.findById(id).orElse(null);

                if (movie == null)
                        return ResponseEntityBuilder.create()
                                        .withStatus(HttpStatus.NOT_FOUND)
                                        .withMessage("Movie not found")
                                        .build();

                MovieResponseDto response = movieResponseMapper.toDto(movie);

                return ResponseEntityBuilder.create()
                                .withStatus(HttpStatus.OK)
                                .withMessage("Movie retrieved successfully")
                                .withData("movie", response)
                                .build();
        }

        @Override
        public ResponseEntity<Response> createMovie(MovieCreateDto movieCreateDto) {
                Movie movie = movieCreateMapper.toEntity(movieCreateDto);
                movie = movieRepository.save(movie);
                String location = Constants.API_VERSION + "/movies/" + movie.getId();

                return ResponseEntityBuilder.create()
                                .withStatus(HttpStatus.CREATED)
                                .withMessage("Movie created successfully")
                                .withData("movie", movieResponseMapper.toDto(movie))
                                .withLocation(location)
                                .build();
        }

        @Override
        public ResponseEntity<Response> updateMovie(String id, MovieUpdateDto movieUpdateDto) {
                Movie movie = movieRepository.findById(id).orElse(null);

                if (movie == null)
                        return ResponseEntityBuilder.create()
                                        .withStatus(HttpStatus.NOT_FOUND)
                                        .withMessage("Movie not found")
                                        .build();

                movie.setTitle(movieUpdateDto.getTitle());
                movie.setDescription(movieUpdateDto.getDescription());
                movie.setPosterUrl(movieUpdateDto.getPosterUrl());
                movie.setTrailerUrl(movieUpdateDto.getTrailerUrl());
                movie.setReleaseDate(movieUpdateDto.getReleaseDate());
                movie.setDuration(movieUpdateDto.getDuration());
                movie.setRating(movieUpdateDto.getRating());
                movie.setLanguage(movieUpdateDto.getLanguage());
                movie.setCountry(movieUpdateDto.getCountry());
                movie.setGenres(
                                movieUpdateDto.getGenres()
                                                .stream()
                                                .map(genreMapper::toEntity)
                                                .collect(Collectors.toSet()));

                return ResponseEntityBuilder.create()
                                .withStatus(HttpStatus.OK)
                                .withMessage("Movie updated successfully")
                                .withData("movie", movieResponseMapper.toDto(movie))
                                .build();
        }

        @Override
        public ResponseEntity<Response> deleteMovie(String id) {
                Movie movie = movieRepository.findById(id).orElse(null);

                if (movie == null)
                        return ResponseEntityBuilder.create()
                                        .withStatus(HttpStatus.NOT_FOUND)
                                        .withMessage("Movie not found")
                                        .build();

                movieRepository.delete(movie);

                return ResponseEntityBuilder.create()
                                .withStatus(HttpStatus.OK)
                                .withMessage("Movie deleted successfully")
                                .build();
        }
}
