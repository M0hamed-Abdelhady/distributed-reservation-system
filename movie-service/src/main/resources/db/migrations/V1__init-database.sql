drop table if exists person;

drop table if exists movie;

drop table if exists moviePerson;

CREATE TYPE role_enum AS ENUM (
    'ACTOR',
    'DIRECTOR',
    'PRODUCER',
    'WRITER',
    'CINEMATOGRAPHER',
    'EDITOR',
    'CASTING_DIRECTOR',
    'PRODUCTION_DESIGNER',
    'ART_DIRECTOR',
    'COSTUME_DESIGNER',
    'MAKEUP_ARTIST',
    'HAIR_STYLIST',
    'SOUND_DESIGNER',
    'SOUND_MIXER',
    'PRODUCTION_MANAGER',
    'STUNT_COORDINATOR',
    'STUNT_PERFORMER',
    'VISUAL_EFFECTS_SUPERVISOR',
    'VFX_ARTIST',
    'CAMERA_OPERATOR',
    'LIGHTING_TECHNICIAN',
    'VFX_SUPERVISOR',
    'SPECIAL_EFFECTS_SUPERVISOR',
    'ANIMATOR',
    'MUSIC_COMPOSER'
);

CREATE TYPE genre_enum AS ENUM (
    'ACTION',
    'ADVENTURE',
    'ANIMATION',
    'BIOGRAPHY',
    'COMEDY',
    'CRIME',
    'DOCUMENTARY',
    'DRAMA',
    'FAMILY',
    'FANTASY',
    'HISTORY',
    'HORROR',
    'MUSIC',
    'MUSICAL',
    'MYSTERY',
    'ROMANCE',
    'SCI_FI',
    'SPORT',
    'THRILLER',
    'WAR',
    'WESTERN'
);

CREATE TABLE movie
(
    id           BIGSERIAL PRIMARY KEY,
    uuid         VARCHAR(36) NOT NULL,
    created_at   TIMESTAMPTZ NOT NULL,
    updated_at   TIMESTAMPTZ NOT NULL,
    version      BIGINT,
    title        TEXT        NOT NULL,
    description  TEXT        NOT NULL,
    poster_url   TEXT        NOT NULL,
    release_date DATE        NOT NULL,
    duration     INTEGER     NOT NULL,
    language     VARCHAR(50) NOT NULL,
    country      TEXT        NOT NULL,
    trailer_url  TEXT
);

CREATE TABLE person
(
    id                 BIGSERIAL PRIMARY KEY,
    uuid               VARCHAR(36)  NOT NULL,
    created_at         TIMESTAMPTZ  NOT NULL,
    updated_at         TIMESTAMPTZ  NOT NULL,
    version            BIGINT,
    name               VARCHAR(255) NOT NULL,
    biography          TEXT,
    nationality        VARCHAR(50),
    birth_date         DATE,
    death_date         DATE,
    roles              TEXT         NOT NULL,
    social_media_links TEXT
);

CREATE TABLE movie_person
(
    movie_id      BIGSERIAL NOT NULL,
    person_id     BIGSERIAL NOT NULL,
    role          role_enum NOT NULL,
    characterName TEXT,
    PRIMARY KEY (movie_id, person_id, role),
    CONSTRAINT fk_movie
        FOREIGN KEY (movie_id)
            REFERENCES movies (id)
            ON DELETE CASCADE,
    CONSTRAINT fk_person
        FOREIGN KEY (person_id)
            REFERENCES persons (id)
            ON DELETE CASCADE
);

CREATE TABLE movie_genres
(
    movie_id BIGINT     NOT NULL,
    genre    genre_enum NOT NULL,
    PRIMARY KEY (movie_id, genre),
    CONSTRAINT fk_movie_genres FOREIGN KEY (movie_id) REFERENCES movie (id) ON DELETE CASCADE
);