CREATE TABLE public.categories (
   id bigserial NOT NULL,
   description varchar(255) NULL,
   "name" varchar(255) NOT NULL,
   CONSTRAINT categories_pkey PRIMARY KEY (id)
);

INSERT INTO public.categories (description, "name") VALUES ('Soft drinks, coffees, teas, beers, and ales', 'Beverages');
INSERT INTO public.categories (description, "name") VALUES ('Sweet and savory sauces, relishes, spreads, and seasonings', 'Condiments');
INSERT INTO public.categories (description, "name") VALUES ('Desserts, candies, and sweet breads', 'Confections');
INSERT INTO public.categories (description, "name") VALUES ('Cheeses', 'Dairy Products');
INSERT INTO public.categories (description, "name") VALUES ('Breads, crackers, pasta, and cereal', 'Grains/Cereals');
INSERT INTO public.categories (description, "name") VALUES ('Prepared meats', 'Meat/Poultry');
INSERT INTO public.categories (description, "name") VALUES ('Dried fruit and bean curd', 'Produce');
INSERT INTO public.categories (description, "name") VALUES ('Seaweed and fish', 'Seafood');