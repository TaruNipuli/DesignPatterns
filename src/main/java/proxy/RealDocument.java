package proxy;

// Actual document with an ID, creation date, and content, doesn't perform any access control
public class RealDocument implements Document {
    private String id;
    private String creationDate;
    private String content;

    public RealDocument(String id, String creationDate, String content) {
        this.id = id;
        this.creationDate = creationDate;
        this.content = content;
    }

    // Returns document's ID
    public String getId() {
        return id;
    }

    // Returns document's creation date
    public String getCreationDate() {
        return creationDate;
    }

    // Returns document's content
    public String getContent(User user) {
        return content;
    }
}
