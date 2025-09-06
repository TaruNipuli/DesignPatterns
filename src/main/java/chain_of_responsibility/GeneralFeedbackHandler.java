package chain_of_responsibility;

public class GeneralFeedbackHandler extends FeedbackHandler {

    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.GENERAL_FEEDBACK) {
            System.out.println("General Feedback Handler is processing the message: " + message.getContent());
            System.out.println("Analyzing and responding to general feedback.");
        } else if (getNextFeedbackHandler() != null) {
            System.out.println("General Feedback Handler cannot handle this message, passing to next handler...");
            getNextFeedbackHandler().handle(message);
        } else {
            System.out.println("No handler found for message: " + message.getContent());
        }
    }
}
