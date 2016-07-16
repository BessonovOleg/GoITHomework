<%@page import="ua.goit.homework62.JdbcDAO"%>
<%@page import="ua.goit.homework62.Worker"%>
<%@page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="style.css" rel="stylesheet" type="text/css"/>
    <title>Workers</title>
</head>
<body>
<center>
    <h1>Сотрудники</h1>
<div>
    <table>
        <thead>
        <tr>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Дата рождения</th>
            <th>Телефон</th>
            <th>Должность</th>
            <th>Оклад</th>
        </tr>
        </thead>
        <tbody>
        <%
            JdbcDAO dao = new JdbcDAO();
            ArrayList<Worker> workers;
            request.setCharacterEncoding("UTF-8");
            if (request.getParameter("findlastName") != null) {
               String findLastName = request.getParameter("findlastName");
               workers = dao.findWorkerByLastName(findLastName);
            }else{
                workers = dao.getAllWorkers();
            }
            for (Worker w : workers) {
        %>
        <tr>
            <td><%=w.getLast_name()%></td>
            <td><%=w.getFirst_name()%></td>
            <td><%=String.valueOf(w.getDob())%></td>
            <td><%=w.getPhone()%></td>
            <td><%=w.getPosition()%></td>
            <td><%=String.valueOf(w.getSalary())%></td>
            <td style="border: none;">
                <div>
                    <form method="post" action="workerUpdate.jsp">
                        <input type="hidden" id="updateId" name="updateId" value="<%=String.valueOf(w.getWork_id())%>"/>
                        <input type="submit" value="Редактировать..."/>
                    </form>
                </div>
            </td>
            <td style="border: none;">
                <div>
                    <form method="post" action="deleteWorker">
                        <input type="hidden" id="delId" name="delId" value="<%=String.valueOf(w.getWork_id())%>"/>
                        <input type="submit" value="Удалить"/>
                    </form>
                </div>
            </td>
        </tr>
        <%
            }
        %>

        <td style="border: none;">
            <div>
                <form method="post" action="workers.jsp">
                    <label>Поиск по фамилии</label>
                    <input type="text" name="findlastName" id="findlastName" />
                    <input type="submit" value="Найти"/>
                </form>
            </div>
        </td>

        </tbody>
    </table>
</div>

<div>
    <form method="post" action="workerAdd.jsp">
        <input type="submit" value="Добавить сотрудника"/>
    </form>
</div>





<center>
</body>
</html>