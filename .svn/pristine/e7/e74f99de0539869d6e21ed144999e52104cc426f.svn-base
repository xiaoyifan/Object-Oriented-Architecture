/**
 * Created by Yifan Xiao on 05/01/15.
 */
public class ReplyMsg extends Message {

    private String body;
    private int id;

    public ReplyMsg(String body, int id) {
        this.body = body;
        this.id = id;
    }

    public String getHeader()
    {
        return "reply";
    }

    public String getBody()
    {
        return this.body;
    }

    public int getID()
    {
        return this.id;
    }
    public void print()
    {
        System.out.printf("Identifier-- %d,Message header: %s, Body: %s.\n", this.id, "reply", this.body);
    }

}
