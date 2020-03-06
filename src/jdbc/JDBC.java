/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.*;
/**
 *
 * @author dhanush
 */
public class JDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String SQL = "Select * From Customer";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver S/W not found...");
        }
        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ThogaKade", "root", "");
            Statement stm = (Statement) conn.createStatement();
            ResultSet rst = stm.executeQuery(SQL);
            while(rst.next()){
                String id=rst.getString("id");
                String name=rst.getString("name");
                String address=rst.getString("address");
                double salary=rst.getDouble("salary");
                System.out.println(id+"\t"+name+"\t"+address+"\t"+salary);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
