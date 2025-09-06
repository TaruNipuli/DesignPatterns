package chain_of_responsibility;

public abstract class FeedbackHandler {

    private FeedbackHandler nextFeedbackHandler;

    public void setNextFeedbackHandler(FeedbackHandler nextFeedbackHandler) {
        this.nextFeedbackHandler = nextFeedbackHandler;
    }

    public FeedbackHandler getNextFeedbackHandler() {
        return nextFeedbackHandler;
    }

    public abstract void handle(Message message);

}
