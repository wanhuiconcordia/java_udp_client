import java.io.Serializable;
public abstract class Message implements Serializable{
	public int seq;
	public Action action;
	public String sender;
	public String senderIP;
	public int senderPort;
	boolean needAck;
}
