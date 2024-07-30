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

INSERT INTO ANIMAL (id, name, age, breed_id, gender) VALUES(1, 'Dunčo', 5,1, 'MALE');
INSERT INTO ANIMAL (id, name, age, breed_id, gender) VALUES(2, 'Havo', 7, 1, 'FEMALE');
INSERT INTO ANIMAL (id, name, age, breed_id, gender) VALUES(3, 'Dixo', 1, 2, 'MALE');
INSERT INTO ANIMAL (id, name, age, breed_id, gender) VALUES(4, 'Candy', 0, 2, 'FEMALE');

