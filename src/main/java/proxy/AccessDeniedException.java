package proxy;

// Custom exception for denied access to protected documents
public class AccessDeniedException extends Exception {
    public AccessDeniedException(String message) {
        super(message);
    }
}
