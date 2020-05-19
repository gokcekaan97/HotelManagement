package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.Constants.*;

//Login stage of the program
public class StartingScreen extends Frame implements ActionListener{
    public JButton loginbutton;
    public JButton registerbutton;
    public static JFrame frame;
    public JFrame dialogframe;
    public static JTabbedPane tp;
    public static JPanel p1;
    public static JPanel p2;
    public JTextField username;
    public JPasswordField password;
    public JLabel usernamelabel;
    public JLabel passwordlabel;
    public JLabel usertypelabel;
    public Icon icon;
    private database d=new database();
    
    public StartingScreen(){
    	JFrame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame("StartingScreen");
        tp=new JTabbedPane();
        username=new JTextField();
        username.setBounds(130,40,200,30);
        password=new JPasswordField();
        password.setBounds(130,80,200,30);
        usernamelabel=new JLabel("Username");
        usernamelabel.setBounds(50,40,200,30);
        passwordlabel=new JLabel("Password");
        passwordlabel.setBounds(50,80,200,30);
        loginbutton = new JButton("Login");
        registerbutton=new JButton("Register");
        registerbutton.setBounds(148,170, buttonWidth, buttonHeight);
        loginbutton.setBounds(160, 140, buttonWidth, buttonHeight);
        loginbutton.addActionListener(this);
        registerbutton.addActionListener(this);
        p1=new JPanel();
        p1.setLayout(null);
        p1.add(registerbutton);
        p2=new JPanel();
        p2.setBackground(Color.LIGHT_GRAY);
        frame.add(username);
        frame.add(password);
        frame.add(usernamelabel);
        frame.add(passwordlabel);
        frame.add(loginbutton);
        frame.add(tp);
        tp.addTab("Customer",p1);
        tp.addTab("Admin/Staff", p2);
        tp.setBounds(10, 0, 450,250);
        frame.setLayout(null);
        frame.setSize(frameWidth,frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
 
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == loginbutton) {
            if (tp.getSelectedIndex()==0) {
                if (d.loginCheck(username.getText(),password.getText())) {
                    frame.setVisible(false);
                   
                    
                    new customerRooms();
                    //new customer screen will be called here.
                    JOptionPane.showMessageDialog(dialogframe, "Successfully logged in");
                } else {
                    JOptionPane.showMessageDialog(dialogframe, "Wrong username or password.");
                }
            }
            if (tp.getSelectedIndex()==1){
                if ( d.adminLoginCheck(username.getText(), password.getText())){
                    frame.setVisible(false);
                    new MainMenu();
                    JOptionPane.showMessageDialog(dialogframe, "Successfully logged in.");
                } else {
                    JOptionPane.showMessageDialog(dialogframe, "Wrong username or password.");
                }
            }
        }
        if(evt.getSource()==registerbutton) {
            if(tp.getSelectedIndex()==0) {
                frame.setVisible(false);
                new RegisterScreen();
            }
        }
    }
}
