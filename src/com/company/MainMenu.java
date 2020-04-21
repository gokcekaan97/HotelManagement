package com.company;

import java.awt.Frame;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu extends Frame implements ActionListener {
	JFrame jf;
	rooms r;
	Staff s;
	database d=new database();
	JButton b1=new JButton("Room Management");
	JButton b2=new JButton("Staff Management");

	MainMenu(){
		jf=new JFrame("Hotel Management System");
		b1.setBounds(100,100,200,100);
		b2.setBounds(100,200,200,100);
		jf.add(b1);
		jf.add(b2);
		jf.setSize(500,500);
		jf.setLayout(null);
		jf.setVisible(true);
		b1.addActionListener(this);
		b2.addActionListener(this);
		}

	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource()==b1) {
			r=new rooms();
		}
		if(evt.getSource()==b2) {
			new Staff();
		}
	}
}
