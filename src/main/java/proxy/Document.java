package proxy;

// Document interface defines common operations for all documents
public interface Document {
    String getId();
    String getContent(User user) throws AccessDeniedException; // Throws AccessDeniedException if user isn't allowed to access
    String getCreationDate();
}
