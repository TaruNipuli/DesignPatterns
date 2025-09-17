package proxy;

public class Main {
    public static void main(String[] args) {

        // Create Users
        User user1 = new User("Alice");
        User user2 = new User("Bob");
        User user3 = new User("Charlie");

        // Create Library and add documents
        Library library = new Library();
        library.addUnprotectedDocument("document1", "2025-09-17", "Public content 1");
        library.addUnprotectedDocument("document2", "2025-09-18", "Public content 2");

        library.addProtectedDocument("document3", "2025-09-19", "Secret content 3", "Alice", "Charlie");
        library.addProtectedDocument("document4", "2025-09-20", "Secret content 4", "Bob");

        // Lists of users and document IDs
        User[] users = {user1, user2, user3};
        String[] docIds = {"document1", "document2", "document3", "document4"};

        // Test access using for each loops
        for (User user : users) {
            System.out.println("Testing access for user: " + user.getUsername());
            for (String docId : docIds) {
                Document doc = library.getDocument(docId);
                try {
                    // Attempt to access document content
                    String content = doc.getContent(user);
                    System.out.println("  " + docId + " content: " + content);
                } catch (AccessDeniedException e) {
                    // Handle access denial
                    System.out.println("  " + docId + " access denied");
                }
            }
            System.out.println("--------------------------");
        }
    }
}
