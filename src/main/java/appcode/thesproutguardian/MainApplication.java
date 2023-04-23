package appcode.thesproutguardian;

import appcode.thesproutguardian.utile.SensorData;
import appcode.thesproutguardian.utile.SproutParam;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainApplication extends Application {
    SproutParam sproutPrameteres;
    MainController mainController;
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
        stage.setMinWidth(700);
        stage.setMinHeight(480);
        stage.setScene(scene);
        mainController = fxmlLoader.getController();

        Timer timer = new Timer();
        TimerTask task = new SensorData(mainController.humidityLabel,mainController.temperatureLabel);
        timer.schedule(task, 100, 5000);

        sproutPrameteres=new SproutParam(25,30,30);

        mainController.humidityLabel.setText(String.valueOf(sproutPrameteres.getHumidity())+"%");
        stage.show();


    }

    public static void main(String[] args) {

        launch();
    }
    public void updateGuiInfo() {

    }

}