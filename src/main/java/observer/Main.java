package observer;

public class Main {
    public static void main(String[] args) {
        // Create a WeatherStation instance
        WeatherStation weatherStation = new WeatherStation();

        // Create Observers
        Observer observer1 = new ObservingWeather("Observer 1");
        Observer observer2 = new ObservingWeather("Observer 2");
        Observer observer3 = new ObservingWeather("Observer 3");

        // Add observers to the weather station
        weatherStation.addObserver(observer1);
        weatherStation.addObserver(observer2);
        weatherStation.addObserver(observer3);

        // Start the WeatherStation thread
        Thread stationThread = new Thread(weatherStation);
        stationThread.start();

        // Simulation runs 10 seconds
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Remove observer
        weatherStation.removeObserver(observer2);
        System.out.println("Removed Observer 2");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Stop weather station
        weatherStation.stop();
        try {
            stationThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Weather station stopped.");

    }
}
