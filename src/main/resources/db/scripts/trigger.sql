create table history_of_price (
    id serial primary key,
    name varchar(50),
    price integer,
    date timestamp
);

create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

create or replace function after_tax_price()
    RETURNS trigger
    language plpgsql as
$$
BEGIN
    update products
    set price = price + price * 0.2
    where id = (select id from inserted);
    return new;
end;
$$;

create trigger after_tax_price_trigger
    after insert on products
    referencing new table as inserted
    for each statement
execute procedure after_tax_price();


create or replace function before_tax_price()
    returns trigger
    language plpgsql
    as
    $$
    begin
        update products
        set price = price + price * 0.2
        where id = new.id;
        return new;
    end;
    $$;

create trigger row_tax_price
    before insert on products
    for each row
    execute procedure before_tax_price();


create or replace function add_history_of_price()
    returns trigger
    language plpgsql
    as
    $$
    BEGIN
        insert into history_of_price(name, price, date)
            values (new.name, new.price, now());
            return new;
    end;
    $$;

create trigger insert_new_table
    after insert on products
    for each row
    execute procedure add_history_of_price();

