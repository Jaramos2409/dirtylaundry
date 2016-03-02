/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapputils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import webappbeans.User;

/**
 *
 * @author nk5946
 */
public class UserUtils {
    
    
    public static boolean insertUser(User user) throws SQLException{
         Connection connection = null;
            int count = 0;
            Statement stmt = null;
           
             try {
                String dbURL = "jdbc:mysql://localhost:3306/cs4310";
                String username = "root";
                String password = "password";
                
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AuthUtils.class.getName()).log(Level.SEVERE, null, ex);
                }
                connection = DriverManager.getConnection(
                    dbURL, username, password);
                
                if (connection != null)
                {
                    System.out.println("Successful Connection");
                }
                
                stmt = connection.createStatement();
                String query = "INSERT into User (firstname, lastname, email, password)" +
                        "VALUES ('"+user.getFirstname() + "','" + user.getLastname() + "','" + user.getEmail() + "','" + user.getPassword() + "')";
                stmt.executeUpdate(query);
                
            }catch (Exception e){
                e.printStackTrace();
            }
            finally{
                 try{
                     stmt.close();
                     connection.close();
                 }
                 catch(Exception e) {
                     e.printStackTrace();}
        return false;
        }
    }
    
    
    
    public static User validateUser(String email, String password)
    {
        List<User>users = doQuery("select * from user where "
                + "email='" + email + "' and "
                + "password='" + password +"'"
        );
        return (users.size() == 1) ? users.get(0) : null;
    }
    
    public static List<User> doQuery(String query) {
            List<User> users = new ArrayList<>();
            Statement stmt = null;
            Connection connection = null;
            ResultSet rs;
             try {
                String dbURL = "jdbc:mysql://localhost:3306/cs4310";
                String username = "root";
                String password = "password";
                
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AuthUtils.class.getName()).log(Level.SEVERE, null, ex);
                }
                connection = DriverManager.getConnection(
                    dbURL, username, password);
                
                System.out.println("Successful Connection");
                stmt = connection.createStatement();
                
                rs = stmt.executeQuery(query);
        
                    while (rs.next())
                    {
                        
                        String pw = rs.getString("password");
                        String em = rs.getString("email");
                        int id = rs.getInt("id");
                        
                        User user = new User();
                        
                        user.setPassword(pw);
                        user.setEmail(em);
                        user.setId(id);
                        
                        users.add(user);
                        
                        System.out.println(em);
                    }
             }catch(Exception e){
             e.printStackTrace();}
     finally{
                 try{
                     stmt.close();
                     connection.close();
                 }
                 catch(Exception e) {
                     e.printStackTrace();}   
             
                    
            return users;
        }
}
}

