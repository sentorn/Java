package com.sentornCalc;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(320, 280);
		frame.setLocation(300, 200);
		frame.setResizable(false);
		frame.add(new Calc());
		frame.setVisible(true);
				
	}

}
