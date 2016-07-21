package sentorn.conv;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Converter extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel l1;
	private JLabel l2;
	private JLabel l3;
	private JLabel l4;
	private JTextArea tf;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	private JButton b6;
	private JButton b7;
	private JButton b8;
	private JButton b9;
	private JButton b10;
	private JButton b11;
	private JButton b12;
	private JButton b13;
	private JButton b14;
	private JButton b15;
	private JButton b16;
	private JButton b17;
	private JButton b18;
	private JButton b19;
	private JButton b20;
	private JButton b21;
	private Solutions s;

	public Converter() {
		super("The Code Converter");

		s = new Solutions();

		setLayout(null);
		tf = new JTextArea();
		tf.setLineWrap(true);
		tf.setFont(new Font("arial", 0, 22));
		JScrollPane sp = new JScrollPane(tf);
		sp.setBounds(20, 2, 241, 32);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		tf.setEditable(false);
		add(sp);

		b1 = new JButton("CE");
		b1.setBounds(262, 2, 50, 32);
		add(b1);
		l1 = new JLabel("%");
		l1.setFont(new Font("arial", 0, 15));
		l1.setBounds(5, 8, 20, 20);
		add(l1);
		l1.setVisible(false);
		l2 = new JLabel("0");
		l2.setFont(new Font("arial", 0, 15));
		l2.setBounds(5, 8, 20, 20);
		add(l2);
		l2.setVisible(false);
		l3 = new JLabel("d");
		l3.setFont(new Font("arial", 0, 15));
		l3.setBounds(5, 8, 20, 20);
		add(l3);
		l3.setVisible(false);
		l4 = new JLabel("$");
		l4.setFont(new Font("arial", 0, 15));
		l4.setBounds(5, 8, 20, 20);
		add(l4);
		l4.setVisible(false);

		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4, 3));
		p.setBounds(2, 35, 310, 237);

		b2 = new JButton("0");
		p.add(b2);
		b3 = new JButton("1");
		p.add(b3);
		b4 = new JButton("2");
		p.add(b4);
		b5 = new JButton("3");
		p.add(b5);
		b6 = new JButton("4");
		p.add(b6);
		b7 = new JButton("5");
		p.add(b7);
		b8 = new JButton("6");
		p.add(b8);
		b9 = new JButton("7");
		p.add(b9);
		b10 = new JButton("8");
		p.add(b10);
		b11 = new JButton("9");
		p.add(b11);
		b12 = new JButton("A");
		p.add(b12);
		b13 = new JButton("B");
		p.add(b13);
		b14 = new JButton("C");
		p.add(b14);
		b15 = new JButton("D");
		p.add(b15);
		b16 = new JButton("E");
		p.add(b16);
		b17 = new JButton("F");
		p.add(b17);
		b18 = new JButton("A2");
		p.add(b18);
		b19 = new JButton("A8");
		p.add(b19);
		b20 = new JButton("A10");
		p.add(b20);
		b21 = new JButton("A16");
		p.add(b21);

		add(p);
		setSize(320, 300);
		setDefaultCloseOperation(Converter.DISPOSE_ON_CLOSE);
		setLocation(400, 200);
		setResizable(false);
		setVisible(true);

		b1.addActionListener(new ButtonListener());
		b2.addActionListener(new ButtonListener());
		b3.addActionListener(new ButtonListener());
		b4.addActionListener(new ButtonListener());
		b5.addActionListener(new ButtonListener());
		b6.addActionListener(new ButtonListener());
		b7.addActionListener(new ButtonListener());
		b8.addActionListener(new ButtonListener());
		b9.addActionListener(new ButtonListener());
		b10.addActionListener(new ButtonListener());
		b11.addActionListener(new ButtonListener());
		b12.addActionListener(new ButtonListener());
		b13.addActionListener(new ButtonListener());
		b14.addActionListener(new ButtonListener());
		b15.addActionListener(new ButtonListener());
		b16.addActionListener(new ButtonListener());
		b17.addActionListener(new ButtonListener());
		b18.addActionListener(new ButtonListener());
		b19.addActionListener(new ButtonListener());
		b20.addActionListener(new ButtonListener());
		b21.addActionListener(new ButtonListener());

		activ10();
	}

	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			String text = button.getText();
			if (!text.equals("CE") && !text.equals("A2") && !text.equals("A8")
					&& !text.equals("A16") && !text.equals("A10")
					&& !text.equals("0")) {
				tf.setText(tf.getText() + text);
			}
			if (text.equals("0")) {
				if (tf.getText().equals("")) {
					tf.setText("");
				} else {
					tf.setText(tf.getText() + text);
				}
			}
			if (text.equals("CE")) {
				tf.setText("");
			}
			if (text.equals("A2")) {
				activ2();
			}
			if (text.equals("A8")) {
				activ8();
			}
			if (text.equals("A10")) {
				activ10();
			}
			if (text.equals("A16")) {
				activ16();
			}

		}

	}

	void activ2() {
		if (l2.isVisible()) {
			tf.setText(s.eightToTwo(tf.getText()));
		}
		if (l3.isVisible()) {
			tf.setText(s.tenToTwo(tf.getText()));
		}
		if (l4.isVisible()) {
			tf.setText(s.sixteenToTwo(tf.getText()));
		}
		b2.setEnabled(true);
		b3.setEnabled(true);
		b4.setEnabled(false);
		b5.setEnabled(false);
		b6.setEnabled(false);
		b7.setEnabled(false);
		b8.setEnabled(false);
		b9.setEnabled(false);
		b10.setEnabled(false);
		b11.setEnabled(false);
		b12.setEnabled(false);
		b13.setEnabled(false);
		b14.setEnabled(false);
		b15.setEnabled(false);
		b16.setEnabled(false);
		b17.setEnabled(false);
		b18.setEnabled(false);
		b19.setEnabled(true);
		b20.setEnabled(true);
		b21.setEnabled(true);
		l1.setVisible(true);
		l2.setVisible(false);
		l3.setVisible(false);
		l4.setVisible(false);
	}

	void activ8() {
		if (l1.isVisible()) {
			tf.setText(s.twoToEight(tf.getText()));
		}
		if (l3.isVisible()) {
			tf.setText(s.tenToEight(tf.getText()));
		}
		if (l4.isVisible()) {
			tf.setText(s.sixteenToEight(tf.getText()));
		}
		b2.setEnabled(true);
		b3.setEnabled(true);
		b4.setEnabled(true);
		b5.setEnabled(true);
		b6.setEnabled(true);
		b7.setEnabled(true);
		b8.setEnabled(true);
		b9.setEnabled(true);
		b10.setEnabled(false);
		b11.setEnabled(false);
		b12.setEnabled(false);
		b13.setEnabled(false);
		b14.setEnabled(false);
		b15.setEnabled(false);
		b16.setEnabled(false);
		b17.setEnabled(false);
		b18.setEnabled(true);
		b19.setEnabled(false);
		b20.setEnabled(true);
		b21.setEnabled(true);
		l1.setVisible(false);
		l2.setVisible(true);
		l3.setVisible(false);
		l4.setVisible(false);
	}

	void activ10() {
		if (l1.isVisible()) {
			tf.setText(s.twoToTen(tf.getText()));
		}
		if (l2.isVisible()) {
			tf.setText(s.eightToTen(tf.getText()));
		}
		if (l4.isVisible()) {
			tf.setText(s.sixteenToTen(tf.getText()));
		}
		b2.setEnabled(true);
		b3.setEnabled(true);
		b4.setEnabled(true);
		b5.setEnabled(true);
		b6.setEnabled(true);
		b7.setEnabled(true);
		b8.setEnabled(true);
		b9.setEnabled(true);
		b10.setEnabled(true);
		b11.setEnabled(true);
		b12.setEnabled(false);
		b13.setEnabled(false);
		b14.setEnabled(false);
		b15.setEnabled(false);
		b16.setEnabled(false);
		b17.setEnabled(false);
		b18.setEnabled(true);
		b19.setEnabled(true);
		b20.setEnabled(false);
		b21.setEnabled(true);
		l1.setVisible(false);
		l2.setVisible(false);
		l3.setVisible(true);
		l4.setVisible(false);
	}

	void activ16() {
		if (l1.isVisible()) {
			tf.setText(s.twoToSixteen(tf.getText()));
		}
		if (l2.isVisible()) {
			tf.setText(s.eightToSixteen(tf.getText()));
		}
		if (l3.isVisible()) {
			tf.setText(s.tenToSixteen(tf.getText()));
		}
		b2.setEnabled(true);
		b3.setEnabled(true);
		b4.setEnabled(true);
		b5.setEnabled(true);
		b6.setEnabled(true);
		b7.setEnabled(true);
		b8.setEnabled(true);
		b9.setEnabled(true);
		b10.setEnabled(true);
		b11.setEnabled(true);
		b12.setEnabled(true);
		b13.setEnabled(true);
		b14.setEnabled(true);
		b15.setEnabled(true);
		b16.setEnabled(true);
		b17.setEnabled(true);
		b18.setEnabled(true);
		b19.setEnabled(true);
		b20.setEnabled(true);
		b21.setEnabled(false);
		l1.setVisible(false);
		l2.setVisible(false);
		l3.setVisible(false);
		l4.setVisible(true);
	}

}
