package abstract_factory;

// Implementation of abstract Checkbox class for CheckboxB
public class CheckboxB extends Checkbox {
    public CheckboxB(String text) {
        super(text); // Calls the constructor of Checkbox class
    }

    // Method to display checkbox
    @Override
    public void display() {
        System.out.println("|| " + text + " ||");
    }
}
