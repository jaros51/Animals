CREATE TABLE IF NOT EXISTS ANIMAL(
     id integer,
     name varchar(255),
     age integer,
     breedId decimal,
     gender varchar(255)
);

INSERT INTO ANIMAL VALUES(1, 'Pesox', 11, 4, 'MALE');


CREATE TABLE IF NOT EXISTS BREED(
    id integer,
    name varchar(255) NOT NULL
);

INSERT INTO BREED VALUES(1, 'Afganský chrt');
INSERT INTO BREED VALUES(2, 'Americká akita');
INSERT INTO BREED VALUES(3, 'Belgický ovčiak');
INSERT INTO BREED VALUES(4, 'Bradáč');