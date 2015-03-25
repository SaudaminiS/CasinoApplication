
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SockServer {
	private ServerSocket serverSocket;
	private int port;

	public SockServer(int port) {
		this.port = port;
	}

	public void start() throws IOException {
		System.out.println("Starting the socket server at port:" + port);
		serverSocket = new ServerSocket(port);

		System.out.println("Waiting for clients...");
		Socket client = serverSocket.accept();

		sendMessage(client);
	}

	private void sendMessage(Socket client) throws IOException {
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
				client.getOutputStream()));
		writer.write("Hello. You are connected to a Simple Socket Server. What is your name?");
		writer.flush();
		writer.close();
	}

	public static void main(String[] args) {

		int portNumber = 9990;
		try {
			SockServer socketServer = new SockServer(portNumber);
			socketServer.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
