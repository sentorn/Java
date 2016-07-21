package com.sentornCompany;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class RemovePanel extends JPanel {

	private JTextField tf;
	private JLabel err1;
	private JLabel err2;
	private Creator c = new Creator();
	private Solutions s;
	public RemovePanel(Solutions s) {
		this.s = s;
		this.setLayout(null);
		c.createLabel("Input last name:", c.getF1(), new Rectangle(90, 70, 200,
				30), this);
		err1 = c.createErrorLabel("Can't be empty", c.getF2(), new Rectangle(
				170, 100, 200, 20), this);
		err2 = c.createErrorLabel("Employee doesn't exist", c.getF2(),
				new Rectangle(120, 100, 200, 20), this);
		tf = c.createTextField(c.getF2(), new Rectangle(70, 120, 200, 25), this);
		err1.setVisible(false);
		err2.setVisible(false);
	}

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(c.getImage(), 0, 0, getWidth(), getHeight(), null);
	}

	void clearPanel() {
		if (!tf.getText().equals("")) {
			tf.setText("");
		}
		err1.setVisible(false);
		err2.setVisible(false);
	}
	
	boolean checkField() {
		boolean res = false;
		if (tf.getText().equals("")) {
			err1.setVisible(true);
			err2.setVisible(false);
		}
		if (!tf.getText().equals("") && !s.employeeExist(tf.getText())) {
			err2.setVisible(true);
			err1.setVisible(false);
			tf.setText("");
		}
		if (!tf.getText().equals("") && s.employeeExist(tf.getText())) {
			res = true;
			s.removeEmployee(tf.getText());
			clearPanel();
		}
		return res;
	}

}
