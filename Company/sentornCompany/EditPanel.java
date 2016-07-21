package com.sentornCompany;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class EditPanel extends JPanel {

	private JTextField nameF;
	private JTextField lastName;
	private JTextField age;
	private JTextField salary;
	private JTextField address;
	private JLabel err1;
	private JLabel err2;
	private JLabel err3;
	private JLabel err4;
	private JLabel err5;
	private JLabel err6;
	private Creator c = new Creator();
	private Solutions s;

	public EditPanel(Solutions s) {
		this.s = s;
		this.setLayout(null);
		c.createLabel("Name:", c.getF1(), new Rectangle(70, 40, 100, 25), this);
		c.createLabel("Last name:", c.getF1(), new Rectangle(30, 90, 100, 25),
				this);
		c.createLabel("Age:", c.getF1(), new Rectangle(85, 140, 100, 25), this);
		c.createLabel("Salary:", c.getF1(), new Rectangle(65, 190, 100, 25),
				this);
		c.createLabel("Address:", c.getF1(), new Rectangle(50, 240, 100, 25),
				this);
		nameF = c.createTextField(c.getF2(), new Rectangle(150, 40, 150, 25),
				this);
		lastName = c.createTextField(c.getF2(),
				new Rectangle(150, 90, 150, 25), this);
		age = c.createTextField(c.getF2(), new Rectangle(150, 140, 150, 25),
				this);
		salary = c.createTextField(c.getF2(), new Rectangle(150, 190, 150, 25),
				this);
		address = c.createTextField(c.getF2(),
				new Rectangle(150, 240, 150, 25), this);
		err1 = c.createErrorLabel("Wrong input name", c.getF2(), new Rectangle(
				180, 15, 150, 20), this);
		err2 = c.createErrorLabel("Wrong input last name", c.getF2(),
				new Rectangle(150, 65, 150, 20), this);
		err3 = c.createErrorLabel("min 16, max 65", c.getF2(), new Rectangle(
				200, 115, 150, 20), this);
		err4 = c.createErrorLabel("Only digits", c.getF2(), new Rectangle(230,
				165, 150, 20), this);
		err5 = c.createErrorLabel("Only digits", c.getF2(), new Rectangle(230,
				115, 150, 20), this);
		err6 = c.createErrorLabel("Fields can't be empty", c.getF2(),
				new Rectangle(160, 15, 150, 20), this);
		err3.setVisible(false);
		err1.setVisible(false);
		err2.setVisible(false);
		err4.setVisible(false);
		err5.setVisible(false);
		err6.setVisible(false);
	}

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(c.getImage(), 0, 0, getWidth(), getHeight(), null);
	}

	void clearPanel() {
		if (!nameF.getText().equals("")) {
			nameF.setText("");
		}
		if (!lastName.getText().equals("")) {
			lastName.setText("");
		}
		if (!age.getText().equals("")) {
			age.setText("");
		}
		if (!salary.getText().equals("")) {
			salary.setText("");
		}
		if (!address.getText().equals("")) {
			address.setText("");
		}
		err1.setVisible(false);
		err2.setVisible(false);
		err3.setVisible(false);
		err4.setVisible(false);
		err5.setVisible(false);
		err6.setVisible(false);
	}

	boolean emptyCheck() {
		boolean res = false;
		if (!nameF.getText().equals("") && !lastName.getText().equals("")
				&& !age.getText().equals("") && !salary.getText().equals("")
				&& !address.getText().equals("")) {
			res = true;
		}
		return res;
	}

	boolean checkFields() {
		boolean res = false;
		if (nameF.getText().equals("") || lastName.getText().equals("")
				|| age.getText().equals("") || salary.getText().equals("")
				|| address.getText().equals("")) {
			err6.setVisible(true);
			err1.setVisible(false);
			err2.setVisible(false);
			err3.setVisible(false);
			err4.setVisible(false);
			err5.setVisible(false);
		}
		if (emptyCheck() && !s.onlyLetters(nameF.getText())) {
			err1.setVisible(true);
			err2.setVisible(false);
			err3.setVisible(false);
			err4.setVisible(false);
			err5.setVisible(false);
			err6.setVisible(false);
			nameF.setText("");
		}
		if (emptyCheck() && s.onlyLetters(nameF.getText())
				&& !s.onlyLetters(lastName.getText())) {
			err2.setVisible(true);
			err1.setVisible(false);
			err3.setVisible(false);
			err4.setVisible(false);
			err5.setVisible(false);
			err6.setVisible(false);
			lastName.setText("");
		}
		if (emptyCheck() && s.onlyLetters(nameF.getText())
				&& s.onlyLetters(lastName.getText())
				&& !s.onlyDigits(age.getText())) {
			err5.setVisible(true);
			err1.setVisible(false);
			err2.setVisible(false);
			err3.setVisible(false);
			err4.setVisible(false);
			err6.setVisible(false);
			age.setText("");
		}
		if (emptyCheck() && s.onlyLetters(nameF.getText())
				&& s.onlyLetters(lastName.getText())
				&& s.onlyDigits(age.getText()) && !s.rightAge(age.getText())) {
			err3.setVisible(true);
			err1.setVisible(false);
			err2.setVisible(false);
			err4.setVisible(false);
			err5.setVisible(false);
			err6.setVisible(false);
			age.setText("");
		}
		if (emptyCheck() && s.onlyLetters(nameF.getText())
				&& s.onlyLetters(lastName.getText())
				&& s.onlyDigits(age.getText()) && s.rightAge(age.getText())
				&& !s.onlyDigits(salary.getText())) {
			err4.setVisible(true);
			err1.setVisible(false);
			err2.setVisible(false);
			err3.setVisible(false);
			err5.setVisible(false);
			err6.setVisible(false);
			salary.setText("");
		}
		if (emptyCheck() && s.onlyLetters(nameF.getText())
				&& s.onlyLetters(lastName.getText())
				&& s.onlyDigits(age.getText()) && s.rightAge(age.getText())
				&& s.onlyDigits(salary.getText())) {
			if (!s.employeeExist(lastName.getText())) {
				s.saveEmployee(nameF.getText(), lastName.getText(),
						Integer.parseInt(age.getText()),
						Double.parseDouble(salary.getText()), address.getText());
			}
			if (s.employeeExist(lastName.getText())) {
				s.getEmpList().set(
						s.getEmployeeIndex(lastName.getText()),
						new Employee(nameF.getText(), lastName.getText(),
								Integer.parseInt(age.getText()), Double
										.parseDouble(salary.getText()), address
										.getText()));
			}
			clearPanel();
			res = true;
		}
		return res;
	}

	public JTextField getNameF() {
		return nameF;
	}

	public void setNameF(JTextField nameF) {
		this.nameF = nameF;
	}

	public JTextField getLastName() {
		return lastName;
	}

	public void setLastName(JTextField lastName) {
		this.lastName = lastName;
	}

	public JTextField getAge() {
		return age;
	}

	public void setAge(JTextField age) {
		this.age = age;
	}

	public JTextField getSalary() {
		return salary;
	}

	public void setSalary(JTextField salary) {
		this.salary = salary;
	}

	public JTextField getAddress() {
		return address;
	}

	public void setAddress(JTextField address) {
		this.address = address;
	}
	
}
