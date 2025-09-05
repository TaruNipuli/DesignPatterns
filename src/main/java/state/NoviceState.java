package state;

// Implements State interface for the Novice level of the character
public class NoviceState implements State {

    public void train(GameCharacter character) {
        System.out.println("Your character is training!");
        character.increaseExperience(3);
    }

    public void meditate(GameCharacter character) {
        System.out.println("Your character can't meditate yet...");

    }

    public void fight(GameCharacter character) {
        System.out.println("Your character can't fight yet...");

    }

    public String getLevelName() {
        return "Novice";
    }
}
