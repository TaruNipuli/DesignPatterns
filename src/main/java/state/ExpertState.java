package state;

public class ExpertState implements State {
    public void train(GameCharacter character) {
        System.out.println("Your character is training!");
        character.increaseExperience(10);

    }

    public void meditate(GameCharacter character) {
        System.out.println("Your character is meditating!");
        character.increaseHealth(5);

    }

    public void fight(GameCharacter character) {
        System.out.println("Your character is fighting!");
        character.decreaseHealth(5);
        character.increaseExperience(15);

    }

    public String getLevelName() {
        return "Expert";
    }
}
