package proxy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


// Singleton class responsible for managing user access rights
public class AccessControlService {
    // Singleton instance
    private static AccessControlService instance;

    // Stores permissions: key = username, value = set of document IDs the user can access
    private HashMap<String, Set<String>> permissions;

    // // Constructor is private so another instance can't be created
    private AccessControlService() {
        permissions = new HashMap<>();
    }

    // Returns the singleton instance of AccessControlService
    public static AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    // Grants access for a user to a specific document
    public void grantAccess(String username, String documentId) {
        permissions.computeIfAbsent(username, k -> new HashSet<>()).add(documentId);
    }

    // Checks if a user is allowed to access a specific document
    public boolean isAllowed(String documentId, String username) {
        return permissions.containsKey(username) && permissions.get(username).contains(documentId);
    }
}
