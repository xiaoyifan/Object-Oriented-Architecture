import java.io.IOException;

/**
 * Created by Yifan Xiao on 05/01/15.
 */
public class Driver {
    protected static MessageQueue queue = new MessageQueue();
    protected static Responder responder = new Responder(queue);
    protected static int startIdentifier = 0;

    public static void main(String[] args) throws IOException {

        initTestWithRequest(); // populating value into testQueue

        while(queue.isEmpty() == false) {
            Message msg = queue.peekMessage();
            if (msg.getHeader().equals("request"))
            {
                msg.print();
            }

            responder.processQueue(responder.getQueue());
        }
        //Log out all the messages in the queue
    }

    // init requests
    private static void initTestWithRequest() {
        responder.addRequest(new QueryMsg("six", startIdentifier++));
        responder.addRequest(new QueryMsg("zero", startIdentifier++));
        responder.addRequest(new QueryMsg("six", startIdentifier++));
        responder.addRequest(new QueryMsg("one", startIdentifier++));
        responder.addRequest(new QueryMsg("five", startIdentifier++));
    }

}
