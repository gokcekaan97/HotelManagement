package com.company;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class database {
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
}


