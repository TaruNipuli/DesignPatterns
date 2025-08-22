package abstract_factory;

public class Main {
    public static void main(String[] args) {
        // Factory for style A
        UIFactory factory = new AFactory();

        // Factory for style B
        //UIFactory factory = new BFactory();


        // Create ui elements
        Button button = factory.createButton("Click");
        Checkbox checkbox = factory.createCheckbox("[X]");
        TextField textField = factory.createTextField("Hello!");

        // Display elements
        button.display();
        checkbox.display();
        textField.display();

        System.out.println();
        System.out.println("Updating UI elements");
        System.out.println();

        // Update text of UI elements
        button.setText("Don't Click!");
        checkbox.setText("[ ]");
        textField.setText("Goodbye!");

        // Display updated elements
        button.display();
        checkbox.display();
        textField.display();
    }
}
