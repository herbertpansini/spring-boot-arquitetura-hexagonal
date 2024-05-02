CREATE TABLE public.products (
     id bigserial NOT NULL,
     discontinued bool NOT NULL,
     "name" varchar(255) NOT NULL,
     quantity_per_unit varchar(255) NULL,
     reorder_level int4 NULL,
     unit_price float8 NULL,
     units_in_stock int4 NULL,
     units_on_order int4 NULL,
     category_id int8 NOT NULL,
     CONSTRAINT products_pkey PRIMARY KEY (id),
     CONSTRAINT products_category_id_fkey FOREIGN KEY (category_id) REFERENCES public.categories(id)
);

INSERT INTO public.products ("name", category_id, quantity_per_unit, unit_price, units_in_stock, units_on_order, reorder_level, discontinued) VALUES ('Chai',1,'10 boxes x 20 bags',18,39,0,10,false);
INSERT INTO public.products ("name", category_id, quantity_per_unit, unit_price, units_in_stock, units_on_order, reorder_level, discontinued) VALUES ('Chang',1,'24 - 12 oz bottles',19,17,40,25,false);
INSERT INTO public.products ("name", category_id, quantity_per_unit, unit_price, units_in_stock, units_on_order, reorder_level, discontinued) VALUES ('Aniseed Syrup',2,'12 - 550 ml bottles',10,13,70,25,false);
INSERT INTO public.products ("name", category_id, quantity_per_unit, unit_price, units_in_stock, units_on_order, reorder_level, discontinued) VALUES ('Chef Anton''s Cajun Seasoning',2,'48 - 6 oz jars',22,53,0,0,false);
INSERT INTO public.products ("name", category_id, quantity_per_unit, unit_price, units_in_stock, units_on_order, reorder_level, discontinued) VALUES ('Chef Anton''s Gumbo Mix',2,'36 boxes',21.35,0,0,0,true);
INSERT INTO public.products ("name", category_id, quantity_per_unit, unit_price, units_in_stock, units_on_order, reorder_level, discontinued) VALUES ('Grandma''s Boysenberry Spread',2,'12 - 8 oz jars',25,120,0,25,false);
INSERT INTO public.products ("name", category_id, quantity_per_unit, unit_price, units_in_stock, units_on_order, reorder_level, discontinued) VALUES ('Uncle Bob''s Organic Dried Pears',7,'12 - 1 lb pkgs.',30,15,0,10,false);
INSERT INTO public.products ("name", category_id, quantity_per_unit, unit_price, units_in_stock, units_on_order, reorder_level, discontinued) VALUES ('Northwoods Cranberry Sauce',2,'12 - 12 oz jars',40,6,0,0,false);
INSERT INTO public.products ("name", category_id, quantity_per_unit, unit_price, units_in_stock, units_on_order, reorder_level, discontinued) VALUES ('Mishi Kobe Niku',6,'18 - 500 g pkgs.',97,29,0,0,true);
INSERT INTO public.products ("name", category_id, quantity_per_unit, unit_price, units_in_stock, units_on_order, reorder_level, discontinued) VALUES ('Ikura',8,'12 - 200 ml jars',31,31,0,0,false);
INSERT INTO public.products ("name", category_id, quantity_per_unit, unit_price, units_in_stock, units_on_order, reorder_level, discontinued) VALUES ('Queso Cabrales',4,'1 kg pkg.',21,22,30,30,false);
INSERT INTO public.products ("name", category_id, quantity_per_unit, unit_price, units_in_stock, units_on_order, reorder_level, discontinued) VALUES ('Queso Manchego La Pastora',4,'10 - 500 g pkgs.',38,86,0,0,false);
INSERT INTO public.products ("name", category_id, quantity_per_unit, unit_price, units_in_stock, units_on_order, reorder_level, discontinued) VALUES ('Konbu',8,'2 kg box',6,24,0,5,false);
INSERT INTO public.products ("name", category_id, quantity_per_unit, unit_price, units_in_stock, units_on_order, reorder_level, discontinued) VALUES ('Tofu',7,'40 - 100 g pkgs.',23.25,35,0,0,false);
INSERT INTO public.products ("name", category_id, quantity_per_unit, unit_price, units_in_stock, units_on_order, reorder_level, discontinued) VALUES ('Genen Shouyu',2,'24 - 250 ml bottles',15.5,39,0,5,false);
INSERT INTO public.products ("name", category_id, quantity_per_unit, unit_price, units_in_stock, units_on_order, reorder_level, discontinued) VALUES ('Pavlova',3,'32 - 500 g boxes',17.45,29,0,10,false);
INSERT INTO public.products ("name", category_id, quantity_per_unit, unit_price, units_in_stock, units_on_order, reorder_level, discontinued) VALUES ('Alice Mutton',6,'20 - 1 kg tins',39,0,0,0,true);
INSERT INTO public.products ("name", category_id, quantity_per_unit, unit_price, units_in_stock, units_on_order, reorder_level, discontinued) VALUES ('Carnarvon Tigers',8,'16 kg pkg.',62.5,42,0,0,false);
INSERT INTO public.products ("name", category_id, quantity_per_unit, unit_price, units_in_stock, units_on_order, reorder_level, discontinued) VALUES ('Teatime Chocolate Biscuits',3,'10 boxes x 12 pieces',9.2,25,0,5,false);
INSERT INTO public.products ("name", category_id, quantity_per_unit, unit_price, units_in_stock, units_on_order, reorder_level, discontinued) VALUES ('Sir Rodney''s Marmalade',3,'30 gift boxes',81,40,0,0,false);