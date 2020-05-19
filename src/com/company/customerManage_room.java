package com.company;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import javax.swing.*;
import static com.company.Constants.*;
import static com.company.customerRooms.roomsJframe;

//Room allocating -adding database stage
public class customerManage_room extends Frame implements ActionListener {
    database d = new database();
    JComboBox patternList;
    JComboBox patternList1;
    public JFrame dialogframe;
    int x;
    JFrame ff;

    JButton b6 = new JButton("add");
    
    JButton backButtonForFrameFF = new JButton("Back");
    JTextField t = new JTextField("enter name",16);
    JLabel date_display=new JLabel();
    customerManage_room(int x) {
        this.x = x;
        ff = new JFrame();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        ff.add(t);
        
        
        System.out.print(d.getDate(x));
        t.setVisible(true);
        ff.add(b6);
        ff.add(backButtonForFrameFF);
        ff.add(date_display);
        date_display.setText(d.getDate(x));
        ff.setLayout(null);
        //setting flow layout of right alignment

        ff.setSize(frameWidth, frameHeight);
        ff.setVisible(true);

        backButtonForFrameFF.addActionListener(this);
        b6.addActionListener(this);
        
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

        backButtonForFrameFF.setBounds(30, 30, buttonRoomWidth, buttonRoomHeight);
        t.setBounds(30, 75, 110, buttonRoomHeight);
        patternList.setBounds(150, 75, 140, buttonRoomHeight);
        patternList1.setBounds(150, 110, 140, buttonRoomHeight);
        b6.setBounds(320, 75, buttonRoomWidth, buttonRoomHeight);
        
        date_display.setBounds(200, 110, 300, 200);
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == b6) {
        	d.CheckDatee(x,(String) patternList.getSelectedItem(),(String) patternList1.getSelectedItem());
        	if(d.CheckDate(x,(String) patternList.getSelectedItem(),(String) patternList1.getSelectedItem())=="room is full") {
        		
        		JOptionPane.showMessageDialog(dialogframe, "Room is full");
        	}else {
            System.out.print(patternList.getSelectedItem());
            d.insert(x, t.getText(), x, (String) patternList.getSelectedItem(), (String) patternList1.getSelectedItem());
            new customerRooms();
            ff.setVisible(false);
        	}
        }   else if (evt.getSource() == backButtonForFrameFF) {
            ff.setVisible(false);
            roomsJframe.setVisible(true);
        }
    }

    public static void main(String[] args) {
        System.out.println("aa");
    }
}
