package sample;

import database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.Node;

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
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()){
                infoBox("Incorrect input", null, "Failed");
            }else{
                infoBox("Login Successfull",null,"Success");
                Node node = (Node)event.getSource();
                dialogStage = (Stage) node.getScene().getWindow();
                dialogStage.close();
                scene = new Scene(FXMLLoader.load(getClass().getResource("sample1.fxml")));
                dialogStage.setScene(scene);
                dialogStage.show();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
