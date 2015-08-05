public class RetailerFEGetCatelogMessage extends Message {
	
	public RetailerFEGetCatelogMessage(int seq, String sender, String senderIP, int senderPort){
		this.seq = seq;
		action = Action.getCatelog;
		this.sender = sender;
		this.senderIP = senderIP;
		this.senderPort = senderPort;
		needAck = true;
	}
	
	public String toString(){
		return "" + seq + ", " + action + ", " + sender  + ", " + senderIP + ", " + senderPort + ", " + needAck;  
	}
}
