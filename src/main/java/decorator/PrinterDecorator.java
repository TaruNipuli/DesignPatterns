package decorator;

// Base class for all printer decorators
public class PrinterDecorator extends Printer{
    private Printer printer;

    public PrinterDecorator(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void print(String message) {
        printer.print(message);
    }

}
