package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import javax.swing.*;

import static com.company.Constants.frameHeight;
import static com.company.Constants.frameWidth;

//Room allocating -adding database stage
public class manage_room extends Frame implements ActionListener {
    database d = new database();
    JComboBox patternList;
    JComboBox patternList1;
    int x;
    JFrame ff;

    JButton b6 = new JButton("add");
    JButton b7 = new JButton("delete");
    JTextField t = new JTextField("enter name",16);

    manage_room(int x) {
        this.x = x;
        ff = new JFrame();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        ff.add(t);
        ff.add(b7);
        t.setText(d.get(x));
        t.setVisible(true);
        ff.add(b6);

        ff.setLayout(new FlowLayout(FlowLayout.CENTER));
        //setting flow layout of right alignment

        ff.setSize(frameWidth, frameHeight);
        ff.setVisible(true);

        b6.addActionListener(this);
        b7.addActionListener(this);
        String[] patternExamples = {
        		dtf.format(now)
        };

        patternList = new JComboBox(patternExamples);
        patternList.setEditable(true);
        patternList.addActionListener(this);
        ff.add(patternList);
        patternList1 = new JComboBox(patternExamples);
        patternList1.setEditable(true);
        patternList1.addActionListener(this);
        ff.add(patternList1);
    }
    //
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == b6) {
            System.out.print(patternList.getSelectedItem());
            d.insert(x, t.getText(), x, (String) patternList.getSelectedItem(), (String) patternList1.getSelectedItem());
            new rooms();
            ff.setVisible(false);
        } else if (evt.getSource() == b7) {
            d.delete(x);
            new rooms();
            ff.setVisible(false);
        }
    }

    public static void main(String[] args) {
        System.out.println("aa");
    }
}
