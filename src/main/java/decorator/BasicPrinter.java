package decorator;

// Concrete class that extends abstract Printer class
public class BasicPrinter extends Printer {

    // Implements abstract print() method from Printer: prints the message without modifications
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
