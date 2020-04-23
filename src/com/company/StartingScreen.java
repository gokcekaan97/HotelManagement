package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.Constants.*;

//Login stage of the program
public class StartingScreen extends Frame implements ActionListener{
    public JButton StaffLogin;
    public JFrame frame;
    public StartingScreen(){
        frame = new JFrame("StartingScreen");
        StaffLogin = new JButton("Staff Login");
        StaffLogin.setBounds(180, 100, buttonWidth, buttonHeight);
        StaffLogin.addActionListener(this);
        frame.add(StaffLogin);
        frame.setLayout(null);
        frame.setSize(frameWidth,frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == StaffLogin) {
            new MainMenu();
            frame.setVisible(false);
        }
    }
}
