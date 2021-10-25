CREATE TABLE planting  (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name varchar(64),
    square int NOT NULL,
    forestry_id BIGSERIAL,
    CONSTRAINT forestry_id_fk FOREIGN KEY (forestry_id) REFERENCES forestry (id) ON DELETE CASCADE
);
