package abstract_factory;

// Abstract class to define template for all TextField types
public abstract class TextField implements UpdateText {
    protected String text; // Text displayed in the text field, subclasses can access it

    // Constructor to initialize text field with text
    public TextField (String text) {
        this.text = text; // Set the text field's text
    }

    // Abstract method to display text field
    public abstract void display();
    // Subclasses implement this to define how the text field is displayed

    // Method to update the text
    @Override
    public void setText(String text) {
        this.text = text;
    }
}
