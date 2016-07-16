package ua.goit.homework62;

import java.util.ArrayList;

/**
 * Created by user on 16.07.2016.
 */
public class TestClass {

    public static void main(String[] args) {
        JdbcDAO jdbcDAO = new JdbcDAO();
        //jdbcDAO.closeConnection();

        //String sqlStr = "select \"work_id\",\"last_name\",\"first_name\",\"dob\",\"phone\",\"position\",\"salary\" from \"workers\" order by last_name";

        //System.out.println(sqlStr);

        ArrayList<Worker> workers = jdbcDAO.findWorkerByLastName("о");
        for(Worker w:workers) {
            System.out.println(w.toString());
        }


    }


    }
