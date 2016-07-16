<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="style.css" rel="stylesheet" type="text/css"/>
    <title>Добавленние сотрудника</title>
</head>
<body>

<form method="post" action="addWorker">
    <div id="mystyle" class="myform">
        <form id="form" name="form" action="addWorker" method="post">
            <h1>Сотрудник</h1>
            <p>Для добавления сотрудника, заполните информацию</p>
            <label>Фамилия<span class="small">Введите фамилию</span></label>
            <input type="text" name="lastName" id="lastName" />

            <label>Имя<span class="small">Введите имя</span></label>
            <input type="text" name="firstName" id="firstName" />

            <label>Дата рождения<span class="small">Введите дату рождения</span></label>
            <input type="date" name="dob" id="dob" />

            <label>Телефон<span class="small">Введите телефон</span></label>
            <input type="text" name="phone" id="phone" />

            <label>Должность<span class="small">Введите должность</span></label>
            <input type="text" name="position" id="position" />

            <label>Оклад<span class="small">Введите оклад</span></label>
            <input type="number" name="salary" id="salary" />

            <button type="submit">Добавить</button>
            <div class="spacer"></div>
        </form>
    </div>
</form>
</body>
</html>