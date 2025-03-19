DROP TABLE IF EXISTS movie_person;
DROP TABLE IF EXISTS movie_genres;
DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS genre;
DROP TABLE IF EXISTS movie;

CREATE TABLE movie
(
    id           BIGSERIAL PRIMARY KEY,
    uuid         VARCHAR(255)     NOT NULL UNIQUE,
    created_at   TIMESTAMP        NOT NULL,
    updated_at   TIMESTAMP        NOT NULL,
    version      BIGINT,
    title        VARCHAR(255)     NOT NULL,
    description  TEXT             NOT NULL,
    poster_url   VARCHAR(255)     NOT NULL,
    release_date DATE             NOT NULL,
    duration     INTEGER          NOT NULL,
    rating       DOUBLE PRECISION NOT NULL,
    language     VARCHAR(50)      NOT NULL,
    country      VARCHAR(50)      NOT NULL,
    trailer_url  VARCHAR(255)
);

CREATE TABLE person
(
    id                 BIGSERIAL PRIMARY KEY,
    uuid               VARCHAR(255) NOT NULL UNIQUE,
    created_at         TIMESTAMP    NOT NULL,
    updated_at         TIMESTAMP    NOT NULL,
    version            BIGINT,
    name               VARCHAR(255) NOT NULL,
    biography          TEXT,
    nationality        VARCHAR(100),
    birth_date         DATE,
    death_date         DATE,
    roles              TEXT         NOT NULL,
    social_media_links TEXT
);

CREATE TABLE genre
(
    id         BIGSERIAL PRIMARY KEY,
    uuid       VARCHAR(255) NOT NULL UNIQUE,
    created_at TIMESTAMP    NOT NULL,
    updated_at TIMESTAMP    NOT NULL,
    version    BIGINT,
    name       VARCHAR(255) NOT NULL
);

CREATE TABLE movie_person
(
    id             BIGSERIAL PRIMARY KEY,
    uuid           VARCHAR(255) NOT NULL UNIQUE,
    created_at     TIMESTAMP    NOT NULL,
    updated_at     TIMESTAMP    NOT NULL,
    version        BIGINT,
    movie_id       BIGINT       NOT NULL,
    person_id      BIGINT       NOT NULL,
    role           VARCHAR(50)  NOT NULL,
    character_name VARCHAR(255),
    CONSTRAINT fk_movie
        FOREIGN KEY (movie_id)
            REFERENCES movie (id)
            ON DELETE CASCADE,
    CONSTRAINT fk_person
        FOREIGN KEY (person_id)
            REFERENCES person (id)
            ON DELETE CASCADE
);

CREATE TABLE movie_genre
(
    movie_id BIGINT NOT NULL,
    genre_id BIGINT NOT NULL,
    PRIMARY KEY (movie_id, genre_id),
    CONSTRAINT fk_movie_genre_movie
        FOREIGN KEY (movie_id)
            REFERENCES movie (id)
            ON DELETE CASCADE,
    CONSTRAINT fk_movie_genre_genre
        FOREIGN KEY (genre_id)
            REFERENCES genre (id)
            ON DELETE CASCADE
);