package com.company;


import java.awt.BorderLayout;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import static com.company.Constants.frameHeight;
import static com.company.Constants.frameWidth;

//Database which holds staff and reservation info.
public class database {
	JFrame frame;
	JFrame frame2;
	JFrame frame3;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JTextField textbox;
	JDialog dialogbox;
	JLabel label;
	String[] columnNames = {"Name", "Surname", "Age", "Gender","Salary","Number of Off Days"};
	String[] roomColumnNames = {"name","room", "enterDate","checkoutDate"};
	static JTable tb;
	Staff s;
    private Connection connect() {
        String url = "jdbc:mysql://localhost:3306/users?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, "root", "");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public void registerCustomer(int id,String username,String password,String name,String surname,int age,String gender,String address) {
    	String sql="INSERT INTO users(id,username,password,name,surname,age,gender,address)"
    			+ "VALUES(?,?,?,?,?,?,?,?)";
    	
    	 try (Connection conn = this.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)
            )
         {
    		 	pstmt.setInt(1,id);
                pstmt.setString(2, username);
                pstmt.setString(3, password);
                pstmt.setString(4, name);
                pstmt.setString(5, surname);
                pstmt.setInt(6,age);
                pstmt.setString(7,gender);
                pstmt.setString(8,address);
                int status=pstmt.executeUpdate();
                if(status==1)
                System.out.println("Successfully registered.");
                else
                System.out.println("Registration failed!");

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    public void registerEmployee(int id,String username,String password,String name,String surname,int age,String gender,String address) {
        String sql="INSERT INTO employee(id,username,password,name,surname,age,gender,address)"
    			+ "VALUES(?,?,?,?,?,?,?,?)";
    	
        try (Connection conn = this.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)
            )
        {
    		 	pstmt.setInt(1,id);
                pstmt.setString(2, username);
                pstmt.setString(3, password);
                pstmt.setString(4, name);
                pstmt.setString(5, surname);
                pstmt.setInt(6,age);
                pstmt.setString(7,gender);
                pstmt.setString(8,address);
                int status=pstmt.executeUpdate();
                if(status==1)
                System.out.println("Successfully registered.");
                else
                System.out.println("Registration failed!");

        } catch (SQLException e) {
                System.out.println(e.getMessage());
        }
    }
    
    	public boolean CheckCustomerUserName(String username) {
            boolean flag = false;
    		String query="SELECT * FROM users WHERE username ='"+username+"'";
            try (Connection conn = this.connect();
            ) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                if (rs.next()){
                    flag = true;
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return flag;
        }
        public boolean CheckEmployeeUserName(String username) {
            boolean flag = false;
            String query="SELECT * FROM employee WHERE username ='"+username+"'";
            try (Connection conn = this.connect();
            ) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                if (rs.next()){
                    flag = true;
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return flag;
        }
    	
    	public boolean CheckCustomerPassword(String password) {
            boolean flag = false;
    		String query="SELECT * FROM users WHERE password ='"+password+"'";
            try (Connection conn = this.connect()) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                if (rs.next()){
                    flag = true;
                }
            }

            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return flag;
        }
        public boolean loginCheck(String username, String password) {
            boolean flag = false;
            String query="SELECT * FROM users WHERE username ='"+username+"'AND password='"+password+"'";
            try (Connection conn = this.connect()) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                if (rs.next()){
                    flag = true;
                }
            }

            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return flag;
        }
        public boolean adminLoginCheck(String username, String password) {
            boolean flag = false;
            String query="SELECT * FROM users WHERE username ='"+username+"'AND password='"+password+"' AND admin=1";
            try (Connection conn = this.connect()) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                if (rs.next()){
                    flag = true;
                }
            }

            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return flag;
        }
        
    	

    public void insert(int id, String name, int point, String enter, String checkout) {
        String sql = "INSERT INTO reservation(id,name,room,enter_date,chekout_date) VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, point);
            pstmt.setString(4, enter);
            pstmt.setString(5, checkout);
            pstmt.executeUpdate();
            System.out.println(name + " added to database");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void addStaff(String name,String surname,int age,String gender,double salary,int offdays) {
    	String sql="INSERT INTO staff(name,surname,age,gender,salary,offdays) VALUES(?,?,?,?,?,?)";
    	try {
    		Connection c=this.connect();
			PreparedStatement stmt=c.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, surname);
			stmt.setInt(3, age);
			stmt.setString(4, gender);
			stmt.setDouble(5, salary);
			stmt.setInt(6, offdays);
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(frame3, "Successfully added!");
		} catch (SQLException e) {

			e.printStackTrace();
		}

    }
    public void deleteStaff(String name) {
    	String sql="DELETE FROM Staff where name=?";
    	try {
    		Connection c=this.connect();
			PreparedStatement stmt=c.prepareStatement(sql);
			stmt.setString(1, name);
			int choice=JOptionPane.YES_NO_OPTION;
			JOptionPane.showConfirmDialog(frame3,"Are you sure?");
			if(choice==JOptionPane.YES_OPTION) {
				int status=stmt.executeUpdate();
				if(status==1)
					JOptionPane.showMessageDialog(frame3, "Successfully deleted!");
				else
					JOptionPane.showMessageDialog(frame3, "Staff not found!","Failed",JOptionPane.ERROR_MESSAGE);
			}
    	} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    public void retrieveTableData() {
    	frame = new JFrame("Staff Info");
    	frame.setLayout(new BorderLayout());
    	DefaultTableModel model = new DefaultTableModel();
    	model.setColumnIdentifiers(columnNames);
    	tb = new JTable();
    	tb.setModel(model);
    	tb.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    	tb.setFillsViewportHeight(true);
    	JScrollPane scroll = new JScrollPane(tb);
    	scroll.setHorizontalScrollBarPolicy(
    	JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	scroll.setVerticalScrollBarPolicy(
    	JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    	String name= "";
    	String surname= "";
    	int age;
    	String gender = "";
    	double salary;
    	int num_of_off_days;
    	try {
    	Connection con = this.connect();
    	String sql = "select * from Staff";
    	PreparedStatement ps = con.prepareStatement(sql);
    	ResultSet rs = ps.executeQuery();
    	int i =0;
    	while(rs.next())
    	{
    	name = rs.getString("name");
    	surname= rs.getString("surname");
    	age= rs.getInt("age");
    	gender = rs.getString("gender");
    	salary=rs.getDouble("salary");
    	num_of_off_days=rs.getInt("offdays");
    	model.addRow(new Object[]{name,surname, age,gender,salary,num_of_off_days});
    	i++;
    	}
    	if(i <1)
    	{
    	JOptionPane.showMessageDialog(null, "No Record Found","Error",
    	JOptionPane.ERROR_MESSAGE);
    	}
    	if(i ==1)
    	{
    	System.out.println(i+" Record Found");
    	}
    	else
    	{
    	System.out.println(i+" Records Found");
    	}
    	}
    	catch(Exception ex)
    	{
    	JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
    	JOptionPane.ERROR_MESSAGE);
    	}
    	frame.add(scroll);
    	frame.setVisible(true);
    	frame.setSize(frameWidth,frameHeight);
    }
    public void retrieveRoomTableData() {
    	frame = new JFrame("Room Info");
    	frame.setLayout(new BorderLayout());
    	DefaultTableModel model = new DefaultTableModel();
    	model.setColumnIdentifiers(roomColumnNames);
    	tb = new JTable();
    	tb.setModel(model);
    	tb.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    	tb.setFillsViewportHeight(true);
    	JScrollPane scroll = new JScrollPane(tb);
    	scroll.setHorizontalScrollBarPolicy(
    	JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	scroll.setVerticalScrollBarPolicy(
    	JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    	String name= "";
    	
    	int room;
    	String enterDate = "";
    	String checkoutDate= "";
    	
    	
    	try {
    	Connection con = this.connect();
    	String sql = "select * from reservation";
    	PreparedStatement ps = con.prepareStatement(sql);
    	ResultSet rs = ps.executeQuery();
    	int i =0;
    	while(rs.next())
    	{
    	name = rs.getString("name");
    	room= rs.getInt("room");
    	
    	enterDate = rs.getString("enter_date");
    	checkoutDate = rs.getString("chekout_date");
    	model.addRow(new Object[]{name,room, enterDate,checkoutDate});
    	i++;
    	}
    	if(i <1)
    	{
    	JOptionPane.showMessageDialog(null, "No Record Found","Error",
    	JOptionPane.ERROR_MESSAGE);
    	}
    	if(i ==1)
    	{
    	System.out.println(i+" Record Found");
    	}
    	else
    	{
    	System.out.println(i+" Records Found");
    	}
    	}
    	catch(Exception ex)
    	{
    	JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
    	JOptionPane.ERROR_MESSAGE);
    	}
    	frame.add(scroll);
    	frame.setVisible(true);
    	frame.setSize(frameWidth,frameHeight);
    }

    public int getPoint(int id) {

        int x = 0;
        try (Connection conn = this.connect();
        ) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select id from reservation where room='" + id + "' ");
            while (rs.next()) {
                System.out.println("room " + id + " fll");
                x = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return x;
    }

    public void delete(int id) {


        try (Connection conn = this.connect();
        ) {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("delete  from reservation where room='" + id + "' ");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    String name;

    public String get(int id) {
        String query = "SELECT * FROM reservation where room='" + id + "'";
        try (Connection conn = this.connect();
        ) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                name = rs.getString("name");

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return name;
    }
    String enter_date;
    String checkout_date;
    public String getDate(int id) {
        String query = "SELECT * FROM reservation where room='" + id + "'";
        try (Connection conn = this.connect();
        ) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                enter_date = rs.getString("enter_date");
                checkout_date = rs.getString("chekout_date");

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if(enter_date!=null) {
        return "room is full between"+ " "+enter_date +"--"+ checkout_date;
        }else {
        	return "room empty";
        }
    }
    public String CheckDate(int id,String enter,String checkout) {
        String query = "SELECT * FROM reservation WHERE room='" + id + "' AND enter_date >= '"+ enter +"' AND\n" +
                "        chekout_date   <= '"+checkout+"'";
        try (Connection conn = this.connect();
        ) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                return "room is full";
            }else{
                return "room is empty";
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "error";
    }
    public List<Integer> CheckDatee(int id,String enter,String checkout) {
    	List<Integer> a = new ArrayList<>();
    	while(id<5) {
        String query = "SELECT * FROM reservation WHERE room='" + id + "' AND enter_date >= '"+ enter +"' AND\n" +
                "        chekout_date   <= '"+checkout+"'";
        try (Connection conn = this.connect();
        ) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                a.add(id);
            }else{
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
       
        id++;
    }
    	System.out.print("asd"+a);
		return a;
}
}


