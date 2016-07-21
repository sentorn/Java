package com.sentornCompany;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class RegistrationPanel extends JPanel {

	private JLabel err1;
	private JLabel err2;
	private JLabel err3;
	private JTextField login;
	private JPasswordField pass1;
	private JPasswordField pass2;
	private Creator c = new Creator();
	private Solutions s;

	public RegistrationPanel(Solutions s) {
		this.s = s;
		this.setLayout(null);

		c.createLabel("Registration", new Font("arial", 0, 30), new Rectangle(
				85, 20, 300, 50), this);
		c.createLabel("Input login:", c.getF1(),
				new Rectangle(75, 100, 100, 25), this);
		c.createLabel("Input password:", c.getF1(), new Rectangle(30, 155, 150,
				25), this);
		c.createLabel("Repeat password:", c.getF1(), new Rectangle(10, 200,
				170, 25), this);
		login = c.createTextField(c.getF2(), new Rectangle(180, 100, 150, 25),
				this);
		pass1 = c.createPasswordField(c.getF2(), new Rectangle(180, 155, 150,
				25), this);
		pass2 = c.createPasswordField(c.getF2(), new Rectangle(180, 200, 150,
				25), this);
		err1 = c.createErrorLabel(
				"Must contains min 1 uppercase letter and 1 digit", c.getF2(),
				new Rectangle(20, 130, 340, 20), this);
		err2 = c.createErrorLabel("Passwords do not match", c.getF2(),
				new Rectangle(170, 130, 170, 20), this);
		err3 = c.createErrorLabel("Fields can't be empty", c.getF2(),
				new Rectangle(110, 75, 220, 20), this);
		err1.setVisible(false);
		err2.setVisible(false);
		err3.setVisible(false);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(c.getImage(), 0, 0, getWidth(), getHeight(), null);
	}

	@SuppressWarnings("deprecation")
	void clearPanel() {
		if (!login.getText().equals("")) {
			login.setText("");
		}
		if (!pass1.getText().equals("")) {
			pass1.setText("");
		}
		if (!pass2.getText().equals("")) {
			pass2.setText("");
		}
		err1.setVisible(false);
		err2.setVisible(false);
		err3.setVisible(false);
	}

	@SuppressWarnings("deprecation")
	boolean checkInputs() {
		boolean res = false;
		if (login.getText().equals("") || pass1.getText().equals("")
				|| pass2.getText().equals("")) {
			err3.setVisible(true);
			err1.setVisible(false);
			err2.setVisible(false);
			
		}
		if (!s.rightPassword(pass1.getText()) && !login.getText().equals("") &&
				!pass1.getText().equals("") && !pass2.getText().equals("")) {
			pass1.setText("");
			err1.setVisible(true);
			err2.setVisible(false);
			err3.setVisible(false);
		}
		if (s.rightPassword(pass1.getText())
				&& !pass1.getText().equals(pass2.getText()) && !login.getText().equals("") &&
				!pass1.getText().equals("") && !pass2.getText().equals("")) {
			pass2.setText("");
			err2.setVisible(true);
			err1.setVisible(false);
			err3.setVisible(false);
		}
		if (s.rightPassword(pass1.getText()) && pass1.getText().equals(pass2.getText())
				&& !login.getText().equals("")) {
			res = true;
			s.saveUser(login.getText(), pass1.getText());
			clearPanel();
		}
		return res;
	}

}
