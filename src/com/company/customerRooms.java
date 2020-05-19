package com.company;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import static com.company.Constants.*;
import static com.company.MainMenu.jf;
import static com.company.StartingScreen.frame;
//Room allocating -rooms are demonstrated and colors represent the occupancy status of the rooms.
public class customerRooms extends Frame implements ActionListener {
	StartingScreen scc =new StartingScreen();
    database d = new database();
    customerManage_room r;
    static JFrame roomsJframe;
    JFrame ff;
    JTextField tt = new JTextField("room search",16);
    JButton b1 = new JButton("1");
    JButton b2 = new JButton("2");
    JButton b3 = new JButton("3");
    JButton b4 = new JButton("4");
    JButton b5 = new JButton("check room");
    JButton b6 = new JButton("search");
    JButton backButtonForFrameF = new JButton("Back");
    JComboBox serch_box ;
    String s1[] = { "all", "1 person", "2 person" };
    customerRooms() {
        roomsJframe = new JFrame();
        ff = new JFrame();

        JTextField t = new JTextField("enter ", 16);

        ff.add(t);
       
        t.setVisible(true);
        
        roomsJframe.add(backButtonForFrameF);
        roomsJframe.add(b1);
        roomsJframe.add(b2);
        roomsJframe.add(b3);
        roomsJframe.add(b4);
        roomsJframe.add(b5);
        roomsJframe.add(b6);
        
        
        roomsJframe.setLayout(null);
        serch_box= new JComboBox(s1);
        //setting flow layout of right alignment
        roomsJframe.add(serch_box);

        roomsJframe.setSize(frameWidth, frameHeight);
        ff.setSize(frameWidth, frameHeight);
        ff.setVisible(false);
        roomsJframe.setVisible(true);
        backButtonForFrameF.setBounds(30, 30, buttonRoomWidth, buttonRoomHeight);
        b1.setBounds(30, 75, buttonRoomWidth, buttonRoomHeight);
        b2.setBounds(100, 75, buttonRoomWidth, buttonRoomHeight);
        b3.setBounds(170, 75, buttonRoomWidth, buttonRoomHeight);
        b4.setBounds(240, 75, buttonRoomWidth, buttonRoomHeight);
        b5.setBounds(310, 75, 130, buttonRoomHeight);
        b6.setBounds(380, 50, 130, buttonRoomHeight);
        
        serch_box.setBounds(310, 50, 130, buttonRoomHeight);
        
        backButtonForFrameF.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
      

        //for macs
       /* b1.setOpaque(true);
        b2.setOpaque(true);
        b3.setOpaque(true);
        b4.setOpaque(true);
        b1.setBorderPainted(false);
        b2.setBorderPainted(false);
        b3.setBorderPainted(false);
        b4.setBorderPainted(false);
        b1.setFocusPainted(true);
        b2.setFocusPainted(true);
        b3.setFocusPainted(true);
        b4.setFocusPainted(true);
        b1.setMargin(new Insets(0, 0, 0, 0));
        b2.setMargin(new Insets(0, 0, 0, 0));
        b3.setMargin(new Insets(0, 0, 0, 0));
        b4.setMargin(new Insets(0, 0, 0, 0));*/

    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == b1) {
            r = new customerManage_room(1);
            roomsJframe.setVisible(false);
        } else if (evt.getSource() == b2) {
            r = new customerManage_room(2);
            roomsJframe.setVisible(false);
        } else if (evt.getSource() == b3) {
            r = new customerManage_room(3);
            roomsJframe.setVisible(false);
        } else if (evt.getSource() == b4) {
            r = new customerManage_room(4);
            roomsJframe.setVisible(false);
        } else if (evt.getSource() == b5) {
            if (d.getPoint(1) == 1) {
                b1.setForeground(Color.red);
            } else {
                b1.setForeground(Color.green);
            }
            if (d.getPoint(2) == 2) {
                b2.setForeground(Color.red);
            } else {
                b2.setForeground(Color.green);
            }
            if (d.getPoint(3) == 3) {

                b3.setForeground(Color.red);
            } else {
                b3.setForeground(Color.green);
            }
            if (d.getPoint(4) == 4) {
                b4.setForeground(Color.red);
            } else {
                b4.setForeground(Color.green);
            }
        }  else if (evt.getSource() == backButtonForFrameF) {
            roomsJframe.setVisible(false);
          
            	frame.setVisible(true);
            
        }else if (evt.getSource() == b6) {
        	System.out.print("gg");
            if(serch_box.getSelectedItem().equals("2 person")) {
            	System.out.print("gg");
            	b1.setVisible(false);
            	b2.setVisible(true);
            	b3.setVisible(false);
            	b4.setVisible(true);
            }else if (serch_box.getSelectedItem().equals("all")) {
            	b1.setVisible(true);
            	b2.setVisible(true);
            	b3.setVisible(true);
            	b4.setVisible(true);
            }
            
            else if (serch_box.getSelectedItem().equals("1 person")) {
            	b1.setVisible(true);
            	b2.setVisible(false);
            	b3.setVisible(true);
            	b4.setVisible(false);
            }
        }
        
    }
}
