CREATE SCHEMA if not exists hibernate;

CREATE TABLE IF NOT EXISTS hibernate.persons
(
    id             bigint         not null primary key,
    name           varchar(50) not null,
    surname        varchar(50) not null,
    age            int         not null check (age > 0),
    phone_number   varchar(20),
    city            varchar(40)
--     primary key (name, surname, age)
);

INSERT INTO hibernate.persons(id, name, surname, age, phone_number, city)
VALUES ('1','Alexey', 'Ivanov', 25, '375298759837', 'Minsk');
INSERT INTO hibernate.persons(id, name, surname, age, phone_number, city)
VALUES ('2','Dmitry', 'Maksimov', 32, '375295469854', 'Brest');
INSERT INTO hibernate.persons(id, name, surname, age, phone_number, city)
VALUES ('3','Andrey', 'Vladimirov', 19, '375295896544', 'Minsk');
