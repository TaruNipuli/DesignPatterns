package abstract_factory;

// Implementation of abstract Button class for ButtonA
public class ButtonA extends Button{
    public ButtonA(String text) {
        super(text); // Calls the constructor of Button class
    }

    // Method to display the button, this is abstract method from Button class
    @Override
    public void display() {
        System.out.println("[ " + text + " ]"); // Displays the button text
    }


}
