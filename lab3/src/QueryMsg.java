/**
 * Created by Yifan Xiao on 05/01/15.
 */
public class QueryMsg extends Message {

    private String body;
    private int id;

    //constructor
    public QueryMsg(String body, int id) {
        this.body = body;
        this.id = id;
    }


    //getters
    public String getHeader()
    {
        return "request";
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
        System.out.printf("Identifier-- %d,Message header: %s, Body: %s.\n", this.id, "request", this.body);
    }

}
