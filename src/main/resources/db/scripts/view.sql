create table if not exists ZIPs (
    id serial primary key,
    postal_code varchar(6) not null unique
);

insert into ZIPs (postal_code) values ('442963');
insert into ZIPs (postal_code) values ('552944');
insert into ZIPs (postal_code) values ('443489');
insert into ZIPs (postal_code) values ('814515');
insert into ZIPs (postal_code) values ('653399');

create table if not exists countries (
    id serial primary key,
    name text unique not null
);

insert into countries (name) values ('Russia');
insert into countries (name) values ('Spain');
insert into countries (name) values ('France');
insert into countries (name) values ('England');

create table if not exists cities (
    id serial primary key,
    county_id integer not null references countries(id),
    name_city text,
    oblast text
);

insert into cities (county_id, name_city, oblast) values (1, 'Sant-Peterburg', 'Петербужская область');
insert into cities (county_id, name_city, oblast) values (1, 'Moscow', 'Московская область');
insert into cities (county_id, name_city, oblast) values (2, 'Madrid', 'Knyjestvo chegoto');
insert into cities (county_id, name_city, oblast) values (3, 'Paris', 'Paris obl');
insert into cities (county_id, name_city, oblast) values (4, 'Manchester', 'Manchester obl');

create table if not exists addresses (
    id serial primary key,
    name_street text not null,
    city_id integer not null references cities(id),
    zip_id integer not null references ZIPs(id)
);

insert into addresses (name_street, city_id, zip_id) values ('ul. Pervomyaskay', 1, 2);
insert into addresses (name_street, city_id, zip_id) values ('ul. Broklynsaky', 3, 1);
insert into addresses (name_street, city_id, zip_id) values ('ul. Sheptonov', 2, 3);
insert into addresses (name_street, city_id, zip_id) values ('ul. Pushkino', 1, 4);
insert into addresses (name_street, city_id, zip_id) values ('ul. Zelenya', 4, 5);

create table if not exists companies (
    id serial primary key,
    name text,
    inn varchar(13) not null unique,
    kpp varchar(13) not null,
    address_id integer not null references addresses(id)
);

insert into companies (name, inn, kpp, address_id) VALUES ('Sberbank', '8961167375291', '6125725667278', 1);
insert into companies (name, inn, kpp, address_id) VALUES ('Yandex', '8161163375291', '123456790112', 2);
insert into companies (name, inn, kpp, address_id) VALUES ('UP Maksim Yakovlev', '8161163375759', '5678910111212', 1);
insert into companies (name, inn, kpp, address_id) VALUES ('Nike', '8161132175759', '8161188900159', 3);
insert into companies (name, inn, kpp, address_id) VALUES ('Addidas', '2401132175759', '86711222175759', 3);

create table if not exists storages (
    id serial primary key,
    name text,
    address_id integer not null references addresses(id)
);

insert into storages(name, address_id) VALUES ('Port Storage', 4);
insert into storages(name, address_id) VALUES ('Post Storage', 2);
insert into storages(name, address_id) VALUES ('Ozon Storage', 3);
insert into storages(name, address_id) VALUES ('Wildbries Storage', 3);
insert into storages(name, address_id) VALUES ('Adidas Storage Storage', 1);

create table if not exists universal_closing_documents (
    id serial primary key,
    company_id integer references companies(id),
    number text not null unique,
    service_name text not null,
    description text not null,
    isSend boolean default false,
    storage_id integer references storages(id) not null,
    accept boolean default false
);

insert into universal_closing_documents
    (company_id, number, service_name, description, isSend, storage_id, accept)
VALUES (4, 'MP-4357491', 'Перевод дс на счет какой то компании', 'Этот пользователь что то сделал', true, 2, true);

insert into universal_closing_documents
(company_id, number, service_name, description, isSend, storage_id, accept)
VALUES (1, 'AP-213113', 'Покупка обуви', 'Пользователь совершил покупку специальной обуви', false, 1, false);

insert into universal_closing_documents
(company_id, number, service_name, description, isSend, storage_id, accept)
VALUES (2, 'AP-5437483', 'Покупка зарубежной технике', 'Пользователь заказал видеокарту с озон', true, 5, false);


select u.service_name, u.description, u.isSend from universal_closing_documents as u
join companies c on c.id = u.company_id
join storages s on s.id = u.storage_id where s.address_id = c.address_id;


create view show_number_where_is_send_and_accept_true as
select u.number, count(u.number), u.issend,
       u.accept, u.service_name
from universal_closing_documents as u
         join companies c on c.id = u.company_id
         join addresses a on a.id = c.address_id
         join storages s on s.id = u.storage_id
where u.accept = true and u.issend = true
group by (u.number, u.issend, u.service_name, u.accept) order by u.number desc;

select * from show_number_where_is_send_and_accept_true;

alter view show_number_where_is_send_and_accept_true rename
    to new_show_number_where_is_send_and_accept_true;

drop view new_show_number_where_is_send_and_accept_true;