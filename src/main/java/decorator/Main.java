package decorator;

public class Main {
    public static void main(String[] args) {

        // BasicPrinter
        Printer printer = new BasicPrinter();
        printer.print("Hello World!");

        // XMLPrinter + BasicPrinter
        Printer xmlPrinter = new XMLPrinter(printer);
        xmlPrinter.print("Hello World!");

        // EncryptedPrinter + BasicPrinter
        Printer encryptedPrinter = new EncryptedPrinter(new BasicPrinter());
        encryptedPrinter.print("Hello World!");

        // EncryptedPrinter + XMLPrinter + BasicPrinter
        Printer printer2 = new EncryptedPrinter(new XMLPrinter(new BasicPrinter()));
        printer2.print("Hello World!");
    }
}
