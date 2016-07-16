package ua.goit.homework62;

import java.sql.*;
import java.util.ArrayList;

public class JdbcDAO {
    Connection connection = null;
    String url          = "jdbc:postgresql://127.0.0.1:5432/Restaurant";
    String userName     = "postgres";
    String userPassword = "123";

    private void openConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,userName,userPassword);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

//WORKERS
    public ArrayList<Worker> getAllWorkers(){
        openConnection();
        ArrayList<Worker> result = new ArrayList<>();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String sqlStr = "select \"WORK_ID\",\"LAST_NAME\",\"FIRST_NAME\",\"DOB\",\"PHONE\",\"POSITION\",\"SALARY\" from \"Workers\" order by \"LAST_NAME\"";
                ResultSet rs = statement.executeQuery(sqlStr);
                while (rs.next()) {
                    Worker worker = new Worker();
                    fillWorkDataFromResultSet(worker,rs);
                    result.add(worker);
                }
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                closeConnection();
            }
        }
        return result;
    }

    public ArrayList<Worker> findWorkerByLastName(String lastName) {
        openConnection();
        ArrayList<Worker> result = new ArrayList<>();
        String findText = "%" + lastName + "%";
        if (connection != null) {
            try {
                String sqlStr = "select \"WORK_ID\",\"LAST_NAME\",\"FIRST_NAME\",\"DOB\",\"PHONE\",\"POSITION\",\"SALARY\" from \"Workers\" where \"LAST_NAME\" like ? ";
                PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
                preparedStatement.setString(1,findText);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    Worker worker = new Worker();
                    fillWorkDataFromResultSet(worker,rs);
                    result.add(worker);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                closeConnection();
            }
        }
            return result;
    }





    public Worker getWorker(int WORK_ID) {
        openConnection();
        Worker result = new Worker();
        if (connection != null) {
            try {
                String sqlStr = "select \"WORK_ID\",\"LAST_NAME\",\"FIRST_NAME\",\"DOB\",\"PHONE\",\"POSITION\",\"SALARY\" from \"Workers\" where \"WORK_ID\" = ? ";
                PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
                preparedStatement.setInt(1,WORK_ID);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    fillWorkDataFromResultSet(result,rs);
                }
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                closeConnection();
            }
        }
           return result;
    }

    //insert or update worker.
    public void updateWorker(Worker worker) {
        openConnection();
        String sqlStr;
        if (connection != null) {
            //check worker_id. If = 0 then insert into database else update worker
            if(worker.getWork_id() == 0) {
                sqlStr = "insert into \"Workers\"(\"LAST_NAME\",\"FIRST_NAME\",\"DOB\",\"PHONE\",\"POSITION\",\"SALARY\") VALUES(?,?,?,?,?,?)";
            }else {
                sqlStr = "update \"Workers\" set \"LAST_NAME\" = ?,\"FIRST_NAME\" = ?,\"DOB\"=?,\"PHONE\"=?,\"POSITION\"=?,\"SALARY\"=? where \"WORK_ID\"= ? ";
            }

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
                preparedStatement.setString(1,worker.getLast_name());
                preparedStatement.setString(2,worker.getFirst_name());
                preparedStatement.setDate(3,worker.getDob());
                preparedStatement.setString(4,worker.getPhone());
                preparedStatement.setString(5,worker.getPosition());
                preparedStatement.setDouble(6,worker.getSalary());
                if(worker.getWork_id() > 0) {
                    preparedStatement.setInt(7,worker.getWork_id());
                }
                preparedStatement.executeUpdate();

            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                closeConnection();
            }
        }
    }

    public void deleteWorker(Worker worker) {
        deleteWorker(worker.getWork_id());
    }

    public void deleteWorker(int work_id) {
        openConnection();
        String sqlStr;
        if (connection != null) {
            sqlStr = "delete from \"Workers\" where \"WORK_ID\"= ? ";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
                preparedStatement.setInt(1,work_id);
                preparedStatement.executeUpdate();
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                closeConnection();
            }
        }
    }

    private void fillWorkDataFromResultSet(Worker worker,ResultSet resultSet) {
        try {
            worker.setWork_id(resultSet.getInt("WORK_ID"));
            worker.setLast_name(resultSet.getString("LAST_NAME"));
            worker.setFirst_name(resultSet.getString("FIRST_NAME"));
            worker.setDob(resultSet.getDate("DOB"));
            worker.setPhone(resultSet.getString("PHONE"));
            worker.setPosition(resultSet.getString("POSITION"));
            worker.setSalary(resultSet.getDouble("SALARY"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//end WORKERS

}
