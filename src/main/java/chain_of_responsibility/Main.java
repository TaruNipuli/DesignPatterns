package chain_of_responsibility;

public class Main {

    public static void main(String[] args) {

        // Create handler objects
        CompensationHandler compensationHandler = new CompensationHandler();
        ContactRequestHandler contactHandler = new ContactRequestHandler();
        DevelopmentSuggestionHandler developmentHandler = new DevelopmentSuggestionHandler();
        GeneralFeedbackHandler generalHandler = new GeneralFeedbackHandler();

        // Build the chain: Compensation -> Contact -> Development -> General
        compensationHandler.setNextFeedbackHandler(contactHandler);
        contactHandler.setNextFeedbackHandler(developmentHandler);
        developmentHandler.setNextFeedbackHandler(generalHandler);

        // Create sample messages of different types
        Message msg1 = new Message(MessageType.COMPENSATION_CLAIM, "I want a refund for my order.", "user1@example.com");
        Message msg2 = new Message(MessageType.CONTACT_REQUEST, "I need to talk to support.", "user2@example.com");
        Message msg3 = new Message(MessageType.DEVELOPMENT_SUGGESTION, "Add dark mode to the app.", "user3@example.com");
        Message msg4 = new Message(MessageType.GENERAL_FEEDBACK, "Great service, keep it up!", "user4@example.com");

        // Send messages to the chain for handling
        compensationHandler.handle(msg1);
        compensationHandler.handle(msg2);
        compensationHandler.handle(msg3);
        compensationHandler.handle(msg4);
    }
}
