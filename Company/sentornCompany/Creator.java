package com.sentornCompany;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Creator {
	
	private Font f1 = new Font("arial", 0, 20);
	private Font f2 = new Font("arial", 0, 15);
	
	Image getImage() {
		return new ImageIcon(getClass().getClassLoader().getResource("res/1.jpg"))
				.getImage();
	}

	JButton createButton(String name, Font f, Rectangle r, JPanel p,
			ActionListener a) {
		JButton b = new JButton(name);
		b.setFont(f);
		b.setBounds(r);
		p.add(b);
		b.addActionListener(a);
		return b;
	}

	JLabel createLabel(String name, Font f, Rectangle r, JPanel p) {
		JLabel l = new JLabel(name);
		l.setFont(f);
		l.setBounds(r);
		p.add(l);
		return l;
	}

	JLabel createErrorLabel(String name, Font f, Rectangle r, JPanel p) {
		JLabel l = new JLabel(name);
		l.setFont(f);
		l.setBounds(r);
		l.setForeground(Color.RED);
		p.add(l);
		return l;
	}

	JTextField createTextField(Font f, Rectangle r, JPanel p) {
		JTextField t = new JTextField();
		t.setFont(f);
		t.setBounds(r);
		p.add(t);
		return t;
	}
	
	JPasswordField createPasswordField(Font f, Rectangle r, JPanel p) {
		JPasswordField pass = new JPasswordField();
		pass.setFont(f);
		pass.setBounds(r);
		p.add(pass);
		return pass;
	}

	public Font getF1() {
		return f1;
	}

	public void setF1(Font f1) {
		this.f1 = f1;
	}

	public Font getF2() {
		return f2;
	}

	public void setF2(Font f2) {
		this.f2 = f2;
	}
	
}
