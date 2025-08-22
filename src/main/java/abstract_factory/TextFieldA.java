package abstract_factory;

// Implementation of abstract TextField class for TextFieldA
public class TextFieldA extends TextField {
    public TextFieldA(String text) {
        super(text); // Call the constructor of TextField class
    }


    @Override
    public void display() {
        System.out.println("<< " + text + " >>");
    }
}
