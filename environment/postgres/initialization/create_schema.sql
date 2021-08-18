create schema orm_comparison
    authorization postgres;

create table orm_comparison.address
(
    id      uuid    not null,
    country text    not null,
    city    text    not null,
    street  text    not null,
    zip     integer not null,

    constraint address_pk primary key (id)
);

create table orm_comparison.users
(
    id         uuid not null,
    name       text not null,
    address_id uuid not null,

    constraint users_pk primary key (id),
    constraint users_fk_address foreign key (address_id) references orm_comparison.address (id)
);

create table orm_comparison.orders
(
    id         uuid not null,
    user_id    uuid not null,
    address_id uuid not null,

    constraint order_pk primary key (id),
    constraint order_fk_users foreign key (user_id) references orm_comparison.users (id),
    constraint order_fk_address foreign key (address_id) references orm_comparison.address (id)
);

create table orm_comparison.item
(
    id          uuid             not null,
    title       text             not null,
    description text             not null,
    price       double precision not null,

    constraint item_pk primary key (id)
);

create table orm_comparison.order_item
(
    order_id uuid not null,
    item_id  uuid not null,

    constraint order_item_fk_order foreign key (order_id) references orm_comparison.orders (id),
    constraint order_item_fk_item foreign key (item_id) references orm_comparison.item (id)
);