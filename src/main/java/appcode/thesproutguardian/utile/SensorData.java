package appcode.thesproutguardian.utile;
import javafx.application.Platform;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.TimerTask;

import com.google.gson.Gson;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SensorData extends TimerTask
{
    private static StringBuffer content;
    private Label humidityLabel;
    private Label temperatureLabel;

    private Label luminosityLabel;

    private Label moistureLabel;

    private Label pumpLabel;

    private Label timerLabel;
    public SensorData(Label humidityLabel,Label temperatureLabel,
                      Label luminosityLabel,Label moistureLabel,
                      Label pumpLabel,Label timerLabel){
        this.humidityLabel=humidityLabel;
        this.temperatureLabel=temperatureLabel;
        this.luminosityLabel=luminosityLabel;
        this.moistureLabel=moistureLabel;
        this.pumpLabel=pumpLabel;
        this.timerLabel=timerLabel;
    }
    public void run()
    {
        try {
            //The IP for the connection
            //First is when ESP32 is used as work station ( it connects to another device)
            //String serverUrl = "http://192.168.137.45/readings";
            //this is when esp32 works as Access Point( oder devices connect to it).
            String serverUrlEsp32="http://192.168.4.1/readings";

            URL url = new URL(serverUrlEsp32);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            connection.disconnect();
            String jsonString=new String(getContent());
            System.out.println("Received message: " + jsonString);

            SensorReadings readings = parseSensorReadings(jsonString);

            double temperature = readings.getTemperature();
            double humidity = readings.getHumidity();
            double luminosity = readings.getLuminosity();
            int pumpStatus = readings.getPumpStatus();
            //not needed anymore. Created a class instance that stores all those parameters
            //double moisture =readings.getMoisture();
           //int lightStatus = readings.getPumpStatus();

            double wateringInterval=readings.getWateringInterval();
            double pumpTime= readings.getCheckMoistureTime();
            double leftTime=wateringInterval-pumpTime;
            if(leftTime<0)
                leftTime=0;

            SproutParam sproutParam=new SproutParam(readings.getTemperature(),
                    readings.getHumidity(),
                    readings.getLuminosity(),
                    readings.getMoisture(),
                    readings.getPumpStatus(),
                    readings.getCheckMoistureTime());

            String temperatureString = String.format("%.1f", temperature);
            String humidityString=String.format("%.0f",humidity)+"%";
            String luminosityString=String.format("%.0f",luminosity)+"%";
            String moistureString=String.format("%.0f",sproutParam.getMoisture())+"%";
            String timerString=String.format("%.0f",leftTime);
            String pumpStatusString;
            Color color;
            if(pumpStatus==SproutParam.PUMP_ON)
            {
                color = Color.web("#799FC3");
                pumpStatusString = "ON";
            }
            else
            {
                pumpStatusString="OFF";
                color = Color.web("#CC1111");
            }

            if(humidity!=0)
            {
                Platform.runLater(() -> temperatureLabel.setText(temperatureString));
                Platform.runLater(() -> humidityLabel.setText(humidityString));
            }

            Platform.runLater(()->luminosityLabel.setText(luminosityString));
            Platform.runLater(()->moistureLabel.setText(moistureString));
            Platform.runLater(()->pumpLabel.setText(pumpStatusString));
            Platform.runLater(()->timerLabel.setText(timerString));


            Platform.runLater(() -> {
                pumpLabel.setTextFill(color);
            });


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public SensorReadings parseSensorReadings(String jsonString) {
        Gson gson = new Gson();
        SensorReadings readings = gson.fromJson(jsonString, SensorReadings.class);
        return readings;
    }

    String getContent(){
        return  content.toString();
    }
}
