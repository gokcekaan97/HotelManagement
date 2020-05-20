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
import static com.company.customerRooms.roomsJframe;

//Room allocating -adding database stage
public class customerManage_room extends Frame implements ActionListener {
    database d = new database();
    JComboBox patternList;
    JComboBox patternList1;
    public JFrame dialogframe;
    int x;
    JFrame ff;
    JLabel date_display_text=new JLabel("Room Status:");
    JButton b6 = new JButton("Complete");
    JButton backButtonForFrameFF = new JButton("Back");
    JTextField t = new JTextField("Enter Name",16);
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
        ff.add(date_display_text);
        ff.add(backButtonForFrameFF);
        ff.add(date_display);
        date_display.setText(d.getDate(x));
        if(d.getDate(x).equals("Room is available")) {
            date_display.setForeground(Color.GREEN);
        } else{
            date_display.setForeground(Color.RED);
        }
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
        b6.setBounds(320, 75, 145, buttonRoomHeight);
        date_display_text.setBounds(130, 95, 350, 200);
        date_display.setBounds(130, 110, 350, 200);
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == b6) {
        	d.CheckDatee(x,(String) patternList.getSelectedItem(),(String) patternList1.getSelectedItem());
        	if(d.CheckDate(x,(String) patternList.getSelectedItem(),(String) patternList1.getSelectedItem())=="room is full") {

        		JOptionPane.showMessageDialog(dialogframe, "Room is full");
        	}else {

                try {
                    int a = price();
                    if(a == 0) {
                        System.out.print(patternList.getSelectedItem());
                        d.insert(x, t.getText(), x, (String) patternList.getSelectedItem(), (String) patternList1.getSelectedItem());
                        new customerRooms();
                    }else{
                        new customerManage_room(x);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            ff.setVisible(false);
        	}
        }   else if (evt.getSource() == backButtonForFrameFF) {
            ff.setVisible(false);
            roomsJframe.setVisible(true);
        }
    }
    public int price() throws ParseException {

        String a=(String) patternList.getSelectedItem();
        String aa=(String) patternList1.getSelectedItem();
        String format = "yyyy/MM/dd";
        int totalPrice;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        java.util.Date dateObj2 = sdf.parse(aa);
        java.util.Date dateObj1 = sdf.parse(a);
        long diff = dateObj2.getTime() - dateObj1.getTime();
        int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
        if(diffDays <0){
            JOptionPane.showMessageDialog(dialogframe, "days must be chosen correctly");
            return 1;
        } else if( diffDays==0){
            diffDays=1;
            System.out.println("difference between days: " + diffDays);
            totalPrice=diffDays*100;
            JOptionPane.showMessageDialog(dialogframe, "total price: " +totalPrice );
            return 0;
        }else {
            diffDays+=1;
            System.out.println("difference between days: " + diffDays);
            totalPrice=diffDays*100;
            JOptionPane.showMessageDialog(dialogframe, "total price: " +totalPrice );
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("aa");
    }
}
