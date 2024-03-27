package appcode.thesproutguardian.utile;

public class SproutParam {
    private double temperature;
    private double humidity;
    private double moisture;
    private double luminosity;

    private double pumpStatus;

    private double pumpTime;
    public static int PUMP_ON=255;

    public SproutParam(double temperature, double humidity, double luminosity, double moisture,
                       double pumpStatus,double pumpTime) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.luminosity = luminosity;
        this.moisture=moisture;
        this.pumpStatus=pumpStatus;
        this.pumpTime=pumpTime;
    }

    public double getTemperature(){
        return temperature;
    }

    public double getHumidity(){
        return humidity;
    }

    public double getLuminosity(){
        return luminosity;
    }

    public double getMoisture() {
        return moisture;
    }

    public void setMoisture(double moisture) {
        this.moisture = moisture;
    }

    public void setTemperature(double temperature){
        this.temperature=temperature;
    }

    public void setHumidity(double humidity){
        this.humidity=humidity;
    }

    public void setLuminosity(double luminosity){
        this.luminosity=luminosity;
    }

}
