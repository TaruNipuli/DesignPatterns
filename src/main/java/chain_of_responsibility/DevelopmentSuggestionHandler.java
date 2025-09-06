package chain_of_responsibility;

public class DevelopmentSuggestionHandler extends FeedbackHandler {

    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.DEVELOPMENT_SUGGESTION) {
            System.out.println("Development Suggestion Handler is processing the message: " + message.getContent());
            System.out.println("Logging and prioritizing the suggestion.");
        } else if (getNextFeedbackHandler() != null) {
            System.out.println("Development Suggestion Handler cannot handle this message, passing to next handler...");
            getNextFeedbackHandler().handle(message);
        } else {
            System.out.println("No handler found for message: " + message.getContent());
        }
    }
}
