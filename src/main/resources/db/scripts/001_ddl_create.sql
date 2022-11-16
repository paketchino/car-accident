create table if not exists accident_types (
    id serial primary key,
    name text not null
);

create table if not exists rules (
    id serial primary key,
    name text not null
);

CREATE TABLE if not exists accidents (
    id serial primary key,
    name text not null,
    address text not null,
    number int not null,
    description text not null,
    photo bytea,
    status BOOLEAN default false,
    rules_id int not null references rules(id),
    accidentType_id int not null references accident_types(id)
);