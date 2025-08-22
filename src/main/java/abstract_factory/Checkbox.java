package abstract_factory;

// Abstract class to define template for all Checkbox types
public abstract class Checkbox implements UpdateText {
    protected String text; // Text displayed on the checkbox, subclasses can access it

    // Constructor to initialize checkbox with text
    public Checkbox(String text) {
        this.text = text; // Set the checkbox's text
    }

    // Abstract method to display checkbox
    public abstract void display();
    // Subclasses implement this to define how the checkbox is displayed

    // Method to update the text
    @Override
    public void setText(String text) {
        this.text = text;
    }
}
