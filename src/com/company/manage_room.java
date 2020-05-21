package com.company;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import javax.swing.*;
import static com.company.Constants.*;
import static com.company.rooms.roomsJframe;

//Room allocating -adding database stage
public class manage_room extends Frame implements ActionListener {
    database d = new database();
    JComboBox patternList;
    JComboBox patternList1;
    public JFrame dialogframe;
    int x;
    JFrame ff;

    JButton b6 = new JButton("add");
    JButton b7 = new JButton("delete");
    JButton backButtonForFrameFF = new JButton("Back");
    JTextField t = new JTextField("enter name",16);
    JLabel date_display=new JLabel();
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
        ff.add(backButtonForFrameFF);
        ff.add(date_display);
        date_display.setText(d.getDate(x));
        ff.setLayout(null);
        //setting flow layout of right alignment

        ff.setSize(frameWidth, frameHeight);
        ff.setVisible(true);

        backButtonForFrameFF.addActionListener(this);
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

        backButtonForFrameFF.setBounds(30, 30, buttonRoomWidth, buttonRoomHeight);
        t.setBounds(30, 75, 110, buttonRoomHeight);
        patternList.setBounds(150, 75, 140, buttonRoomHeight);
        patternList1.setBounds(150, 110, 140, buttonRoomHeight);
        b6.setBounds(320, 75, buttonRoomWidth, buttonRoomHeight);
        b7.setBounds(390, 75, buttonRoomWidth, buttonRoomHeight);
        date_display.setBounds(200, 110, 300, 200);
    }

    public void actionPerformed(ActionEvent evt) {
        try {
        	
        	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        	 LocalDateTime now = LocalDateTime.now();
            String a = (String) patternList.getSelectedItem();
            String aa = (String) patternList1.getSelectedItem();
            String aaa =dtf.format(now);
            String format = "yyyy/MM/dd";
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            java.util.Date dateObj2 = sdf.parse(aa);
            java.util.Date dateObj1 = sdf.parse(a);
            java.util.Date dateObj3 = sdf.parse(aaa);
            
            
            
            
            long diff = dateObj2.getTime() - dateObj1.getTime();
            long difff = dateObj1.getTime() - dateObj3.getTime();
            int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
            int diffDayss = (int) (difff / (24 * 60 * 60 * 1000));
            if (evt.getSource() == b6) {
                if (diffDays < 0 || diffDayss < 0) {
                    JOptionPane.showMessageDialog(dialogframe, "arrange the date correctly");
                } else {
                	System.out.print("asdadasd"+diffDayss);
                    if(d.CheckDate(x,(String) patternList.getSelectedItem(),(String) patternList1.getSelectedItem())=="room is full") {
                        JOptionPane.showMessageDialog(dialogframe, "Room is full");
                    }else {
                        System.out.print(patternList.getSelectedItem());
                        d.insert(x, t.getText(), x, (String) patternList.getSelectedItem(), (String) patternList1.getSelectedItem());
                        new rooms();
                        ff.setVisible(false);
                    }
                }
            } else if (evt.getSource() == b7) {
                if (diffDays < 0 ) {
                    JOptionPane.showMessageDialog(dialogframe, "arrange the date correctly");
                } else {                    
                        JOptionPane.showMessageDialog(dialogframe,  d.delete(x,(String) patternList.getSelectedItem(),(String) patternList1.getSelectedItem()));                     
                }
            } else if (evt.getSource() == backButtonForFrameFF) {
                ff.setVisible(false);
                roomsJframe.setVisible(true);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("aa");
    }
}