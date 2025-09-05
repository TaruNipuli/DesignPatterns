package state;

// Class representing game character and its stats
public class GameCharacter {
    private String name;
    private int experience;
    private int health;
    private State currentState;


    public GameCharacter(String name) {
        this.name = name;
        this.experience = 0;
        this.health = 100;
        this.currentState = new NoviceState(); // Start as novice
    }


    // Methods for character actions
    public void train() {
        currentState.train(this);
    }

    public void meditate() {
        currentState.meditate(this);
    }

    public void fight() {
        currentState.fight(this);
    }


    public void increaseExperience(int amount) {
        experience += amount;
        System.out.println(name + " gained " + amount + " experience. Total experience: " + experience);
        updateState();
    }

    public void increaseHealth(int amount) {
        health += amount;
        if (health > 100) health = 100; // Health can't go over 100
        System.out.println(name + " healed " + amount + " health. Total health: " + health);
        updateState();
    }

    public void decreaseHealth(int amount) {
        health -= amount;
        if (health < 0) health = 0; // Health can't go under 0
        System.out.println(name + " lost " + amount + " health. Total health: " + health);
        updateState();
    }


    // Update character's state based on the amount of xp
    private void updateState() {
        if (experience >= 100) {
            currentState = new MasterState();
        } else if (experience >= 50) {
            currentState = new ExpertState();
        } else if (experience >= 30) {
            currentState = new IntermediateState();
        } else {
            currentState = new NoviceState();
        }
    }


    // Print current character status
    public void printStatus() {
        System.out.println(
                "Character: " + name +
                        ", State: " + currentState.getLevelName() +
                        ", Experience: " + experience +
                        ", Health: " + health
        );
    }


    // Getter for current status
    public State getCurrentState() {
        return currentState;
    }

}
