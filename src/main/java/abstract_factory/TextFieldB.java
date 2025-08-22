package abstract_factory;

// Implementation of abstract TextField class for TextFieldB
public class TextFieldB extends TextField {
    public TextFieldB(String text) {
        super(text); // Call the constructor of TextField class
    }


    @Override
    public void display() {
        System.out.println(">> " + text + " <<");
    }
}

