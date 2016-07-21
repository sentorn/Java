package com.sentornCompany;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class CompanyFrame extends JFrame {

	private Creator c = new Creator();
	private Solutions s = new Solutions();
	private SaveToFile<User> stf = new SaveToFile<User>();
	private SaveToFile<Employee> stfE = new SaveToFile<Employee>();
	private LoginPanel lp = new LoginPanel(s);
	private RegistrationPanel rgp = new RegistrationPanel(s);
	private CompanyPanel cop = new CompanyPanel();
	private EditPanel edp = new EditPanel(s);
	private ChangePanel chp = new ChangePanel(s, edp);
	private RemovePanel rmp = new RemovePanel(s);
	private EmployeesPanel emp = new EmployeesPanel(s);

	public CompanyFrame() {
		super("Company");

		c.createButton("Login", c.getF1(), new Rectangle(30, 220, 120, 30), lp,
				new ButtonListenerOne());
		c.createButton("Register", c.getF1(), new Rectangle(180, 220, 120, 30),
				lp, new ButtonListenerOne());
		add(lp);

		c.createButton("Register", c.getF1(), new Rectangle(30, 270, 120, 30),
				rgp, new ButtonListenerTwo());
		c.createButton("Cancel", c.getF1(), new Rectangle(190, 270, 120, 30),
				rgp, new ButtonListenerOne());

		c.createButton("Add Employee", c.getF1(),
				new Rectangle(75, 80, 200, 40), cop, new ButtonListenerOne());
		c.createButton("Change Employee", c.getF1(), new Rectangle(75, 140,
				200, 40), cop, new ButtonListenerOne());
		c.createButton("Remove Employee", c.getF1(), new Rectangle(75, 200,
				200, 40), cop, new ButtonListenerOne());
		c.createButton("Show Employees", c.getF1(), new Rectangle(75, 260, 200,
				40), cop, new ButtonListenerOne());
		c.createButton("Exit", c.getF1(), new Rectangle(75, 320, 200, 40), cop,
				new ButtonListenerOne());

		c.createButton("Save", new Font("arial", 0, 20), new Rectangle(40, 300,
				120, 30), edp, new ButtonListenerOne());
		c.createButton("Cancel", new Font("arial", 0, 20), new Rectangle(180,
				300, 120, 30), edp, new ButtonListenerFour());

		c.createButton("Change", c.getF1(), new Rectangle(40, 170, 120, 30),
				chp, new ButtonListenerOne());
		c.createButton("Cancel", c.getF1(), new Rectangle(180, 170, 120, 30),
				chp, new ButtonListenerThree());

		c.createButton("Remove", c.getF1(), new Rectangle(40, 170, 120, 30),
				rmp, new ButtonListenerOne());
		c.createButton("Cancel", c.getF1(), new Rectangle(180, 170, 120, 30),
				rmp, new ButtonListenerTwo());

		c.createButton("Return", new Font("arial", 0, 17), new Rectangle(245,
				335, 90, 25), emp, new ButtonListenerOne());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 400);
		setLocation(400, 150);
		setResizable(false);
		setVisible(true);

		s.setUserList(stf.readFromFile(s.getUserList(), "users.txt"));
		s.setEmpList(stfE.readFromFile(s.getEmpList(), "employees.txt"));

	}

	class ButtonListenerOne implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			String text = b.getText();
			if (text.equals("Login")) {
				if (lp.checkInputs()) {
					add(cop);
				}
			}
			if (text.equals("Register")) {
				lp.clearPanel();
				lp.setVisible(false);
				add(rgp);
			}
			if (text.equals("Cancel")) {
				rgp.clearPanel();
				remove(rgp);
				lp.setVisible(true);
			}
			if (text.equals("Add Employee")) {
				cop.setVisible(false);
				add(edp);
			}
			if (text.equals("Change Employee")) {
				cop.setVisible(false);
				chp.setVisible(true);
				add(chp);
			}
			if (text.equals("Remove Employee")) {
				cop.setVisible(false);
				add(rmp);
			}
			if (text.equals("Show Employees")) {
				emp.getTa().setText(s.getAllEmp());
				add(emp);
				cop.setVisible(false);
			}
			if (text.equals("Exit")) {
				remove(cop);
				lp.setVisible(true);
			}
			if (text.equals("Return")) {
				remove(emp);
				cop.setVisible(true);
			}
			if (text.equals("Save")) {
				if (edp.checkFields()) {
					stfE.saveToFile(s.getEmpList(), "employees.txt");
				}
			}
			if (text.equals("Remove")) {
				if (rmp.checkField()) {
					stfE.saveToFile(s.getEmpList(), "employees.txt");
				}
			}
			if (text.equals("Change")) {
				if (chp.checkField()) {
					chp.setVisible(false);
					add(edp);
					remove(chp);
				}
			}
		}
	}

	class ButtonListenerTwo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			if (b.getText().equals("Register")) {
				if (rgp.checkInputs()) {
					remove(rgp);
					lp.setVisible(true);
					stf.saveToFile(s.getUserList(), "users.txt");
				}
			}
			if (b.getText().equals("Cancel")) {
				rmp.clearPanel();
				remove(rmp);
				cop.setVisible(true);
			}
		}
	}

	class ButtonListenerThree implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			if (b.getText().equals("Cancel")) {
				chp.clearPanel();
				remove(chp);
				cop.setVisible(true);
			}
		}
	}

	class ButtonListenerFour implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			if (b.getText().equals("Cancel")) {
				edp.clearPanel();
				remove(edp);
				cop.setVisible(true);
			}
		}
	}
}
