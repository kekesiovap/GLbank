package database;

import sample.Employee;
import sample.Globals;

import java.sql.*;

public class Database {

    private static Database db = new Database();
    private static final String checkEmployee = "SELECT * FROM employee INNER JOIN loginEmp ON loginEmp.ide=employee.id WHERE login = ? AND password = ?;";

    private Database() {
    }

    public static Database getInstanceDb() {
        return db;
    }

    private Connection getConnection() {
        Connection conn;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(Globals.url, Globals.username, Globals.password);
            System.out.println("Connecting");
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Employee getEmployee(String login, String password) throws SQLException {
        Connection conn = getConnection();
        try {
            int id = 0;
            String fname = "";
            String lname = "";
            String position = "";

            PreparedStatement sqlPreparedStatement = null;
            sqlPreparedStatement = conn.prepareStatement(checkEmployee);
            sqlPreparedStatement.setString(1, login);
            sqlPreparedStatement.setString(2, password);

            ResultSet rs = sqlPreparedStatement.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                fname = rs.getString("fname");
                lname = rs.getString("lname");
                position = rs.getString("position");
            }

            if (fname != "" && id != 0 && lname != "" && position != "") {
                System.out.println("ID: "+id+" | First name: "+fname+" | Last name: "+lname+" | Position ID: "+position);
                return new Employee(id, fname, lname, position);
            } else {
                return null;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            conn.rollback();
        }
        return  null;
    }
}
