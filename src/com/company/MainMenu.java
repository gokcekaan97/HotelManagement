package com.company;

import java.awt.Frame;
import java.awt.event.*;
import javax.swing.*;

import static com.company.Constants.*;

//Main Menu which provides staff and room management of the hotel
public class MainMenu extends Frame implements ActionListener {
	static JFrame jf;
	rooms r;
	Staff s;
	database d=new database();
	JButton b1=new JButton("Room Management");
	JButton b2=new JButton("Staff Management");

	MainMenu(){
		jf=new JFrame("Hotel Management System");
		b1.setBounds(120,40,buttonWidth, buttonHeight);
		b2.setBounds(120,120,buttonWidth, buttonHeight);
		jf.add(b1);
		jf.add(b2);
		jf.setSize(frameWidth, frameHeight);
		jf.setLayout(null);
		jf.setVisible(true);
		b1.addActionListener(this);
		b2.addActionListener(this);
		}

	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource()==b1) {
			r=new rooms();
			jf.setVisible(false);
		}
		if(evt.getSource()==b2) {
			new Staff();
			jf.setVisible(false);
		}
	}
}
