-- -- CREATE TABLE IF NOT EXISTS animal
-- -- (
-- --     id SERIAL PRIMARY KEY,
-- --     name VARCHAR(255) NOT NULL UNIQUE,
-- --     age INTEGER NOT NULL,
-- --     breed_id BIGINT,
-- --     gender VARCHAR(255) NOT NULL,
-- --     CONSTRAINT age_non_negative CHECK (AGE >= 0)
-- -- );
-- --
-- --
-- -- CREATE TABLE IF NOT EXISTS breed
-- -- (
-- --     id SERIAL PRIMARY KEY,
-- --     name VARCHAR(255) NOT NULL UNIQUE
-- -- );
-- --
-- -- ALTER TABLE animal ADD CONSTRAINT fk_breed FOREIGN KEY(breed_id) REFERENCES breed(id);
-- --
-- -- INSERT INTO BREED (NAME) VALUES('Afganský chrt');
-- -- INSERT INTO BREED (NAME) VALUES('Americká akita');
-- -- INSERT INTO BREED (NAME) VALUES('Belgický ovčiak');
-- -- INSERT INTO BREED (NAME) VALUES('Bradáč');
-- --
-- -- INSERT INTO ANIMAL (name, age, breed_id, gender) VALUES('Pesox', 5, (SELECT ID FROM BREED WHERE NAME = 'Afganský chrt'), 'MALE');
-- -- INSERT INTO ANIMAL (name, age, breed_id, gender) VALUES('Havox', 7, (SELECT ID FROM BREED WHERE NAME = 'Afganský chrt'), 'FEMALE');
-- -- INSERT INTO ANIMAL (name, age, breed_id, gender) VALUES('Dixoxs', 1, (SELECT ID FROM BREED WHERE NAME = 'Americká akita'), 'MALE');
-- -- INSERT INTO ANIMAL (name, age, breed_id, gender) VALUES('Metlox', 0, (SELECT ID FROM BREED WHERE NAME = 'Americká akita'), 'FEMALE');
--
--
--
--
--
-- mysql syntax

CREATE TABLE  animal
(
    id int PRIMARY KEY,
    name TEXT,
    age int NOT NULL,
    breed_id int,
    gender TEXT
);

CREATE TABLE breed
(
    id int PRIMARY KEY,
    name TEXT
);

INSERT INTO BREED (id, NAME) VALUES(1, 'Afganský chrt');
INSERT INTO BREED (id, NAME) VALUES(2, 'Americká akita');
INSERT INTO BREED (id, NAME) VALUES(3, 'Belgický ovčiak');
INSERT INTO BREED (id, NAME) VALUES(4, 'Bradáč');

INSERT INTO ANIMAL (id, name, age, breed_id, gender) VALUES(1, 'Pesox', 5,1, 'MALE');
INSERT INTO ANIMAL (id, name, age, breed_id, gender) VALUES(2, 'Havox', 7, 1, 'FEMALE');
INSERT INTO ANIMAL (id, name, age, breed_id, gender) VALUES(3, 'Dixoxs', 1, 2, 'MALE');
INSERT INTO ANIMAL (id, name, age, breed_id, gender) VALUES(4, 'Metlox', 0, 2, 'FEMALE');