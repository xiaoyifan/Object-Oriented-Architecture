
/**
 * Created by Yifan Xiao on 05/01/15.
 */
public class Responder {

    private MessageQueue queue;

    public Responder(MessageQueue queue)
    {
        this.queue = queue;
    }
    //the message queue is included in the responder

    // get the query message from the queue, process it into reply message
    public void processQueue (MessageQueue queue) {
        Message msg = queue.popMessage();

        while(!msg.getHeader().equals("request"))//find the request message
        {
            if(!queue.isEmpty())
                msg = queue.popMessage();
            else
                return;
        }
        String body = msg.getBody(); // get body and convert to int
        ReplyMsg reply = new ReplyMsg(translateToInt(body), msg.getID()); // convert int to Roman to get ReplyMsg
        reply.print();

        this.queue.addMessage(reply);
    }

    // add now client request (QueryMsg into the queue)
    public void addRequest(QueryMsg qMsg)
    {
        this.queue.addMessage(qMsg); // enqueue new query message
    }

    public MessageQueue getQueue()
    {
        return this.queue;
    }

    private String translateToInt(String num) {

        int answer = 0;

        if (num.equals("zero"))
        {
            answer = 0;
        }
        if (num.equals("one"))
        {
            answer = 1;
        }
        else if (num.equals("two"))
        {
            answer = 2;

        }
        else if (num.equals("three"))
        {
            answer = 3;

        }
        else if (num.equals("four"))
        {
            answer = 4;

        }
        else if (num.equals("five"))
        {
            answer = 5;

        }
        else if (num.equals("six"))
        {
            answer = 6;

        }
        else if (num.equals("seven"))
        {
            answer = 7;

        }
        else if (num.equals("eight"))
        {
            answer = 8;

        }
        else if (num.equals("nine"))
        {
            answer = 9;

        }


        return ""+answer;
    }

}
