package com.company;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Staff extends Frame implements ActionListener{
		database d=new database();
		JFrame frame1;
		JFrame frame2;
		JFrame frame3;
		JTextField textbox1;
		JTextField textbox2;
		JTextField textbox3;
		JTextField textbox4;
		JTextField textbox5;
		JTextField textbox6;
		JTextField textbox7;
		JRadioButton choice1;
		JRadioButton choice2;
		ButtonGroup bg;
		JButton button1;
		JButton button2;
		JButton button3;
		JButton button4;
		JButton button5;
	public Staff() {
	    frame1 = new JFrame("Staff Information");	
	    frame2=new JFrame("Add Staff");
	    frame3=new JFrame("Delete Staff");
		JLabel label1=new JLabel("Staff Name:");
		label1.setBounds(0,50,200,30); 
		JLabel label2=new JLabel("Staff Surname:");
		label2.setBounds(0,100,200,30);  
		JLabel label3=new JLabel("Age:");
		label3.setBounds(0,150,200,30);
		JLabel label4=new JLabel("Choose gender:");
		label4.setBounds(0,200,200,30);
		JLabel label5=new JLabel("Salary:");
		label5.setBounds(0, 250,200,30);
		JLabel label6=new JLabel("Number of off days:");
		label6.setBounds(0, 300,200,30);
	    JLabel label7=new JLabel("Type the name that you want to delete:");
	    label7.setBounds(50,50,250, 100);
		textbox1=new JTextField();
		textbox1.setBounds(120,50,200,30);
		textbox2=new JTextField();
		textbox2.setBounds(120,100,200,30);
		textbox3=new JTextField();
		textbox3.setBounds(120,150,200,30);
		textbox4=new JTextField();
		textbox4.setBounds(120,250,50,30);
	    textbox5=new JTextField();
	    textbox5.setBounds(120,300,200,30);
	    textbox6=new JTextField();
	    textbox6.setBounds(50,150,200,30);
		choice1=new JRadioButton("Male");
		choice1.setBounds(100,200,100,30);
		choice2=new JRadioButton("Female");
		choice2.setBounds(210,200,100,30);
		ButtonGroup bg=new ButtonGroup();    
		bg.add(choice1);
		bg.add(choice2);
		button1=new JButton("Add Staff");
		button1.setBounds(100,50,200,100);	
		button2=new JButton("Add");
		button2.setBounds(120,350, 95,30);
		button3=new JButton("Delete Staff");
		button3.setBounds(100,150,200,100);		
		button4=new JButton("Delete");
	    button4.setBounds(100,200,100,50);
		button5=new JButton("View Table");
	    button5.setBounds(100,250,200,100);
        frame1.add(button1);
	    frame1.add(button3);
	    frame1.add(button5);
	    frame2.add(button2);
	    frame3.add(button4);
	    frame2.add(textbox1);
		frame2.add(textbox2);
		frame2.add(textbox3);
		frame2.add(textbox4);
		frame2.add(textbox5);		
		frame2.add(choice1);
		frame2.add(choice2);
		frame2.add(label1);
		frame2.add(label2);
		frame2.add(label3);
		frame2.add(label4);
		frame2.add(label5);
		frame2.add(label6);
		frame3.add(textbox6);
		frame3.add(label7);
	    frame2.setSize(500, 500);
	    frame2.setSize(500,400);	    
	    frame1.setLayout(null);
	    frame2.setLayout(null);
	    frame1.setVisible(true);
	    frame1.setSize(500,400);
	    frame2.setSize(400,400);
	    frame3.setSize(400,400);
	    frame2.setLayout(null);
	    frame3.setLayout(null);
	    button1.addActionListener(this);
	    button2.addActionListener(this);
	    button3.addActionListener(this);
	    button4.addActionListener(this);
	    button5.addActionListener(this);
}
public void actionPerformed(ActionEvent evt) {
	if(evt.getSource()==button1) {
		frame2.setVisible(true);
	}
	if(evt.getSource()==button2) {
		d.addStaff(textbox1.getText(), textbox2.getText(),Integer.parseInt(textbox3.getText()),
		choice1.isSelected()?choice1.getText():choice2.getText(),
		Double.parseDouble(textbox4.getText()),Integer.parseInt(textbox5.getText()));
	}
	if(evt.getSource()==button3) {
		frame3.setVisible(true);
	}
	if(evt.getSource()==button4) {
		d.deleteStaff(textbox6.getText());
	}
	if(evt.getSource()==button5) {
		d.retrieveTableData();
	}
	
}

}
