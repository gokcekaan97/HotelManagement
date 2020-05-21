package com.company;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import static com.company.Constants.*;
import static com.company.MainMenu.jf;

//Room allocating -rooms are demonstrated and colors represent the occupancy status of the rooms.
public class rooms extends Frame implements ActionListener {
    database d = new database();
    manage_room r;
    static JFrame roomsJframe;
    JFrame ff;
    JLabel roomsListedText = new JLabel("Rooms are listed below:");
    JTextField tt = new JTextField("room search",16);
    JButton b1 = new JButton("1");
    JButton b2 = new JButton("2");
    JButton b3 = new JButton("3");
    JButton b4 = new JButton("4");
    JButton b5 = new JButton("5");
    JButton b6= new JButton("6");
    JButton b7 = new JButton("7");
    JButton b8 = new JButton("8");
    JButton b9 = new JButton("9");
    JButton b10 = new JButton("10");
    JButton b11= new JButton("11");
    JButton b12= new JButton("12");
    
    
    JButton backButtonForFrameF = new JButton("Back");
    
    rooms() {
        roomsJframe = new JFrame();
        ff = new JFrame();
       
        JTextField t = new JTextField("enter ", 16);

        ff.add(t);
       
        t.setVisible(true);
        roomsJframe.add(roomsListedText);
        roomsJframe.add(backButtonForFrameF);
        roomsJframe.add(b1);
        roomsJframe.add(b2);
        roomsJframe.add(b3);
        roomsJframe.add(b4);
        roomsJframe.add(b5);
        roomsJframe.add(b6);
        roomsJframe.add(b7);
        roomsJframe.add(b8);
        roomsJframe.add(b9);
        roomsJframe.add(b10);
        roomsJframe.add(b11);
        roomsJframe.add(b12);
        
        
        roomsJframe.setLayout(null);
       
        //setting flow layout of right alignment
        

        roomsJframe.setSize(frameWidth, frameHeight);
        ff.setSize(frameWidth, frameHeight);
        ff.setVisible(false);
        roomsJframe.setVisible(true);
        roomsListedText.setBounds(30, 75, 200, buttonHeight);
        backButtonForFrameF.setBounds(30, 30, buttonRoomWidth, buttonRoomHeight);
        b1.setBounds(30, 120, buttonRoomWidth, buttonRoomHeight);
        b2.setBounds(100, 120, buttonRoomWidth, buttonRoomHeight);
        b3.setBounds(170, 120, buttonRoomWidth, buttonRoomHeight);
        b4.setBounds(240, 120, buttonRoomWidth, buttonRoomHeight);
        b5.setBounds(310, 120, buttonRoomWidth, buttonRoomHeight);
        b6.setBounds(30, 160, buttonRoomWidth, buttonRoomHeight);
        b7.setBounds(100, 160, buttonRoomWidth, buttonRoomHeight);
        b8.setBounds(170, 160, buttonRoomWidth, buttonRoomHeight);
        b9.setBounds(240, 160, buttonRoomWidth, buttonRoomHeight);
        b10.setBounds(310, 160, buttonRoomWidth, buttonRoomHeight);
        b11.setBounds(30, 200, buttonRoomWidth, buttonRoomHeight);
        b12.setBounds(100, 200, buttonRoomWidth, buttonRoomHeight);
        backButtonForFrameF.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
        b12.addActionListener(this);

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
            r = new manage_room(1);
            roomsJframe.setVisible(false);
        } else if (evt.getSource() == b2) {
            r = new manage_room(2);
            roomsJframe.setVisible(false);
        } else if (evt.getSource() == b3) {
            r = new manage_room(3);
            roomsJframe.setVisible(false);
        } else if (evt.getSource() == b4) {
            r = new manage_room(4);
            roomsJframe.setVisible(false);
        } else if (evt.getSource() == b4) {
            r = new manage_room(4);
            roomsJframe.setVisible(false);
        }  else if (evt.getSource() == b5) {
            r = new manage_room(5);
            roomsJframe.setVisible(false);
        }  else if (evt.getSource() == b6) {
            r = new manage_room(6);
            roomsJframe.setVisible(false);
        }  else if (evt.getSource() == b7) {
            r = new manage_room(7);
            roomsJframe.setVisible(false);
        }  else if (evt.getSource() == b8) {
            r = new manage_room(8);
            roomsJframe.setVisible(false);
        }  else if (evt.getSource() == b9) {
            r = new manage_room(9);
            roomsJframe.setVisible(false);
        } else if (evt.getSource() == b10) {
            r = new manage_room(10);
            roomsJframe.setVisible(false);
        }  else if (evt.getSource() == b11) {
            r = new manage_room(11);
            roomsJframe.setVisible(false);
        }  else if (evt.getSource() == b12) {
            r = new manage_room(12);
            roomsJframe.setVisible(false);
        }    else if (evt.getSource() == backButtonForFrameF) {
            roomsJframe.setVisible(false);
            jf.setVisible(true);
            
        }
        
    }
}