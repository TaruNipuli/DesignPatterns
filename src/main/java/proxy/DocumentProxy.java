package proxy;

// Controls access to the document content
public class DocumentProxy implements Document {

    private RealDocument realDocument;

    // Singleton service that checks if user has permission to access
    private AccessControlService accessControlService;

    public DocumentProxy(RealDocument realDocument) {
        this.realDocument = realDocument;
        this.accessControlService = AccessControlService.getInstance();
    }

    // Returns ID of the document
    public String getId() {
        return realDocument.getId();
    }

    // Returns creation date of the document
    public String getCreationDate() {
        return realDocument.getCreationDate();
    }

    // Returns content of the document if the user has access or throws AccessDeniedException if user isn't allowed
    public String getContent(User user) throws AccessDeniedException {
        if (accessControlService.isAllowed(realDocument.getId(), user.getUsername())) {
            return realDocument.getContent(user);
        } else {
            throw new AccessDeniedException(
                    "User not allowed to access document: " + realDocument.getId()
            );
        }
    }
}
