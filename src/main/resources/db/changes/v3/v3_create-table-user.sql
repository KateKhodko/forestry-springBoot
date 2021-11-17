CREATE TABLE profile
(
    id         BIGSERIAL NOT NULL PRIMARY KEY,
    login      varchar(64),
    password   varchar(64)
);