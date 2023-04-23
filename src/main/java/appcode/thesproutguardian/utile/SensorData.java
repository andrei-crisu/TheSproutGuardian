package appcode.thesproutguardian.utile;
import javafx.application.Platform;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.TimerTask;

import com.google.gson.Gson;

public class SensorData extends TimerTask
{
    private static StringBuffer content;
    private Label humidityLabel;
    private Label temperatureLabel;
    public SensorData(Label humidityLabel,Label temperatureLabel){
        this.humidityLabel=humidityLabel;
        this.temperatureLabel=temperatureLabel;
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
            int lightStatus = readings.getPumpStatus();

            String temperatureString = String.format("%.1f", temperature);
            String humidityString=String.format("%.0f",humidity)+"%";
            Platform.runLater(() -> temperatureLabel.setText(temperatureString));
            Platform.runLater(()->humidityLabel.setText(humidityString));


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
