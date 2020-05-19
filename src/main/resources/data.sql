delete from Taco_Order_Tacos;
delete from Taco_Ingredients;
delete from Taco;
delete from Taco_Order;
delete from Ingredient;

insert into Ingredient (id, name, type)
values ('FLTO', 'Flour Tortilla', 'WRAP');
insert into Ingredient (id, name, type)
values ('COTO', 'Corn Tortilla', 'WRAP');
insert into Ingredient (id, name, type)
values ('GRBF', 'Ground Beef', 'PROTEIN');
insert into Ingredient (id, name, type)
values ('CARN', 'Carnitas', 'PROTEIN');
insert into Ingredient (id, name, type)
values ('TMTO', 'Diced Tomatoes', 'VEGGIES');
insert into Ingredient (id, name, type)
values ('LETC', 'Lettuce', 'VEGGIES');
insert into Ingredient (id, name, type)
values ('CHED', 'Cheddar', 'CHEESE');
insert into Ingredient (id, name, type)
values ('JACK', 'Monterrey Jack', 'CHEESE');
insert into Ingredient (id, name, type)
values ('SLSA', 'Salsa', 'SAUCE');
insert into Ingredient (id, name, type)
values ('SRCR', 'Sour Cream', 'SAUCE');

insert into Taco(id, created_at, name) values (100, '2020-05-15', 'Street Corn');
insert into Taco(id, created_at, name) values (101, '2020-05-15', 'Fried Avocado');
insert into Taco(id, created_at, name) values (102, '2020-05-16', 'Mean Green');
insert into Taco(id, created_at, name) values (103, '2020-05-16', 'Just Lettuce');

insert into Taco_Ingredients(taco_id, ingredients_id) values (100, 'FLTO');
insert into Taco_Ingredients(taco_id, ingredients_id) values (100, 'CARN');
insert into Taco_Ingredients(taco_id, ingredients_id) values (100, 'TMTO');
insert into Taco_Ingredients(taco_id, ingredients_id) values (100, 'CHED');

insert into Taco_Ingredients(taco_id, ingredients_id) values (101, 'COTO');
insert into Taco_Ingredients(taco_id, ingredients_id) values (101, 'GRBF');
insert into Taco_Ingredients(taco_id, ingredients_id) values (101, 'JACK');
insert into Taco_Ingredients(taco_id, ingredients_id) values (101, 'SLSA');
insert into Taco_Ingredients(taco_id, ingredients_id) values (101, 'SRCR');

insert into Taco_Ingredients(taco_id, ingredients_id) values (102, 'COTO');
insert into Taco_Ingredients(taco_id, ingredients_id) values (102, 'GRBF');
insert into Taco_Ingredients(taco_id, ingredients_id) values (102, 'JACK');
insert into Taco_Ingredients(taco_id, ingredients_id) values (102, 'SRCR');

insert into Taco_Ingredients(taco_id, ingredients_id) values (103, 'FLTO');
insert into Taco_Ingredients(taco_id, ingredients_id) values (103, 'LETC');

insert into Taco_Order (id, cccvv, cc_expiration, cc_number, city, name, placed_at, state, street, zip)
values (100, '111', '04/23', '1111-2222-3333-4444', 'Waukesha', 'Hello Kitty', '2020-05-15', 'WI', '123 4th St', '53188');
insert into Taco_Order (id, cccvv, cc_expiration, cc_number, city, name, placed_at, state, street, zip)
values (101, '999', '11/22', '5555-6666-7777-8888', 'Pewaukee', 'Dr. Instructor', '2020-05-16', 'WI', '800 Main St', '53072');

insert into Taco_Order_Tacos (order_id, tacos_id) values (100, 100);
insert into Taco_Order_Tacos (order_id, tacos_id) values (100, 101);
insert into Taco_Order_Tacos (order_id, tacos_id) values (101, 102);
insert into Taco_Order_Tacos (order_id, tacos_id) values (101, 103);