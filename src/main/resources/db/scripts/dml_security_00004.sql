insert into users (username, password, enabled, authority_id)
values ('username', '$2b$10$wY1twJhMQjGVxv4y5dBC5ucCBlzkzT4FIGa4FNB/pS9GaXC2wm9/W', false,
        (select id from authorities where authority = 'ROLE_USER'));

insert into users (username, password, enabled, authority_id)
values ('supervisor', '$2b$10$wY1twJhMQjGVxv4y5dBC5ucCBlzkzT4FIGa4FNB/pS9GaXC2wm9/W', false,
        (select id from authorities where authority = 'ROLE_SUPERVISOR'));

insert into users (username, password, enabled, authority_id)
values ('root', '$2b$10$wY1twJhMQjGVxv4y5dBC5ucCBlzkzT4FIGa4FNB/pS9GaXC2wm9/W', false,
        (select id from authorities where authority = 'ROLE_ADMIN'));