--1) Заполняем сотрудников

insert into "Workers"("LAST_NAME","FIRST_NAME","DOB","PHONE","POSITION","SALARY")
select 'Иванов','Иван','1990-10-10','+380501234567','официант',4000;

insert into "Workers"("LAST_NAME","FIRST_NAME","DOB","PHONE","POSITION","SALARY")
select 'Газаашвили','Гога','1958-04-03','+380952223344','повар',9000;

insert into "Workers"("LAST_NAME","FIRST_NAME","DOB","PHONE","POSITION","SALARY")
select 'Маисеев','Изя','1965-01-01','+380504445512','менеджер',12000;

insert into "Workers"("LAST_NAME","FIRST_NAME","DOB","PHONE","POSITION","SALARY")
select 'Дубина','Николай','1980-11-11','+380504567890','охрана',3000;

insert into "Workers"("LAST_NAME","FIRST_NAME","DOB","PHONE","POSITION","SALARY")
select 'Сверепов','Алексей','1989-04-03','+380502222222','бармен',5000;

insert into "Workers"("LAST_NAME","FIRST_NAME","DOB","PHONE","POSITION","SALARY")
select 'Вяткина','Алла','1987-05-05','+380503333333','официант',4000;


--2)Заполняем ингредиенты
insert into "Ingredients"("ING_NAME")
select 'майонез';

insert into "Ingredients"("ING_NAME")
select 'крабовые палочки';

insert into "Ingredients"("ING_NAME")
select 'картошка';

insert into "Ingredients"("ING_NAME")
select 'мясо';

insert into "Ingredients"("ING_NAME")
select 'буряк';

insert into "Ingredients"("ING_NAME")
select 'капуста';

insert into "Ingredients"("ING_NAME")
select 'молоко';

insert into "Ingredients"("ING_NAME")
select 'сироп';


--3) Заполняем остатки ингредиентов на складе
insert into "Warehouse"("ING_ID","QTY")
select 1,150;

insert into "Warehouse"("ING_ID","QTY")
select 2,50;

insert into "Warehouse"("ING_ID","QTY")
select 3,80;

insert into "Warehouse"("ING_ID","QTY")
select 4,420;

insert into "Warehouse"("ING_ID","QTY")
select 5,512;

insert into "Warehouse"("ING_ID","QTY")
select 6,15;

insert into "Warehouse"("ING_ID","QTY")
select 7,96;

insert into "Warehouse"("ING_ID","QTY")
select 8,241;


--4) Заполним категории блюд
insert into "Category"("CAT_NAME")
select 'Салаты';

insert into "Category"("CAT_NAME")
select 'Первые блюда';

insert into "Category"("CAT_NAME")
select 'Вторые блюда';

insert into "Category"("CAT_NAME")
select 'Коктейли';


--5) Заполняем блюда
insert into "Dishs"("DISH_NAME","CAT_ID","PRICE","WEIGHT")
select 'Салат крабовый',1,15,150;

insert into "Dishs"("DISH_NAME","CAT_ID","PRICE","WEIGHT")
select 'Борщ',2,25,250;

insert into "Dishs"("DISH_NAME","CAT_ID","PRICE","WEIGHT")
select 'Картошка фри',3,10,150;

insert into "Dishs"("DISH_NAME","CAT_ID","PRICE","WEIGHT")
select 'Молочный коктейль',4,12,250;

--6)Заполняем рецептуру
--крабовый салат
insert into "Recipes"("DISH_ID","ING_ID","QTY")
select 1,1,20;

insert into "Recipes"("DISH_ID","ING_ID","QTY")
select 1,2,120;
--борщ
insert into "Recipes"("DISH_ID","ING_ID","QTY")
select 2,3,50;

insert into "Recipes"("DISH_ID","ING_ID","QTY")
select 2,4,100;

insert into "Recipes"("DISH_ID","ING_ID","QTY")
select 2,5,50;

insert into "Recipes"("DISH_ID","ING_ID","QTY")
select 2,6,50;

--картошка фри
insert into "Recipes"("DISH_ID","ING_ID","QTY")
select 3,3,150;

--молочный коктейль
insert into "Recipes"("DISH_ID","ING_ID","QTY")
select 4,7,200;
insert into "Recipes"("DISH_ID","ING_ID","QTY")
select 4,8,50;

--7) Зполняем меню
insert into "Menu"("MENU_NAME")
select 'Первые блюда';

insert into "Menu"("MENU_NAME")
select 'Вторые блюда';

insert into "Menu"("MENU_NAME")
select 'Комплексные обеды';

--8) Заполняем состав блюд
insert into "Menu_contents"("MENU_ID","DISH_ID")
select 1,2;

insert into "Menu_contents"("MENU_ID","DISH_ID")
select 2,3;

insert into "Menu_contents"("MENU_ID","DISH_ID")
select 3,1;

insert into "Menu_contents"("MENU_ID","DISH_ID")
select 3,2;

insert into "Menu_contents"("MENU_ID","DISH_ID")
select 3,3;

insert into "Menu_contents"("MENU_ID","DISH_ID")
select 3,4;


--9) Заполняем заказы
insert into "Orders"("WORK_ID","TABLENO","ORDER_DATE")
select 1,'1','2016-06-05';

insert into "Orders"("WORK_ID","TABLENO","ORDER_DATE")
select 6,'4','2016-06-07';

--10) заполняем содержимое заказов
--борщ
insert into "Order_contents"("ORD_ID","DISH_ID","QTY")
select 1,2,1;

---комплексный обед
insert into "Order_contents"("ORD_ID","DISH_ID","QTY")
select 2,1,2;

insert into "Order_contents"("ORD_ID","DISH_ID","QTY")
select 2,2,1;

insert into "Order_contents"("ORD_ID","DISH_ID","QTY")
select 2,3,1;

insert into "Order_contents"("ORD_ID","DISH_ID","QTY")
select 2,4,1;


--11) заполняем приготовленные блюда
insert into "Cooked_dishs"("DISH_ID","WORK_ID","ORD_ID","DATE")
select 2,2,1,'2016-06-05';



insert into "Cooked_dishs"("DISH_ID","WORK_ID","ORD_ID","DATE")
select 1,2,2,'2016-06-07';

insert into "Cooked_dishs"("DISH_ID","WORK_ID","ORD_ID","DATE")
select 2,2,2,'2016-06-07';

insert into "Cooked_dishs"("DISH_ID","WORK_ID","ORD_ID","DATE")
select 3,2,2,'2016-06-07';

insert into "Cooked_dishs"("DISH_ID","WORK_ID","ORD_ID","DATE")
select 4,2,2,'2016-06-07';




--select * from "Workers"
--select * from "Ingredients"
--select * from "Warehouse"
--select * from "Dishs"
--select * from "Menu"
--select * from "Menu_contents"
--select * from "Recipes"
--select * from "Orders"
--select * from "Order_contents"
--select * from "Cooked_dishs"