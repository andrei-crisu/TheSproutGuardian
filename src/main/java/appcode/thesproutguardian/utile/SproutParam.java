package appcode.thesproutguardian.utile;

public class SproutParam {
    private double temperature;
    private double humidity;
    private double moisture;
    private double luminosity;

    public SproutParam(double temperature, double humidity, double luminosity, double moisture) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.luminosity = luminosity;
        this.moisture=moisture;
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
