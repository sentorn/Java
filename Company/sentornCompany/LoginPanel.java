package com.sentornCompany;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class LoginPanel extends JPanel {

	private JLabel exeption;
	private JTextField tf1;
	private JPasswordField tf2;
	private Solutions s;
	private Creator c = new Creator();

	public LoginPanel(Solutions s) {
		this.s = s;
		this.setLayout(null);
		c.createLabel("Login:", c.getF1(), new Rectangle(70, 100, 60, 30), this);
		c.createLabel("Password:", c.getF1(), new Rectangle(30, 150, 100, 30),
				this);
		exeption = c.createErrorLabel("Wrong login or password", c.getF1(),
				new Rectangle(60, 30, 250, 40), this);
		tf1 = c.createTextField(c.getF2(), new Rectangle(150, 105, 150, 25),
				this);
		tf2 = c.createPasswordField(c.getF2(),
				new Rectangle(150, 155, 150, 25), this);
		exeption.setVisible(false);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(c.getImage(), 0, 0, getWidth(), getHeight(), null);

	}

	@SuppressWarnings("deprecation")
	boolean checkInputs() {
		boolean res = false;
		if (tf1.getText().equals("") || tf2.getText().equals("")
				|| !s.userExist(new User(tf1.getText(), tf2.getText()))) {
			exeption.setVisible(true);
			if (!tf1.getText().equals("")) {
				tf1.setText("");
			}
			if (!tf2.getText().equals("")) {
				tf2.setText("");
			}
			res = false;
		}
		if (!tf1.getText().equals("") && !tf2.getText().equals("")
				&& s.userExist(new User(tf1.getText(), tf2.getText()))) {

			clearPanel();
			this.setVisible(false);
			res = true;
		}
		return res;
	}

	@SuppressWarnings("deprecation")
	void clearPanel() {
		if (!tf1.getText().equals("")) {
			tf1.setText("");
		}
		if (!tf2.getText().equals("")) {
			tf2.setText("");
		}
		exeption.setVisible(false);
	}

}
