package com.sentornCompany;

import java.awt.Graphics;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class EmployeesPanel extends JPanel {

	private TextArea ta;
	private JComboBox<String> cb;
	private Creator c = new Creator();
	private Solutions s;

	public EmployeesPanel(Solutions s) {
		this.s = s;
		this.setLayout(null);

		cb = new JComboBox<String>();
		cb.addItem("Sorting by");
		cb.addItem("Name");
		cb.addItem("Age");
		cb.addItem("Salary");
		cb.setBounds(10, 10, 100, 20);
		this.add(cb);

		ta = new TextArea();
		ta.setBounds(10, 40, 325, 290);
		this.add(ta);

		cb.addActionListener(new BoxListener());
	}

	class BoxListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String combo = (String) cb.getSelectedItem();
			if (combo.equals("Sorting by")) {
				ta.setText(s.getAllEmp());
			}
			if (combo.equals("Name")) {
				s.sortByName();
				ta.setText(s.getAllEmp());
			}
			if (combo.equals("Age")) {
				s.sortByAge();
				ta.setText(s.getAllEmp());
			}
			if (combo.equals("Salary")) {
				s.sortBySalary();
				ta.setText(s.getAllEmp());
			}
		}

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(c.getImage(), 0, 0, getWidth(), getHeight(), null);
	}

	public TextArea getTa() {
		return ta;
	}

	public void setTa(TextArea ta) {
		this.ta = ta;
	}

	
}
