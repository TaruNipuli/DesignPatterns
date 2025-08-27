package observer;

import java.util.ArrayList;
import java.util.List;

// Abstract class representing a subject: maintains a list of observers and notifies them of changes
public abstract class Observable {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Notify observers of a temperature change
    protected void notifyObservers(int temperature) {
        for (Observer observer : observers) {
            // Call the update method on each observer
            observer.update(temperature);
        }
    }
}
