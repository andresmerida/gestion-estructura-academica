create table country (
    id SMALLSERIAL PRIMARY KEY,
    name varchar (55) not null,
    initials char (6) not null,
    active bool not null
);