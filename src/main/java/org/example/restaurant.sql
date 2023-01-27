CREATE TABLE public.cafe
(
    id integer NOT NULL,
    name_of_cafe character varying,
    PRIMARY KEY (id)
);

CREATE TABLE public.dishes
(
    id integer NOT NULL,
    name_of_dish character varying,
    price integer,
    PRIMARY KEY (id)
);

CREATE TABLE public.orders
(
    id integer NOT NULL,
    id_of_cafe integer,
    id_of_dish integer,
    PRIMARY KEY (id_of_cafe)
);

alter table orders
    add foreign key (id_of_cafe)
        references cafe (id);

alter table orders
    add foreign key (id_of_dish)
        references dishes (id);

insert into cafe(id, name_of_cafe)
values (1,'Faiza');

insert into cafe(id, name_of_cafe)
values (2,'Arman');

insert into cafe(id, name_of_cafe)
values (3,'Barashek');

insert into cafe(id, name_of_cafe)
values (4,'Asia');

insert into cafe(id, name_of_cafe)
values (5,'Modern');

insert into dishes(id, name_of_dish, price)
values (1,'Lagman',150);

insert into dishes(id, name_of_dish, price)
values (2,'Plov',120);
insert into dishes(id, name_of_dish, price)
values (3,'Sup',130);

insert into dishes(id, name_of_dish, price)
values (4,'Blinchiki',80);

insert into dishes(id, name_of_dish, price)
values (5,'Fri',90);

insert into dishes(id, name_of_dish, price)
values (6,'Borsh',160);

insert into dishes(id, name_of_dish, price)
values (7,'Salat',95);

insert into dishes(id, name_of_dish, price)
values (8,'Kompot',50);

insert into dishes(id, name_of_dish, price)
values (9,'Chai',60);

insert into dishes(id, name_of_dish, price)
values (10,'Cola',120);

insert into orders(id, id_of_cafe, id_of_dish)
values (1,1,2);

insert into orders(id, id_of_cafe, id_of_dish)
values (2,1,1);

insert into orders(id, id_of_cafe, id_of_dish)
values (3,1,5);

insert into orders(id, id_of_cafe, id_of_dish)
values (4,2,2);

insert into orders(id, id_of_cafe, id_of_dish)
values (5,2,3);

insert into orders(id, id_of_cafe, id_of_dish)
values (6,2,6);

insert into orders(id, id_of_cafe, id_of_dish)
values (7,3,4);

insert into orders(id, id_of_cafe, id_of_dish)
values (8,3,8);

insert into orders(id, id_of_cafe, id_of_dish)
values (9,3,9);

insert into orders(id, id_of_cafe, id_of_dish)
values (10,4,5);

insert into orders(id, id_of_cafe, id_of_dish)
values (11,4,1);

insert into orders(id, id_of_cafe, id_of_dish)
values (12,4,2);

insert into orders(id, id_of_cafe, id_of_dish)
values (13,5,3);

insert into orders(id, id_of_cafe, id_of_dish)
values (15,5,8);