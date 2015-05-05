import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;
import static java.lang.System.out;

public class Client extends JFrame{
	String uname;
	PrintWriter pw;
	BufferedReader br;
	JLabel welcomeMessage;
	JTextArea taMessages;
	JTextField tfInput;
	JButton pokerGameButton, blackjackGameButton, slotGameButton, btnPoker, btnBlackjack, btnSlots;// btnSend,btnExit;
	Socket client;

	public Client(String uname, String servername) throws Exception {
		super(uname);
		this.uname = uname;
		client = new Socket(servername, 9999);
		br = new BufferedReader(new InputStreamReader(client.getInputStream()));
		pw = new PrintWriter(client.getOutputStream(), true);
		pw.println(uname); 
		buildInterface();
		new MessagesThread().start();
	}

	public void buildInterface() {
		Menu.main(uname);
			
	}

	public static void main(String... args) {

		// take username from user
		String name = JOptionPane.showInputDialog(null, "Enter your name :",
				"Username", JOptionPane.PLAIN_MESSAGE);
		String servername = "localhost";
		try {
			new Client(name, servername);
		} catch (Exception ex) {
			out.println("Error --> " + ex.getMessage());
		}

	} 

	class MessagesThread extends Thread {
		public void run() {
			String line;
			try {
				while (true) {
					line = br.readLine();
					taMessages.append(line + "\n");
				} 
			} catch (Exception ex) {
			}
		}
	}
} 
