package ua.goit.homework62;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class WorkerAddServlet extends HttpServlet{

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Worker newWorker = new Worker();
        JdbcDAO dao = new JdbcDAO();
        request.setCharacterEncoding("UTF-8");
        newWorker.setWork_id(0);
        newWorker.setFirst_name(request.getParameter("firstName"));
        newWorker.setLast_name(request.getParameter("lastName"));
        newWorker.setDob(Date.valueOf(request.getParameter("dob")));
        newWorker.setPhone(request.getParameter("phone"));
        newWorker.setPosition(request.getParameter("position"));
        newWorker.setSalary(Double.valueOf(request.getParameter("salary")));

        dao.updateWorker(newWorker);
        response.sendRedirect("workers.jsp");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }
}
