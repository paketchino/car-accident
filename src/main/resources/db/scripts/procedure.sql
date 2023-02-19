create or replace procedure insert_products
    (i_name varchar(50), prod varchar(50), i_count integer, i_price integer)
language plpgsql as
    $$
    begin
        insert into products(name, producer, count, price)
        VALUES (i_name, prod, i_count, i_price);
    end;
    $$;
call insert_products('Orange', 'Taiwan', 15, 22);
call insert_products('Juice', 'Taiwan', 15, 22);


create or replace procedure update_products
    (p_count integer, tax float, p_id integer)
language plpgsql as
    $$
    BEGIN
        if p_count > 0 then
            update products set count = count - p_count where id = p_id;
        end if;
        if tax > 0 then
            update products set price = price + price * tax;
        end if;
    end;
$$;
call update_products(15, 0.3, 2);

create or replace procedure delete_products (d_id integer)
    language plpgsql as
    $$
    BEGIN
    delete from products where id = d_id and count <= 0;
        end;
    $$;
call delete_products(10);

