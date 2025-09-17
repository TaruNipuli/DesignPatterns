package proxy;

import java.util.HashMap;

// Library class stores all documents
public class Library {

    // The key is the document's ID, value is a Document, which can be RealDocument or DocumentProxy
    private HashMap<String, Document> documents;

    public Library() {
        documents = new HashMap<>();
    }

    // Create a protected document
    private Document createProtectedDocument(String id, String creationDate, String content, String[] allowedUsers) {
        RealDocument realDoc = new RealDocument(id, creationDate, content);
        DocumentProxy proxy = new DocumentProxy(realDoc);

        // Grant access for allowed users using the singleton AccessControlService
        AccessControlService acs = AccessControlService.getInstance();
        for (String user : allowedUsers) {
            acs.grantAccess(user, id);
        }

        return proxy;
    }

    // Adds unprotected document to the library
    public void addUnprotectedDocument(String id, String creationDate, String content) {
        RealDocument doc = new RealDocument(id, creationDate, content);
        documents.put(id, doc);
    }

    // Adds protected document to the library using the factory method
    public void addProtectedDocument(String id, String creationDate, String content, String... allowedUsers) {
        Document proxy = createProtectedDocument(id, creationDate, content, allowedUsers);
        documents.put(id, proxy);
    }

    // Retrieves document by its ID
    public Document getDocument(String id) {
        return documents.get(id);
    }
}
