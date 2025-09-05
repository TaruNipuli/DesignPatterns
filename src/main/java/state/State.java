package state;

// Each level/state will implement this interface
public interface State {
    void train(GameCharacter character);
    void meditate(GameCharacter character);
    void fight(GameCharacter character);
    String getLevelName();
}
