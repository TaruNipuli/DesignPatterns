package mediator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Set;

// Controller for a single chat client window.
public class ChatClientController {
    private String username;          // name of client
    private ChatMediator mediator;    // reference to mediator

    // GUI components
    private TextArea chatArea;        // shows chat history
    private TextField messageField;   // input field for messages
    private ComboBox<String> recipientBox; // dropdown for recipients

    public ChatClientController(String username, ChatMediator mediator) {
        this.username = username;
        this.mediator = mediator;
        createUI();
        mediator.registerClient(username, this);
    }

    // Build the GUI window
    private void createUI() {
        Stage stage = new Stage();
        stage.setTitle("Chat - " + username);

        chatArea = new TextArea();
        chatArea.setEditable(false); // user can only read, not edit text area

        messageField = new TextField();
        messageField.setPromptText("Type your message here...");

        recipientBox = new ComboBox<>();
        recipientBox.setPromptText("Select recipient");

        // Send button action
        Button sendButton = new Button("Send");
        sendButton.setOnAction(e -> {
            String msg = messageField.getText();
            String to = recipientBox.getValue();
            // Only send if message and recipient are valid
            if (msg != null && !msg.isEmpty() && to != null) {
                mediator.sendMessage(username, to, msg);
                chatArea.appendText("You to " + to + ": " + msg + "\n");
                messageField.clear();
            }
        });

        VBox root = new VBox(10, chatArea, recipientBox, messageField, sendButton);
        stage.setScene(new Scene(root, 400, 300));
        stage.show();
    }

    // Called by mediator when another client sends a message
    public void receiveMessage(String from, String message) {
        chatArea.appendText(from + " to you: " + message + "\n");
    }

    // Update recipient dropdown when clients change
    public void updateRecipientList(Set<String> usernames) {
        if (recipientBox == null) return;
        ObservableList<String> list = FXCollections.observableArrayList(usernames);
        list.remove(username); // cannot send message to yourself
        recipientBox.setItems(list);
    }
}
