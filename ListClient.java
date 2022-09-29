package Visualizer;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;

public class ListClient extends JScrollPane{

    DefaultTableModel model;
    JTable db;
    Object [] array;

    public ListClient(){

        model = new DefaultTableModel() {
            public boolean isCellEditable(int fila, int columna){
                return false;
            }
        };

        db= new JTable(model);
        

            model.addColumn("ID");
            model.addColumn("Alumnos");
            model.addColumn("Telefono");
            model.addColumn("Fecha De Inicio");
            model.addColumn("Mensualidad");

            
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/saiyagym", "gym", "gym2022");

            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery("select * from alumnos");

            while(rs.next()){
                Object[] columna = new Object[5];
                columna[0] = rs.getObject("ID");
                columna[1] = rs.getObject("Nombre");
                columna[2]=rs.getObject("N_Telefono");
                columna[3] = rs.getObject("Fecha_de_Inicio");
                columna[4] = rs.getObject("Mensualidad") + "   Gs.";
                model.addRow(columna);
                db.getColumnModel().getColumn(0).setPreferredWidth(50);
                db.getColumnModel().getColumn(1).setPreferredWidth(400);
                db.getColumnModel().getColumn(2).setPreferredWidth(200);
                db.getColumnModel().getColumn(3).setPreferredWidth(200);
                db.getColumnModel().getColumn(4).setPreferredWidth(250);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

        add(db);

    }

    
}
