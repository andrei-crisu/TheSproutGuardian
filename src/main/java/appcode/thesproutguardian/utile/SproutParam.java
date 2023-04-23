package appcode.thesproutguardian.utile;

public class SproutParam {
    private double temperature;
    private double humidity;
    private double luminosity;

    public SproutParam(double temperature, double humidity, double luminosity) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.luminosity = luminosity;
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
