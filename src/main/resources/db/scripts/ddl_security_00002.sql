CREATE TABLE IF NOT EXISTS authorities (
                             id serial primary key,
                             authority text unique not null
);

CREATE TABLE IF NOT EXISTS users (
                       id serial primary key,
                       username text unique NOT NULL,
                       password text NOT NULL,
                       enabled boolean default true,
                       authority_id int references authorities(id)
);