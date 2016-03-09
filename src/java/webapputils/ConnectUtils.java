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
import webappbeans.Connect;
/**
 *
 * @author nk5946
 */
public class ConnectUtils {
    

    public static List<User> getFriendsRequests(int userid) throws SQLException{
        
            List<User> friendrequests = new ArrayList<>();
            PreparedStatement stmt = null;
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
                
                
                
                stmt = connection.prepareStatement("Select * from friends where requestedid = ? AND requestaccepted = ?");
                stmt.setInt(1, userid);
                stmt.setInt(2, 0);
                
                rs = stmt.executeQuery();
                    while (rs.next())
                    {
                        int recordid = rs.getInt("id");
                        int requestorid = rs.getInt("requestorid");
                        int requestedid = rs.getInt("requestedid");
                        int requestaccepted = rs.getInt("requestaccepted");

                        friendrequests.add(filterConnections(requestorid));
                       
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
       
            return friendrequests;
        }
    
}
 
    public static boolean Connect(int requestorid, int requestedid) throws SQLException{
         Connection connection = null;
            int count = 0;
            PreparedStatement stmt = null;
           
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
                
                
                stmt = connection.prepareStatement("Insert into Friends SET requestorid = ?, requestedid = ?, requestaccepted = ?");
                stmt.setInt(1, requestorid);
                stmt.setInt(2, requestedid);
                stmt.setInt(3, 0);
                
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
    
    public static boolean acceptRequest(int requestorid, int requestedid) throws SQLException{
         Connection connection = null;
            int count = 0;
            PreparedStatement stmt = null;
           
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
                
                
                stmt = connection.prepareStatement("Update friends SET requestaccepted = ? Where requestorid = ? AND requestedid = ?");
                stmt.setInt(1, 1);
                stmt.setInt(2, requestorid);
                stmt.setInt(3, requestedid);
                
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
    public static List<User> getFriends(int userid) throws SQLException{
        
            List<User> friendslist = new ArrayList<>();
            PreparedStatement stmt = null;
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
                
                
                stmt = connection.prepareStatement("Select * from friends where (requestorid = ? OR requestedid = ?) AND requestaccepted = ?");
                stmt.setInt(1, userid);
                stmt.setInt(2, userid);
                stmt.setInt(3, 1);
                
                rs = stmt.executeQuery();
                    while (rs.next())
                    {
                        int recordid = rs.getInt("id");
                        int requestorid = rs.getInt("requestorid");
                        int requestedid = rs.getInt("requestedid");
                        int requestaccepted = rs.getInt("requestaccepted");
                        
                        Integer ror = new Integer(requestorid);
                        Integer red = new Integer(requestedid);
                        Integer uid = new Integer(userid);
                        
                        if(ror.equals(uid))
                        {
                            friendslist.add(filterConnections(requestedid));
                        }
                        else
                        {
                            friendslist.add(filterConnections(requestorid));
                        }
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
       
            return friendslist;
        }
    
}              

    public static User filterConnections(int friendid)
    {
        Statement stmt = null;
            Connection connection = null;
            User user = new User();
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
                
                rs = stmt.executeQuery("select * from user where id = '" + friendid + "'");
                while(rs.next())
                {
                        int id = rs.getInt("id");
                        String f = rs.getString("firstname");
                        String l = rs.getString("lastname");
                        String pw = rs.getString("password");
                        String em = rs.getString("email");
                        String c = rs.getString("city");
                        String bd = rs.getString("birthday");
                        String eth = rs.getString("ethnicity");
                        String e = rs.getString("education");
                        String o = rs.getString("occupation");
                        String r = rs.getString("relationship");
                        String p = rs.getString("phone");
                        String st =rs.getString("state");
                        String g = rs.getString("gender");
                        String ab = rs.getString("about");
                        
                        user.setId(id);
                        user.setFirstname(f);
                        user.setLastname(l);
                        user.setPassword(pw);
                        user.setEmail(em);
                        user.setCity(c);
                        user.setBirthday(bd);
                        user.setEthnicity(eth);
                        user.setEducation(e);
                        user.setOccupation(o);
                        user.setRelationship(r);
                        user.setPhone(p);
                        user.setGender(g);
                        user.setState(st);
                        user.setAbout(ab);
                        System.out.print(user.getFirstname());
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
        }
        System.out.print(user.getFirstname());
        return user;
    }

}
    
    
    
