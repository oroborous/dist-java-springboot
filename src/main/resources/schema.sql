create table Ingredient (
    id varchar(4) not null,
    name varchar(25) not null,
    type varchar(10) not null
    );

create table Taco (
    id identity,
    name varchar(50) not null,
    created_at timestamp not null
);

create table Taco_Ingredients (
    taco_id bigint not null,
    ingredients_id varchar(4) not null
);

alter table Taco_Ingredients
    add foreign key (taco_id) references Taco(id);
alter table Taco_Ingredients
    add foreign key (ingredients_id) references Ingredient(id);

create table Taco_Order (
    id identity,
    name varchar(50) not null,
    street varchar(50) not null,
    city varchar(50) not null,
    state varchar(2) not null,
    zip varchar(10) not null,
    email varchar(100) not null,
    cc_Number varchar(20) not null,
    cc_Expiration varchar(5) not null,
    ccCVV varchar(3) not null,
    placed_At timestamp not null
    );

create table Taco_Order_Tacos (
    order_id bigint not null,
    tacos_id bigint not null
);

alter table Taco_Order_Tacos
    add foreign key (order_id) references Taco_Order(id);
alter table Taco_Order_Tacos
    add foreign key (tacos_id) references Taco(id);