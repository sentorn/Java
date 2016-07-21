package com.sentornCalc;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Calc extends JPanel {

	private JTextField tf;
	private Solutions s;

	public Calc() {
		s = new Solutions();
		Font f = new Font("arial", 25, 25);
		this.setLayout(null);

		tf = new JTextField();
		tf.setBounds(10, 10, 240, 30);
		tf.setFont(new Font("Arial", 0, 20));
		tf.setHorizontalAlignment(JTextField.RIGHT);
		tf.setEditable(false);
		tf.setText("0");
		this.add(tf);

		createButton("del", new Font("arial", 25, 15),
				new Rectangle(250, 10, 55, 29), this, new ButtonListener());
		createButton("7", f, new Rectangle(10, 50, 60, 40), this, new ButtonListener());
		createButton("8", f, new Rectangle(75, 50, 60, 40), this, new ButtonListener());
		createButton("9", f, new Rectangle(140, 50, 60, 40), this, new ButtonListener());
		createButton("4", f, new Rectangle(10, 100, 60, 40), this, new ButtonListener());
		createButton("5", f, new Rectangle(75, 100, 60, 40), this, new ButtonListener());
		createButton("6", f, new Rectangle(140, 100, 60, 40), this, new ButtonListener());
		createButton("1", f, new Rectangle(10, 150, 60, 40), this, new ButtonListener());
		createButton("2", f, new Rectangle(75, 150, 60, 40), this, new ButtonListener());
		createButton("3", f, new Rectangle(140, 150, 60, 40),
				this, new ButtonListener());
		createButton("0", f, new Rectangle(10, 200, 60, 40), this, new ButtonListener());
		createButton(".", f, new Rectangle(75, 200, 60, 40), this, new ButtonListener());
		createButton("=", f, new Rectangle(140, 200, 60, 40),
				this, new ButtonListener());
		createButton("C", f, new Rectangle(205, 50, 100, 40),
				this, new ButtonListener());
		createButton("+", f, new Rectangle(205, 100, 50, 40),
				this, new ButtonListener());
		createButton("-", f, new Rectangle(255, 100, 50, 40),
				this, new ButtonListener());
		createButton("*", f, new Rectangle(205, 150, 50, 40),
				this, new ButtonListener());
		createButton("/", f, new Rectangle(255, 150, 50, 40),
				this, new ButtonListener());
		createButton("(", f, new Rectangle(205, 200, 50, 40),
				this, new ButtonListener());
		createButton(")", f, new Rectangle(255, 200, 50, 40),
				this, new ButtonListener());

	}

	JButton createButton(String name, Font f, Rectangle r, JPanel p, ActionListener a) {
		JButton b = new JButton(name);
		b.setFont(f);
		b.setBounds(r);
		b.addActionListener(a);
		p.add(b);
		return b;
	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			String text = b.getText();
			if (text.equals("C")) {
				tf.setText("0");
			}
			if (text.equals("del")) {
				tf.setText(s.removeLastChar(tf.getText()));
			}
			if (text.equals("=")) {
				tf.setText(s.mainMethod(tf.getText()));
			}
			if (text.equals(".")) {
				tf.setText(s.inputDot(tf.getText()));
			}
			if (text.equals("(")) {
				tf.setText(s.inputOpenBracket(tf.getText()));
			}
			if (text.equals(")")) {
				tf.setText(s.inputCloseBracket(tf.getText()));
			}
			if (Character.isDigit(text.charAt(0))) {
				tf.setText(s.inputDigit(tf.getText(), text));
			}
			if (text.equals("-")) {
				tf.setText(s.inputMinusOperator(tf.getText()));
			}
			if (text.equals("+") || text.equals("*") || text.equals("/")) {
				tf.setText(s.inputOtherOperators(tf.getText(), text));
			}
		}
	}
}
