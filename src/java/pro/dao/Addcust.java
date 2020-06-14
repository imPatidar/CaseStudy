/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pro.bean.Customer;
import pro.util.DBConnection;

/**
 *
 * @author sneha
 */

    
  public class Addcust  
  {
 public static boolean addCust(Customer user)throws SQLException
    {
       String qry="Select *from  customer where custssnid=?";
        boolean status =true;
        Connection conn=DBConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement(qry);
        ps.setInt(1,user.getSsnid());
        ResultSet rs=ps.executeQuery();
        if(rs.next())
         status=false;
        else{
         qry="insert into customer values(?,?,?,?,?,?)";
          ps=conn.prepareStatement(qry);
           ps.setString(1,user.getCustname());
           ps.setInt(2,user.getAge());
           ps.setString(3,user.getCustaddr());
           ps.setString(4,user.getCity());
           ps.setString(5,user.getState());
           ps.setInt(6,user.getSsnid());
           
           int i=ps.executeUpdate();
        }
        return status;
            
        
        
    }
  }