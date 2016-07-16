<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ua.goit.homework62.Worker"%>
<%@ page import="ua.goit.homework62.JdbcDAO" %>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="style.css" rel="stylesheet" type="text/css"/>
    <title>Сотрудник</title>
</head>
<body>

    <%
        int id = Integer.parseInt(request.getParameter("updateId"));
        JdbcDAO dao = new JdbcDAO();
        Worker worker = dao.getWorker(id);
    %>

<form method="post" action="updateWorker">
    <div id="mystyle" class="myform">
        <form id="form" name="form" action="updateWorker" method="post">
            <h1>Сотрудник</h1>
            <label><input type="hidden" name="workId" id="workId" value="<%=worker.getWork_id()%>"/><span class="small"></span></label>
            <label>Фамилия<span class="small">Введите фамилию</span></label>
            <input type="text" name="lastName" id="lastName" value="<%=worker.getLast_name()%>" />

            <label>Имя<span class="small">Введите имя</span></label>
            <input type="text" name="firstName" id="firstName" value="<%=worker.getFirst_name()%>" />

            <label>Дата рождения<span class="small">Введите дату рождения</span></label>
            <input type="date" name="dob" id="dob" value="<%=worker.getDob()%>"/>

            <label>Телефон<span class="small">Введите телефон</span></label>
            <input type="text" name="phone" id="phone" value="<%=worker.getPhone()%>"/>

            <label>Должность<span class="small">Введите должность</span></label>
            <input type="text" name="position" id="position" value="<%=worker.getPosition()%>"/>

            <label>Оклад<span class="small">Введите оклад</span></label>
            <input type="number" name="salary" id="salary" value="<%=worker.getSalary()%>"/>

            <button type="submit">Сохранить</button>
            <div class="spacer"></div>
        </form>
    </div>
</form>
</body>
</html>