package abstract_factory;

// Abstract class to define template for all Button types
public abstract class Button implements UpdateText {
    protected String text; // Text displayed on the button, subclasses can access it

    // Constructor to initialize button with text
    public Button(String text) {
        this.text = text; // Set the button's text
    }

    // Abstract method to display button
    public abstract void display();
    // Subclasses implement this to define how the button is displayed

    // Method to update the text
    @Override
    public void setText(String text) {
        this.text = text;
    }



}
