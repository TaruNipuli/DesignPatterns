package abstract_factory;

// Implementation of abstract Checkbox class for CheckboxA
public class CheckboxA extends Checkbox {
    public CheckboxA(String text) {
        super(text); // Calls the constructor of Checkbox class
    }

    // Methdod to display checkbox
    @Override
    public void display() {
        System.out.println("| " + text + " |");
    }
}
