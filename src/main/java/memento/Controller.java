package memento;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history; // Memento history
    private List<IMemento> redoHistory;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redoHistory = new ArrayList<>(); // Stores undone states so redo can be done
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        model.setOption(optionNumber, choice);
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!history.isEmpty()) {
            System.out.println("Memento found in history");

            // Save current state into redo list before undoing
            redoHistory.add(model.createMemento());

            IMemento previousState = history.remove(history.size() - 1);
            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);

        // Clear redo history ->  new change invalidates redo states
        redoHistory.clear();
        // Update GUI history list
        gui.addMementoToHistory(currentState);
    }

    // Method to redo the last undone action
    public void redo() {
        if (!redoHistory.isEmpty()) {
            System.out.println("Redo triggered");
            // Save current state so redo can be undone again
            history.add(model.createMemento());
            // Restore the most recently undone state
            IMemento nextState = redoHistory.remove(redoHistory.size() - 1);
            model.restoreState(nextState);
            gui.updateGui();
        }
    }

    // Method to restore a specific state from history
    public void restoreFromHistory(IMemento memento) {
        // Save current state so it can be undone
        history.add(model.createMemento());
        // Restore selected state
        model.restoreState(memento);
        gui.updateGui();
    }
}