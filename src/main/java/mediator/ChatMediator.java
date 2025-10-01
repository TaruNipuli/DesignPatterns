package mediator;

import java.util.HashMap;
import java.util.Map;

// Mediator that manages communication between chat clients.
// All messages and updates go through this mediator.
public class ChatMediator {
    // Map of all registered clients
    // Key: the username of a chat client
    // Value: the ChatClientController that manages that user's chat window
    private Map<String, ChatClientController> clients = new HashMap<>();

    // Register a new client
    public void registerClient(String username, ChatClientController client) {
        clients.put(username, client);
        updateRecipients(); // update all recipient lists
    }

    // Send a message from one client to another
    public void sendMessage(String from, String to, String message) {
        ChatClientController recipient = clients.get(to); // mediator looks up recipient
        if (recipient != null) {
            recipient.receiveMessage(from, message); // mediator delivers the message
        }
    }

    // Refresh recipient dropdowns in all clients
    private void updateRecipients() {
        for (ChatClientController client : clients.values()) {
            client.updateRecipientList(clients.keySet());
        }
    }
}