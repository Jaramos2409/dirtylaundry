/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapputils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
                
                System.out.println("Successful Connection");
                stmt = connection.createStatement();
                String query = "INSERT into User (firstname, lastname, email, password)" +
                        "VALUES ('"+user.getFirstname() + "','" + user.getLastname() + "','" + user.getEmail() + "','" + user.getPassword() + "')";
                stmt.executeUpdate(query);
                
            }catch (Exception e){
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
    
    public static boolean updateUser(User user) throws SQLException{
         Connection connection = null;
            int count = 0;
            PreparedStatement stmt = null;
           
             try {
                String dbURL = "jdbc:mysql://localhost:3306/cs3520";
                String username = "root";
                String password = "password";
                
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AuthUtils.class.getName()).log(Level.SEVERE, null, ex);
                }
                connection = DriverManager.getConnection(
                    dbURL, username, password);
                
                System.out.println("test");
                System.out.println(user.getEmail());
                System.out.println(user.getPassword());
                System.out.println(user.getFirstname());
                System.out.println(user.getLastname());
                System.out.println(user.getId());
                System.out.println("test");
                
                stmt = connection.prepareStatement("update user set email = ?, password = ?, firstname = ?, lastname = ? where id = ?");
                stmt.setString(1, user.getEmail());
                stmt.setString(2, user.getPassword());
                stmt.setString(3, user.getFirstname());
                stmt.setString(4, user.getLastname());
                stmt.setInt(5, user.getId());
                
                stmt.executeUpdate();
    
            }catch (Exception e){
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
    
    public static List<User>getUsers()
    {
        return doQuery("select * from user");
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
                        int id = rs.getInt("id");
                        String f = rs.getString("firstname");
                        String l = rs.getString("lastname");
                        String pw = rs.getString("password");
                        String em = rs.getString("email");
                        
                        User user = new User();
                        
                        user.setId(id);
                        user.setFirstname(f);
                        user.setLastname(l);
                        user.setPassword(pw);
                        user.setEmail(em);
                        
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

