import java.util.Vector;

/**
 * Created by Yifan Xiao on 05/01/15.
 */
public class MessageQueue {

    private Vector<Message> queue = new Vector<Message>();
    //init the vector(the message queue)

    public void addMessage(Message newMsg)
    {
        this.queue.add(newMsg);
    }

    //the pop here will just use base class to get rid of two different sub-types
    public Message popMessage(){
        if(isEmpty() || queue ==null)
            return null;
        //if nothign could be returned
        return  queue.remove(0);
        //ge the first one
    }

    public boolean isEmpty()
    {
        if (queue.size() == 0)
            return true;
        else return false;
    }

    //check the first one
    public Message peekMessage(){
        if(isEmpty())
            return null;
        return queue.elementAt(0);
    }

}
