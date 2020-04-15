package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class rooms extends Frame implements ActionListener {
    database d = new database();
    manage_room r;
    JFrame f;
    JFrame ff;
    JButton b1 = new JButton("1");
    JButton b2 = new JButton("2");
    JButton b3 = new JButton("3");
    JButton b4 = new JButton("4");
    JButton b5 = new JButton("check room");
    JButton b6 = new JButton("add");
    JButton b7 = new JButton("delete");

    rooms() {
        f = new JFrame();
        ff = new JFrame();

        JTextField t = new JTextField("enter name",16);
        ff.add(t);
        ff.add(b7);
        t.setVisible(true);
        ff.add(b6);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);

        f.setLayout(new FlowLayout(FlowLayout.CENTER));
        ff.setLayout(new FlowLayout(FlowLayout.CENTER));
        //setting flow layout of right alignment

        f.setSize(500, 300);
        ff.setSize(500, 300);
        ff.setVisible(false);
        f.setVisible(true);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == b1) {
            r = new manage_room(1);
            f.setVisible(false);
        } else if (evt.getSource() == b2) {
            r = new manage_room(2);
            f.setVisible(false);
        } else if (evt.getSource() == b3) {
            r = new manage_room(3);
            f.setVisible(false);
        } else if (evt.getSource() == b4) {
            r = new manage_room(4);
            f.setVisible(false);
        } else if (evt.getSource() == b5) {
            if (d.getPoint(1) == 1) {
                b1.setBackground(Color.red);
            } else {
                b1.setBackground(Color.green);
            }
            if (d.getPoint(2) == 2) {
                b2.setBackground(Color.red);
            } else {
                b2.setBackground(Color.green);
            }
            if (d.getPoint(3) == 3) {

                b3.setBackground(Color.red);
            } else {
                b3.setBackground(Color.green);
            }
            if (d.getPoint(4) == 4) {
                b4.setBackground(Color.red);
            } else {
                b4.setBackground(Color.green);
            }
        } else if (evt.getSource() == b6) {
            //do something
        } else if (evt.getSource() == b7) {
            //do something
        }
    }
}
