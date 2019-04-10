package sample;

import database.Database;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import java.sql.SQLException;

public class Controller {
    public TextField usernameText;
    public TextField passwordText;

    public void getEmployee(ActionEvent actionEvent) throws SQLException {
        String login = usernameText.getText();
        String password = passwordText.getText();

        Database database = Database.getInstanceDb();
        Employee emp = database.getEmployee(login,password);
        if(emp != null){
            System.out.println("ID: "+emp.getId()+" | First name: "+emp.getFname()+" | Last name: "+emp.getLname()+" | Position ID: "+emp.getPosition());
        }
    }
}
