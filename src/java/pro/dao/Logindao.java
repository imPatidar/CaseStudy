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
import pro.bean.Loginuserstore;
import pro.util.DBConnection;

/**
 *
 * @author sneha
 */
public class Logindao {
    public static boolean verifyUser(Loginuserstore login)throws SQLException
    {   boolean userf=false;
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select login,password from userstore where login=? and password=?");
        ps.setString(1,login.getName());
        ps.setString(2,login.getPass());
        ResultSet r=ps.executeQuery();
       if(r !=null && r.next())
       {
           userf=true;
           
       }
       else
           userf=false;
       return userf;
}
}
