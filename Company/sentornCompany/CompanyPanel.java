package com.sentornCompany;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CompanyPanel extends JPanel {

	private Creator c = new Creator();

	public CompanyPanel() {
		this.setLayout(null);
		c.createLabel("Company", new Font("arial", 0, 30), new Rectangle(110,
				20, 200, 50), this);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(c.getImage(), 0, 0, getWidth(), getHeight(), null);
	}
}
