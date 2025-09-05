package state;

public class MasterState implements State {

    public void train(GameCharacter character) {
        System.out.println("You've reached the master level!");

    }

    public void meditate(GameCharacter character) {
        System.out.println("You've reached the master level!");

    }

    public void fight(GameCharacter character) {
        System.out.println("You've reached the master level!");

    }

    public String getLevelName() {
        return "Master";
    }
}
