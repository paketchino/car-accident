create or replace function f_insert_data
    (i_name varchar(50), prod varchar(50), i_count integer, i_price integer)
returns void
language plpgsql as
    $$
    BEGIN
    insert into products(name, producer, count, price)
        values (i_name, prod, i_count, i_price);
    end;
    $$;

select f_insert_data('Apple 10', 'Apple', 20, 230);


create or replace function f_update_data
                (u_count integer, tax float, u_id integer)
returns integer
language plpgsql as
$$
    declare
        result integer;
    BEGIN
        if u_count > 0 then
            update products set count = count - u_count where id = u_id;
            select into result count from products where id = u_id;
        end if;
        if tax > 0 then
            update products set price = price + price * tax;
            select into result sum(price) from products;
        end if;
        return result;
    end;
$$;

select f_update_data(10, 0, 1);
select f_insert_data('product_2', 'producer_2', 15, 32);
select f_insert_data('product_3', 'producer_3', 8, 115);
select f_update_data(0, 0.2, 14);


create or replace function f_delete_products(f_id integer)
returns void
language plpgsql
    as
    $$
    BEGIN
        delete from products where id = f_id and price < 90;
    end;
    $$;

select f_delete_products(4);
