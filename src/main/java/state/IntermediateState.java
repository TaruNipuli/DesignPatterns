package state;

public class IntermediateState implements State {

    public void train(GameCharacter character) {
        System.out.println("Your character is training!");
        character.increaseExperience(5);

    }

    public void meditate(GameCharacter character) {
        System.out.println("Your character is meditating!");
        character.increaseHealth(3);

    }

    public void fight(GameCharacter character) {
        System.out.println("Your character can't fight yet...");

    }

    public String getLevelName() {
        return "Intermediate";
    }
}
