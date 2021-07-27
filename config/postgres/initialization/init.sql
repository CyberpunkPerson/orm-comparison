create schema orm_comparison
    authorization postgres;

create table orm_comparison.address (
    id      uuid    not null,
    country text    not null,
    city    text    not null,
    street  text    not null,
    zip     integer not null,

    constraint address_pk primary key (id)
);

create table orm_comparison.users (
    id          uuid not null,
    name        text not null,
    address_id  uuid not null,

    constraint users_pk primary key (id),
    constraint users_fk_address foreign key (address_id) references orm_comparison.address (id)
);
