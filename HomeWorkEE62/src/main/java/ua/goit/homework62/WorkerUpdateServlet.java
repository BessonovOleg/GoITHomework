package ua.goit.homework62;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;


public class WorkerUpdateServlet extends HttpServlet {
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        Worker workerUpdated = new Worker();
        JdbcDAO dao = new JdbcDAO();
        request.setCharacterEncoding("UTF-8");
        workerUpdated.setWork_id(Integer.parseInt(request.getParameter("workId")));
        workerUpdated.setFirst_name(request.getParameter("firstName"));
        workerUpdated.setLast_name(request.getParameter("lastName"));
        workerUpdated.setDob(Date.valueOf(request.getParameter("dob")));
        workerUpdated.setPhone(request.getParameter("phone"));
        workerUpdated.setPosition(request.getParameter("position"));
        workerUpdated.setSalary(Double.valueOf(request.getParameter("salary")));

        dao.updateWorker(workerUpdated);

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
