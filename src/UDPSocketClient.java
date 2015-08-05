import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;
public class UDPSocketClient {
    DatagramSocket Socket;
    public UDPSocketClient() {
    }
    public void createAndListenSocket() {
        try {
            Socket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName("10.0.0.93");
            byte[] incomingData = new byte[1024];
//            Student student = new Student(1, "Bijoy", "Kerala");
            Message msg = new RetailerFEGetCatelogMessage(1, "testSender", "10.0.0.139", 9876);
            System.out.print("will send:" + msg.toString());
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(outputStream);
            
            
            os.writeObject(msg);
            byte[] data = outputStream.toByteArray();
            DatagramPacket sendPacket = new DatagramPacket(data, data.length, IPAddress, 9876);
            Socket.send(sendPacket);
            System.out.println("Message sent from client");
            DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);
            Socket.receive(incomingPacket);
            String response = new String(incomingPacket.getData());
            System.out.println("Response from server:" + response);
            Thread.sleep(2000);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        UDPSocketClient client = new UDPSocketClient();
        client.createAndListenSocket();
    }
}


