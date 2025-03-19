drop table if exists abstract_user cascade;

CREATE TABLE abstract_user
(
    id         int  NOT NULL,
    uuid       VARCHAR(36) NOT NULL,
    role       VARCHAR(50),
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    version    BIGINT,
    name       VARCHAR(255) NOT NULL,
    email      VARCHAR(255) NOT NULL,
    password   VARCHAR(255) NOT NULL,
    CONSTRAINT pk_abstract_user PRIMARY KEY (id),
    CONSTRAINT uc_abstract_user_uuid UNIQUE (uuid),
    CONSTRAINT uc_abstract_user_email UNIQUE (email)
);