CREATE TABLE IF NOT EXISTS animal
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    age INTEGER NOT NULL,
    breed_id BIGINT,
    gender VARCHAR(255) NOT NULL,
    CONSTRAINT age_non_negative CHECK (AGE >= 0)
);


CREATE TABLE IF NOT EXISTS breed
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

ALTER TABLE animal ADD CONSTRAINT fk_breed FOREIGN KEY(breed_id) REFERENCES breed(id);

INSERT INTO BREED (NAME) VALUES('Afganský chrt');
INSERT INTO BREED (NAME) VALUES('Americká akita');
INSERT INTO BREED (NAME) VALUES('Belgický ovčiak');
INSERT INTO BREED (NAME) VALUES('Bradáč');

INSERT INTO ANIMAL (name, age, breed_id, gender) VALUES('Dunčo', 5, (SELECT ID FROM BREED WHERE NAME = 'Afganský chrt'), 'MALE');
INSERT INTO ANIMAL (name, age, breed_id, gender) VALUES('Havo', 7, (SELECT ID FROM BREED WHERE NAME = 'Afganský chrt'), 'FEMALE');
INSERT INTO ANIMAL (name, age, breed_id, gender) VALUES('Dixo', 1, (SELECT ID FROM BREED WHERE NAME = 'Americká akita'), 'MALE');
INSERT INTO ANIMAL (name, age, breed_id, gender) VALUES('Candy', 0, (SELECT ID FROM BREED WHERE NAME = 'Americká akita'), 'FEMALE');
