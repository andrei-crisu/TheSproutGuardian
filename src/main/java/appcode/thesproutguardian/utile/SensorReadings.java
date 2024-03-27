package appcode.thesproutguardian.utile;

public class SensorReadings {
    public double temperature;
    public double humidity;
    public double moisture;
    public double luminosity;
    public int pumpStatus;
    public int lightStatus;

    public double wateringInterval;

    public double checkMoistureTime;

    public double getTemperature() {
        return temperature;
    }


    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getMoisture() {
        return moisture;
    }

    public void setMoisture(double moisture) {
        this.moisture = moisture;
    }

    public double getLuminosity() {
        return luminosity;
    }

    public void setLuminosity(double luminosity) {
        this.luminosity = luminosity;
    }


    public void setPumpStatus(int pumpStatus) {
        this.pumpStatus = pumpStatus;
    }

    public int getPumpStatus()
    {
        return pumpStatus;
    }

    public void setLightStatus(int lightStatus) {
        this.lightStatus = lightStatus;
    }

    public int getLightStatus() {
    return lightStatus;
    }

    public double getWateringInterval() {
        return wateringInterval;
    }

    public void setWateringInterval(double wateringInterval) {
        this.wateringInterval = wateringInterval;
    }

    public double getCheckMoistureTime() {
        return checkMoistureTime;
    }

    public void setCheckMoistureTime(double checkMoistureTime) {
        this.checkMoistureTime = checkMoistureTime;
    }

}
