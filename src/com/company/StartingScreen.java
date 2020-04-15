package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartingScreen extends Frame implements ActionListener{
    public JButton StaffLogin;
    public JFrame frame;
    public StartingScreen(){
        frame = new JFrame("StartingScreen");
        StaffLogin = new JButton("Staff Login");
        StaffLogin.addActionListener(this);
        frame.add(StaffLogin);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.setSize(500,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == StaffLogin) {
            new rooms();
            frame.setVisible(false);
        }
    }
}
