package chain_of_responsibility;


public class CompensationHandler extends FeedbackHandler {

    // Handle the message or pass it to the next handler
    @Override
    public void handle(Message message) {
        // Check if this handler can process the message
        if (message.getType() == MessageType.COMPENSATION_CLAIM) {
            System.out.println("Compensation Handler is processing the message: " + message.getContent());
            System.out.println("Message sent to email: " + message.getSenderEmail());
        }
        // If this handler cannot process the message, pass it to the next handler in the chain
        else if (getNextFeedbackHandler() != null) {
            System.out.println("Compensation Handler cannot handle this message, passing to next handler...");
            getNextFeedbackHandler().handle(message);
        }
        // If no handler can process the message
        else {
            System.out.println("No handler found for message: " + message.getContent());
        }
    }
}
