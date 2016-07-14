<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My ToDo List</title>
</head>
<body>

<p>My Tasks</p>

<hr />
<p><strong><span style="font-size:26px;">My ToDo List</span></strong></p>

<form method="get" action="tasks">
<table border="1" cellpadding="1" cellspacing="1" style="width:500px;">
    <tbody>
    <tr>
        <td><strong>Name</strong></td>
        <td><strong>Category</strong></td>
        <td><strong>Completed</strong></td>
    </tr>
    <tr>

    <%int i = 0;%>
    <c:forEach items="${taskArray}" var="taskOne">
    <tr>
        <td><c:out value="${taskOne.getTaskName()}" /></td>
        <td><c:out value="${taskOne.getTaskCategory()}"/></td>
        <td><input name="TaskCompleted" type="checkbox" value="<%=i%>"/>​</td>
    </tr>
    <%i++;%>
    </c:forEach>
    </tr>
    </tbody>
</table>
<p><input name="UpdateTask" type="submit" value="Update Tasks" /></p>
</form>



<form method="get" action="tasks">
<p><strong>Task Name &nbsp; &nbsp; &nbsp;&nbsp;<input name="NameTask" size="50" type="text" /></strong></p>
<p><strong>Task Category &nbsp;<input name="CategoryTask" size="50" type="text" /></strong></p>
<p><strong><input name="AddTaskButton" type="submit" value="Add Task" /></strong></p>
</form>

</body>
</html>
