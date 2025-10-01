package mediator;

import javafx.application.Application;
import javafx.stage.Stage;

public class ChatApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        ChatMediator mediator = new ChatMediator(); // one mediator for all

        // Create three clients
        new ChatClientController("Alice", mediator);
        new ChatClientController("Bob", mediator);
        new ChatClientController("Charlie", mediator);
    }
}
