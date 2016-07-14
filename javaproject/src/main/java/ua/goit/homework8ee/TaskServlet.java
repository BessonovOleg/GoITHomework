package ua.goit.homework8ee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class TaskServlet extends HttpServlet {

    private static ArrayList<Task> tasks = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Add task
        if (request.getParameter("AddTaskButton") != null) {
            String nameTask = request.getParameter("NameTask").toString();
            String categoryTask = request.getParameter("CategoryTask").toString();

            if (!"".equals(nameTask) && !"".equals(categoryTask)) {
                tasks.add(new Task(nameTask, categoryTask));
            }
        }

        //Update task
        if (request.getParameter("UpdateTask") != null) {
            if (request.getParameterValues("TaskCompleted") != null) {
                String indexCompletedTasks[] = request.getParameterValues("TaskCompleted");

                ArrayList<Task> taskForDelete = new ArrayList<>();

                for (int i = 0; i < indexCompletedTasks.length; i++) {
                    taskForDelete.add(tasks.get(Integer.valueOf(indexCompletedTasks[i])));
                }

                for(Task t:taskForDelete) {
                    tasks.remove(t);
                }

            }
        }

            request.setAttribute("taskArray", tasks);
            request.getRequestDispatcher("mytasks.jsp").forward(request, response);

    }



}
