package appcode.thesproutguardian;

import appcode.thesproutguardian.utile.SensorData;
import appcode.thesproutguardian.utile.SproutParam;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

public class MainApplication extends Application {
    SproutParam sproutParameteres;
    MainController mainController;
    Timer timer;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("mainView.fxml"));
        String css_string=this.getClass().getResource("application_style.css").toExternalForm();
        //

        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(css_string);
        stage.setTitle("TheSproutGuardian");
        stage.getIcons().add(new Image(MainApplication.class.getResourceAsStream("/images/sprout.png")));
        stage.setWidth(720);
        stage.setHeight(520);
        stage.setMinWidth(720);
        stage.setMinHeight(520);
        stage.setScene(scene);
        mainController = fxmlLoader.getController();

        timer = new Timer();
        TimerTask task = new SensorData(mainController.humidityLabel,
                mainController.temperatureLabel,
                mainController.luminosityLabel,
                mainController.moistureLabel,
                mainController.pumpLabel,
                mainController.timerLabel);
        timer.schedule(task, 100, 1000);

        sproutParameteres=new SproutParam(-77,-77,-77,
                -77,0,0);

        mainController.humidityLabel.setText(String.valueOf(sproutParameteres.getHumidity())+"%");
        mainController.temperatureLabel.setText(String.valueOf(sproutParameteres.getTemperature())+"");
        mainController.luminosityLabel.setText(String.valueOf(sproutParameteres.getLuminosity())+"%");
        mainController.moistureLabel.setText(String.valueOf(sproutParameteres.getMoisture())+"%");


        stage.setOnCloseRequest(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Sprout :: EXIT ");
            alert.setHeaderText("Are you sure you want to exit?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                // Stop the timer task
                timer.cancel();
                // Close the application
                stage.close();
            } else {
                // Consume the event to prevent the application from closing
                event.consume();
            }
        });


        stage.show();


    }

    public static void main(String[] args) {

        launch();
    }
    public void updateGuiInfo() {

    }

}