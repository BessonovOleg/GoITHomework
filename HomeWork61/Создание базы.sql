--Создание базы данных
CREATE DATABASE "Restaurant"
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Russian_Russia.1251'
       LC_CTYPE = 'Russian_Russia.1251'
       CONNECTION LIMIT = -1;


--Сотрудники
CREATE TABLE "Workers"
(
  "WORK_ID" serial NOT NULL,
  "LAST_NAME" character varying(50), -- Фамилия
  "FIRST_NAME" character varying(50), -- Имя
  "DOB" date, -- Дата рождения
  "PHONE" character varying(50), -- Телефон
  "POSITION" character varying, -- Должность
  "SALARY" money, -- Оклад
  CONSTRAINT "Workers_pkey" PRIMARY KEY ("WORK_ID")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "Workers"
  OWNER TO postgres;
COMMENT ON TABLE "Workers"
  IS 'Сотрудники';
COMMENT ON COLUMN "Workers"."LAST_NAME" IS 'Фамилия';
COMMENT ON COLUMN "Workers"."FIRST_NAME" IS 'Имя';
COMMENT ON COLUMN "Workers"."DOB" IS 'Дата рождения';
COMMENT ON COLUMN "Workers"."PHONE" IS 'Телефон';
COMMENT ON COLUMN "Workers"."POSITION" IS 'Должность';
COMMENT ON COLUMN "Workers"."SALARY" IS 'Оклад';

--Категории
CREATE TABLE "Category"
(
  "CAT_ID" serial NOT NULL,
  "CAT_NAME" character varying(255),
  CONSTRAINT "Category_pkey" PRIMARY KEY ("CAT_ID")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "Category"
  OWNER TO postgres;
COMMENT ON TABLE "Category"
  IS 'Категория блюд';

--Меню
CREATE TABLE "Menu"
(
  "MENU_ID" serial NOT NULL,
  "MENU_NAME" character varying(255),
  CONSTRAINT "Menu_pkey" PRIMARY KEY ("MENU_ID")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "Menu"
  OWNER TO postgres;
  
--Ингредиенты
CREATE TABLE "Ingredients"
(
  "ING_ID" serial NOT NULL,
  "ING_NAME" character varying(255),
  CONSTRAINT "Ingredients_pkey" PRIMARY KEY ("ING_ID")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "Ingredients"
  OWNER TO postgres;
COMMENT ON TABLE "Ingredients"
  IS 'Ингредиенты';

--Блюда
CREATE TABLE "Dishs"
(
  "DISH_ID" serial NOT NULL,
  "DISH_NAME" character varying(255),
  "CAT_ID" integer, -- Категория
  "PRICE" money,
  "WEIGHT" real,
  CONSTRAINT "Dishs_pkey" PRIMARY KEY ("DISH_ID"),
  CONSTRAINT "Dish_to_category" FOREIGN KEY ("CAT_ID")
      REFERENCES "Category" ("CAT_ID") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "Dishs"
  OWNER TO postgres;
COMMENT ON TABLE "Dishs"
  IS 'Блюда';
COMMENT ON COLUMN "Dishs"."CAT_ID" IS 'Категория';


-- Index: "fki_Dish_to_category"

-- DROP INDEX "fki_Dish_to_category";

CREATE INDEX "fki_Dish_to_category"
  ON "Dishs"
  USING btree
  ("CAT_ID");

--Рецепты
CREATE TABLE "Recipes"
(
  "ID" serial NOT NULL,
  "DISH_ID" integer, -- Блюдо
  "ING_ID" integer, -- Ингредиент
  "QTY" real,
  CONSTRAINT "Recipes_pkey" PRIMARY KEY ("ID"),
  CONSTRAINT "Recipes_to_dish" FOREIGN KEY ("DISH_ID")
      REFERENCES "Dishs" ("DISH_ID") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "Recipes_to_ingredient" FOREIGN KEY ("ING_ID")
      REFERENCES "Ingredients" ("ING_ID") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "Recipes"
  OWNER TO postgres;
COMMENT ON TABLE "Recipes"
  IS 'Рецепты';
COMMENT ON COLUMN "Recipes"."DISH_ID" IS 'Блюдо';
COMMENT ON COLUMN "Recipes"."ING_ID" IS 'Ингредиент';


-- Index: "fki_Recipes_to_dish"

-- DROP INDEX "fki_Recipes_to_dish";

CREATE INDEX "fki_Recipes_to_dish"
  ON "Recipes"
  USING btree
  ("DISH_ID");

-- Index: "fki_Recipes_to_ingredient"

-- DROP INDEX "fki_Recipes_to_ingredient";

CREATE INDEX "fki_Recipes_to_ingredient"
  ON "Recipes"
  USING btree
  ("ING_ID");
  
--Склады
CREATE TABLE "Warehouse"
(
  "ID" serial NOT NULL,
  "ING_ID" integer, -- Ингредиент
  "QTY" real, -- Количество
  CONSTRAINT "Warehouse_pkey" PRIMARY KEY ("ID"),
  CONSTRAINT "Warehouse_to_ingredient" FOREIGN KEY ("ING_ID")
      REFERENCES "Ingredients" ("ING_ID") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "Warehouse"
  OWNER TO postgres;
COMMENT ON TABLE "Warehouse"
  IS 'Склад';
COMMENT ON COLUMN "Warehouse"."ING_ID" IS 'Ингредиент';
COMMENT ON COLUMN "Warehouse"."QTY" IS 'Количество';


-- Index: "fki_Warehouse_to_ingredient"

-- DROP INDEX "fki_Warehouse_to_ingredient";

CREATE INDEX "fki_Warehouse_to_ingredient"
  ON "Warehouse"
  USING btree
  ("ING_ID");

--Содержимое меню
CREATE TABLE "Menu_contents"
(
  "ID" serial NOT NULL,
  "MENU_ID" integer, -- Меню
  "DISH_ID" integer, -- Блюдо
  CONSTRAINT "Menu_contents_pkey" PRIMARY KEY ("ID"),
  CONSTRAINT "Menu_contents_to_dish" FOREIGN KEY ("DISH_ID")
      REFERENCES "Dishs" ("DISH_ID") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "Menu_contents_to_menu" FOREIGN KEY ("MENU_ID")
      REFERENCES "Menu" ("MENU_ID") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "Menu_contents"
  OWNER TO postgres;
COMMENT ON TABLE "Menu_contents"
  IS 'Содержимое меню';
COMMENT ON COLUMN "Menu_contents"."MENU_ID" IS 'Меню';
COMMENT ON COLUMN "Menu_contents"."DISH_ID" IS 'Блюдо';


-- Index: "fki_Menu_contents_to_menu"

-- DROP INDEX "fki_Menu_contents_to_menu";

CREATE INDEX "fki_Menu_contents_to_menu"
  ON "Menu_contents"
  USING btree
  ("MENU_ID");

-- Index: "fki_Menu_items_to_dish"

-- DROP INDEX "fki_Menu_items_to_dish";

CREATE INDEX "fki_Menu_items_to_dish"
  ON "Menu_contents"
  USING btree
  ("DISH_ID");

--Заказы
CREATE TABLE "Orders"
(
  "ORD_ID" serial NOT NULL,
  "WORK_ID" integer, -- Официант
  "TABLENO" character varying(50), -- Номер столика
  "ORDER_DATE" date, -- Дата заказа
  CONSTRAINT "Orders_pkey" PRIMARY KEY ("ORD_ID"),
  CONSTRAINT "Orders_to_worker" FOREIGN KEY ("WORK_ID")
      REFERENCES "Workers" ("WORK_ID") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "Orders"
  OWNER TO postgres;
COMMENT ON TABLE "Orders"
  IS 'Заказы';
COMMENT ON COLUMN "Orders"."WORK_ID" IS 'Официант';
COMMENT ON COLUMN "Orders"."TABLENO" IS 'Номер столика';
COMMENT ON COLUMN "Orders"."ORDER_DATE" IS 'Дата заказа';


-- Index: "fki_Orders_to_worker"

-- DROP INDEX "fki_Orders_to_worker";

CREATE INDEX "fki_Orders_to_worker"
  ON "Orders"
  USING btree
  ("WORK_ID");

--Содержимое заказа
CREATE TABLE "Order_contents"
(
  "ID" serial NOT NULL,
  "ORD_ID" integer, -- Заказ
  "DISH_ID" integer, -- Блюдо
  "QTY" real, -- Количество
  CONSTRAINT "Order_contents_pkey" PRIMARY KEY ("ID"),
  CONSTRAINT "Order_contents_to_dish" FOREIGN KEY ("DISH_ID")
      REFERENCES "Dishs" ("DISH_ID") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "Order_contents_to_order" FOREIGN KEY ("ORD_ID")
      REFERENCES "Orders" ("ORD_ID") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "Order_contents"
  OWNER TO postgres;
COMMENT ON TABLE "Order_contents"
  IS 'Состав заказа';
COMMENT ON COLUMN "Order_contents"."ORD_ID" IS 'Заказ';
COMMENT ON COLUMN "Order_contents"."DISH_ID" IS 'Блюдо';
COMMENT ON COLUMN "Order_contents"."QTY" IS 'Количество';


-- Index: "fki_Order_contents_to_dish"

-- DROP INDEX "fki_Order_contents_to_dish";

CREATE INDEX "fki_Order_contents_to_dish"
  ON "Order_contents"
  USING btree
  ("DISH_ID");

-- Index: "fki_Order_contents_to_order"

-- DROP INDEX "fki_Order_contents_to_order";

CREATE INDEX "fki_Order_contents_to_order"
  ON "Order_contents"
  USING btree
  ("ORD_ID");

--Готовые блюда
CREATE TABLE "Cooked_dishs"
(
  "ID" serial NOT NULL,
  "DISH_ID" integer, -- Блюдо
  "WORK_ID" integer, -- Повар
  "ORD_ID" integer, -- Заказ
  "DATE" date, -- Дата
  CONSTRAINT "Cooked_dishs_pkey" PRIMARY KEY ("ID"),
  CONSTRAINT "Cooked_dish_to_dish" FOREIGN KEY ("DISH_ID")
      REFERENCES "Dishs" ("DISH_ID") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "Cooked_dish_to_orders" FOREIGN KEY ("ORD_ID")
      REFERENCES "Orders" ("ORD_ID") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "Cooked_dish_to_work" FOREIGN KEY ("WORK_ID")
      REFERENCES "Workers" ("WORK_ID") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "Cooked_dishs"
  OWNER TO postgres;
COMMENT ON TABLE "Cooked_dishs"
  IS 'Приготовленные блюда';
COMMENT ON COLUMN "Cooked_dishs"."DISH_ID" IS 'Блюдо';
COMMENT ON COLUMN "Cooked_dishs"."WORK_ID" IS 'Повар';
COMMENT ON COLUMN "Cooked_dishs"."ORD_ID" IS 'Заказ';
COMMENT ON COLUMN "Cooked_dishs"."DATE" IS 'Дата';


-- Index: "fki_Cooked_dish_to_dish"

-- DROP INDEX "fki_Cooked_dish_to_dish";

CREATE INDEX "fki_Cooked_dish_to_dish"
  ON "Cooked_dishs"
  USING btree
  ("DISH_ID");

-- Index: "fki_Cooked_dish_to_orders"

-- DROP INDEX "fki_Cooked_dish_to_orders";

CREATE INDEX "fki_Cooked_dish_to_orders"
  ON "Cooked_dishs"
  USING btree
  ("ORD_ID");

-- Index: "fki_Cooked_dish_to_work"

-- DROP INDEX "fki_Cooked_dish_to_work";

CREATE INDEX "fki_Cooked_dish_to_work"
  ON "Cooked_dishs"
  USING btree
  ("WORK_ID");

  
