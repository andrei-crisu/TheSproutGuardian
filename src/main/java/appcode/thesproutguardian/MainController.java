package appcode.thesproutguardian;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class MainController {
    @FXML
    public void homeButtonClicked(ActionEvent e)
    {
        System.out.println("Home");
    }
    @FXML
    public void viewButtonClicked(ActionEvent e)
    {

        System.out.println("View");
    }
    @FXML
    public void settingsButtonClicked(ActionEvent e)
    {
        System.out.println("Settings");
    }
    @FXML
    public void aboutButtonClicked(ActionEvent e)
    {
        System.out.println("About");
    }

}