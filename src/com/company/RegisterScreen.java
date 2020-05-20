package com.company;

import javax.swing.*;
import static com.company.Constants.*;
import static com.company.MainMenu.jf;
import static com.company.StartingScreen.*;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.server.UID;
import java.util.Random;
public class RegisterScreen extends Frame implements ActionListener {
	public JFrame registerframe;
	public JLabel idlabel;
	public JLabel usernamelabel;
	public JLabel passwordlabel;
	public JLabel usertypelabel;
	public JLabel customerlabel;
	public JLabel namelabel;
	public JLabel surnamelabel;
	public JLabel agelabel;
	public JLabel genderlabel;
	public JLabel addresslabel;
	public JTextField username;
	public JPasswordField password;
	public JTextField name;
	public JTextField surname;
	public JTextField age;
	public JRadioButton gender_male;
	public JRadioButton gender_female;
	public JTextField address;
	public JButton registerbutton;
	public JButton backButtonForFrame1;
	public database d=new database();
	public StartingScreen sc;
	
	public RegisterScreen() {
		registerframe=new JFrame("Register");
		registerframe.setSize(frameWidth,550);
		usernamelabel=new JLabel("Username");
		usernamelabel.setBounds(20,40,200,30);
		passwordlabel=new JLabel("Password");
		passwordlabel.setBounds(20,80,200,30);
		usertypelabel=new JLabel("User type");
		usertypelabel.setBounds(20,120,200,30);
		customerlabel=new JLabel("Customer");
		customerlabel.setBounds(130,120,200,30);
		namelabel=new JLabel("Name");
		namelabel.setBounds(20, 160,200,30);
		surnamelabel=new JLabel("Surname");
		surnamelabel.setBounds(20,200,labelWidth,labelHeight);
		agelabel=new JLabel("Age");
		agelabel.setBounds(20,240,labelWidth,labelHeight);
		genderlabel=new JLabel("Gender");
		genderlabel.setBounds(20,280,labelWidth,labelHeight);
		addresslabel=new JLabel("Address");
		addresslabel.setBounds(20,320,labelWidth,labelHeight);
		username=new JTextField();
		username.setBounds(130, 40, 200,30);
		password=new JPasswordField();
		password.setBounds(130, 80, 200,30);
		name=new JTextField();
		name.setBounds(130,160,200,30);
		surname=new JTextField();
		surname.setBounds(130,200,200,30);
		age=new JTextField();
		age.setBounds(130,240,200,30);
		gender_male=new JRadioButton("Male");
		gender_male.setBounds(130,280,100,30);
		gender_female=new JRadioButton("Female");
		gender_female.setBounds(240,280,100,30);
		address=new JTextField();
		address.setBounds(130,320,textWidth,textHeight);
		registerbutton=new JButton("Register");
		registerbutton.setBounds(130,360,buttonWidth,buttonHeight);
		backButtonForFrame1 = new JButton("Back");
		backButtonForFrame1.setBounds(130,420,buttonWidth,buttonHeight);
		registerframe.add(usernamelabel);
		registerframe.add(passwordlabel);
		registerframe.add(namelabel);
		registerframe.add(surnamelabel);
		registerframe.add(agelabel);
		registerframe.add(genderlabel);
		registerframe.add(addresslabel);
		registerframe.add(username);
		registerframe.add(password);
		registerframe.add(name);
		registerframe.add(surname);
		registerframe.add(age);
		registerframe.add(gender_male);
		registerframe.add(gender_female);
		registerframe.add(address);
		registerframe.add(registerbutton);
		registerframe.add(usertypelabel);
		registerframe.add(backButtonForFrame1);
		registerframe.setLayout(null);
		registerframe.setVisible(true);
		registerbutton.addActionListener(this);
		backButtonForFrame1.addActionListener(this);
		}
	//Actions performed when pressed register button.
	public void actionPerformed(ActionEvent e) {
		String strRegEx = "^(?=.*[0-9]).{8,15}$";
		int id=generateID();
		if(e.getSource()==registerbutton) {
			if(password.getText().matches(strRegEx)) {
				d.registerCustomer(id,username.getText(),password.getText(),
						name.getText(),surname.getText(),Integer.parseInt(age.getText()),
						gender_male.isSelected()?gender_male.getText():gender_female.getText(),
						address.getText());
				registerframe.setVisible(false);
				frame.setVisible(true);
			}
			else
				//The password should satisfy the following rules.
				System.out.println("Your password is not valid to register.Check the following:\n"
						+ "1)Password must contain at least 8 characters\r\n" + 
						  "2) Password must contain at least 1 number\r\n" + 
						  "3) Password must contain at least 1 upper case letter\r\n" + 
						  "4) Password must contain at least 1 lower case letter\r\n" + 
						  "5) Password must contain at least 1 special character\r\n" + 
						  "6) Password must not contain any spaces");
	} else if (e.getSource() == backButtonForFrame1) {
			registerframe.setVisible(false);
			frame.setVisible(true);
		}
	}
	//ID generation for users
	public static int generateID() {
		Random rand=new Random();
		int number=1+rand.nextInt(99);
		return number;
	}
}
