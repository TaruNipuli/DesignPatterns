package observer;

// ObservingWeather is observer that implements the Observer interface: receives temperature updates from WeatherStation
public class ObservingWeather implements Observer {
    // Name of observer
    private String name;

    // Constructor
    public ObservingWeather(String name) {
        this.name = name;
    }

    // Method to receive updates from WeatherStation
    @Override
    public void update(int temperature) {
        System.out.println(name + " received update: temperature is " + temperature + "°C");
    }
}
