package chain_of_responsibility;

public class ContactRequestHandler extends FeedbackHandler {

    @Override
    public void handle(Message message) {
        if (message.getType() == MessageType.CONTACT_REQUEST) {
            System.out.println("Contact Request Handler is processing the message: " + message.getContent());
            System.out.println("Forwarding message to the appropriate department.");
        } else if (getNextFeedbackHandler() != null) {
            System.out.println("Contact Request Handler cannot handle this message, passing to next handler...");
            getNextFeedbackHandler().handle(message);
        } else {
            System.out.println("No handler found for message: " + message.getContent());
        }
    }
}
