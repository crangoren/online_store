drop table products if exists;
create table if not exists products (id bigserial primary key, title varchar(255), price int);

insert into products (title, price) values ('Milk', 56), ('Apples', 129), ('Bread', 59), ('Tea', 109), ('Sugar', 60),
('Salt', 20), ('Coffee', 299), ('Oranges', 89), ('Butter', 189), ('Cucumbers', 299),
('Tomatoes', 250), ('Chips', 109), ('Potatoes', 40), ('Onion', 20), ('Soda', 47),
('Cigarettes', 180), ('Nuts', 200), ('Cheese', 400), ('Ham', 500), ('Pepper', 30);