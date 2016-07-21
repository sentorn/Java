package sentorn.chat1;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.DefaultCaret;

public class ServerChat extends JFrame {

	private static final long serialVersionUID = 1L;
	private Socket socket;
	private PrintWriter pw;
	private JTextArea ta;
	private ArrayList<PrintWriter> pwList;

	public ServerChat() {

		super("Server");

		pwList = new ArrayList<PrintWriter>();

		JPanel p = new JPanel();
		p.setLayout(null);

		ta = new JTextArea();
		ta.setLineWrap(true);
		ta.setEditable(false);
		DefaultCaret caret = (DefaultCaret) ta.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		JScrollPane sp = new JScrollPane(ta);
		sp.setBounds(5, 5, 485, 460);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		p.add(sp);
		add(p);

		setSize(500, 500);
		setLocation(100, 150);
		setResizable(false);
		setDefaultCloseOperation(ServerChat.EXIT_ON_CLOSE);
		setVisible(true);

		go();
	}

	void go() {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(5000);
			ta.append("Waiting for connection!" + "\n");
			while (true) {
				socket = ss.accept();
				ta.append("Addr: "
						+ String.valueOf(socket.getInetAddress()).substring(1)
						+ ", port: " + socket.getPort() + " is connected"
						+ "\n");
				pw = new PrintWriter(socket.getOutputStream());
				pwList.add(pw);
				new ServerThread(socket).start();
			}
		} catch (SocketException s) {
			s.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ss != null) {
				try {
					ss.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	class ServerThread extends Thread {

		Socket socket;
		BufferedReader br;

		public ServerThread(Socket sock) {
			socket = sock;
			try {
				br = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void run() {
			String line = null;

			try {

				while ((line = br.readLine()) != null) {
					ta.append("get message from client " + line + "\n");
					sendToAll(line);
					ta.append("waiting for next message..." + "\n");
				}

			} catch (IOException e) {
				ta.append("Addr: "
						+ String.valueOf(socket.getInetAddress()).substring(1)
						+ ", port: " + socket.getPort()
						+ " disconnected from server" + "\n");

			}

		}
	}

	void sendToAll(String s) {
		Iterator<PrintWriter> it = pwList.iterator();
		while (it.hasNext()) {
			PrintWriter p = (PrintWriter) it.next();
			p.println(s);
			p.flush();

		}
	}

	public static void main(String[] args) {

		new ServerChat();

	}

}
