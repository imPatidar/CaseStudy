/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro.util;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author sneha
 */
public class DBConnection {
    
private static Connection conn;//private=encapsulation,static =to make a single connection.
    static  //static block runs only one time
    {
         try
     {
     Class.forName("oracle.jdbc.OracleDriver");
    conn=DriverManager.getConnection("jdbc:oracle:thin:@//Desktop-JHR5HNQ:1521/xe","student","student");//Desktop-JHR5HNQ:1521/xe=name of computer
                                                                                                    //system=username,oracle=password
    JOptionPane.showMessageDialog(null,"connected successfully");
     }
     catch(Exception e)
     {
     e.printStackTrace();
     JOptionPane.showMessageDialog(null,"cannot connected successfully");
     }
    }
    
    public static Connection getConnection()
    {
        return conn;
    }
    public static void closeConnection()
    {
        try
        {
            conn.close();
            JOptionPane.showMessageDialog(null,"disconnect successfully");
            
        }
        catch(Exception e)
        {e.printStackTrace();
        JOptionPane.showMessageDialog(null,"Exception"+e);
        }
    }
    
    
    
    
}