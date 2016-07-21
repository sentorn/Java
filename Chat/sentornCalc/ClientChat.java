package sentorn.chat1;

import java.awt.Color;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.text.DefaultCaret;

public class ClientChat extends JFrame {

	private static final long serialVersionUID = 1L;
	private Socket socket;
	private JTextArea ta1;
	private JTextArea ta2;
	private PrintWriter pw;
	private BufferedReader br;
	private JTextField tf1;
	private JTextField tf2;
	private JPanel p1;
	private JPanel p2;
	private JLabel err1;
	private JLabel err2;
	private String name;

	public ClientChat() {
		super("Client");

		p1 = new JPanel();
		p1.setLayout(null);
		p2 = new JPanel();
		p2.setLayout(null);

		err1 = new JLabel("Fields can't be empty");
		err1.setBounds(270, 75, 150, 20);
		err1.setForeground(Color.RED);
		err1.setVisible(false);
		err2 = new JLabel("Wrong ip address");
		err2.setBounds(290, 125, 110, 20);
		err2.setForeground(Color.RED);
		err2.setVisible(false);

		tf1 = new JTextField();
		tf2 = new JTextField();
		tf1.setBounds(250, 100, 150, 25);
		tf2.setBounds(250, 150, 150, 25);
		JLabel l1 = new JLabel("Input your nickName:");
		JLabel l2 = new JLabel("Input server IP:");
		l1.setBounds(105, 100, 130, 25);
		l2.setBounds(140, 150, 130, 25);
		JButton con = new JButton("Connect");
		con.setBounds(200, 200, 150, 30);
		p1.add(con);
		p1.add(l1);
		p1.add(l2);
		p1.add(tf1);
		p1.add(tf2);
		p1.add(err1);
		p1.add(err2);
		add(p1);

		ta1 = new JTextArea();
		ta2 = new JTextArea();

		ta1.setLineWrap(true);
		ta2.setLineWrap(true);
		ta1.setEditable(false);
		DefaultCaret caret = (DefaultCaret) ta1.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

		JScrollPane sp1 = new JScrollPane(ta1);
		JScrollPane sp2 = new JScrollPane(ta2);
		sp1.setBounds(5, 5, 485, 400);
		sp1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sp2.setBounds(5, 410, 370, 50);
		sp2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		JButton b = new JButton("Send");
		b.setBounds(380, 410, 110, 49);
		p2.add(sp1);
		p2.add(sp2);
		p2.add(b);

		setSize(500, 500);
		setLocation(700, 150);
		setResizable(false);
		setDefaultCloseOperation(ClientChat.EXIT_ON_CLOSE);
		setVisible(true);

		b.addActionListener(new ButtonListener());
		con.addActionListener(new ButtonListener());

	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			JButton b = (JButton) e.getSource();
			String text = b.getText();
			if (text.equals("Send")) {
				pw.println(name + ": " + ta2.getText());
				pw.flush();
				ta2.setText("");
				ta2.requestFocus();
			}
			if (text.equals("Connect")) {
				if (tf1.getText().equals("") || tf2.getText().equals("")) {
					err1.setVisible(true);
					err2.setVisible(false);
				}
				if (!tf1.getText().equals("") && !tf2.getText().equals("")
						&& !checkIp(tf2.getText())) {
					err1.setVisible(false);
					err2.setVisible(true);
					tf2.setText("");
				}
				if (!tf1.getText().equals("") && !tf2.getText().equals("")
						&& checkIp(tf2.getText())) {
					p1.setVisible(false);
					add(p2);
					setTitle(tf1.getText());
					go();

				}
			}
		}
	}

	void go() {

		try {
			socket = new Socket(tf2.getText(), 5000);
			name = tf1.getText();
			br = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream());
			new ClientThread().start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			try {
				socket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	class ClientThread extends Thread {

		public void run() {
			String message = null;
			try {
				while ((message = br.readLine()) != null) {
					ta1.append(message + "\n");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	boolean checkIp(String s) {
		boolean res = true;
		if (!s.equals("localhost")) {
			for (int i = 0; i < s.length(); i++) {
				if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != '.') {
					res = false;
					i = s.length();
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {

		new ClientChat();

	}

}
