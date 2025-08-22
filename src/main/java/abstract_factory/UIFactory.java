package abstract_factory;

// Abstract factory class for creating UI elements
public abstract class UIFactory {
    // Abstract method to create a button
    public abstract Button createButton(String text);

    // Abstract method to create a checkbox
    public abstract Checkbox createCheckbox(String text);

    // Abstract method to create a text field
    public abstract TextField createTextField(String text);

}
