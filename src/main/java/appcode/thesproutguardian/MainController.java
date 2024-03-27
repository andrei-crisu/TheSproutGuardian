package appcode.thesproutguardian;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class MainController {

    @FXML
    public Label humidityLabel;

    @FXML
    public Label temperatureLabel;

    @FXML
    public Label luminosityLabel;

    @FXML
    public Label moistureLabel;

    @FXML
    public Label pumpLabel;

    @FXML Label timerLabel;

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