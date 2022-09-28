package Connective;

import java.sql.*;
import java.sql.DriverManager;
import javax.swing.*;

public class Connective{

    public Connective(){

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/saiyagym", "gym", "gym2022");

            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery("select * from alumnos");
            
            while(rs.next()){
                System.out.print(rs.getInt("ID") + "     ");
                System.out.print(rs.getString("Nombre") + "\n");
            }
           
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "alertaa", 2);
        }
       

    }
}