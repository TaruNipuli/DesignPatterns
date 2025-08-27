package observer;

import java.util.Random;

// WeatherStation is observable that simulates temperature changes
// runs in its own thread and notifies observers of temperature updates
public class WeatherStation extends Observable implements Runnable {
    private int temperature;
    private int min = -20;
    private int max = 20;
    private boolean running = true;
    private Random random = new Random();


    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers(temperature);
    }

    public int getTemperature() {
        return temperature;
    }

    // Thread's run method: updates temperature periodically and notifies observers
    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep((random.nextInt(5) + 1) * 1000); // Sleep for a random interval between 1 and 5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // random.nextBoolean() to randomly decides whether to increase (true) or decrease (false)
            // if random.nextBoolean() is true, change = 1; if false, change = -1
            int change = random.nextBoolean() ? 1 : -1;
            temperature += change;

            if (temperature < min) {
                temperature = min;
            } else if (temperature > max) {
                temperature = max;
            }

            // Notify observers about the new temperature
            notifyObservers(temperature);
        }
    }

    // Stop the WeatherStation thread
    public void stop() {
        running = false;
    }
}
