package decorator;

// Encrypts messages using Caesar cipher
public class EncryptedPrinter extends PrinterDecorator {

    private final int shift = 3; // Number of positions to shift each letter

    public EncryptedPrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String message) {
        // Encrypt the message using Caesar cipher
        String encryptedMessage = encryptCaesar(message);
        super.print(encryptedMessage);
    }

    // Shift letters by shift positions
    private String encryptCaesar(String message) {
        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) { // Convert the message into a character array and iterate over each character
            if (c >= 'a' && c <= 'z') { // If the character is a lowercase letter a to z
                // Shift it by shift positions within a-z, wrapping around using modulo 26
                // Modulo 26 is used because there are 26 letters in the English alphabet.
                // This ensures that after z, the counting goes back to a.
                sb.append((char) ('a' + (c - 'a' + shift) % 26));

            } else if (c >= 'A' && c <= 'Z') { // If the character is an uppercase letter 'A' to 'Z'
                sb.append((char) ('A' + (c - 'A' + shift) % 26));
            } else {
                sb.append(c); // Non-letter characters remain unchanged
            }
        }
        // Convert the StringBuilder back to a String and return the encrypted message
        return sb.toString();
    }
}
