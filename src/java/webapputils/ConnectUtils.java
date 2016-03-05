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
    

    private static String dbURL = "jdbc:mysql://localhost:3306/cs4310";
    private static String username = "root";
    private static String password = "password";

    private static ArrayList<Connect> getFriendRequests(String query)
    {
            ArrayList<Connect> friends = new ArrayList<>();
            Statement stmt = null;
            Connection connection = null;
            ResultSet rs;
             try {
                
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(
                    dbURL, username, password);
                
                System.out.println("Successful Connection");
                stmt = connection.createStatement();
                
                rs = stmt.executeQuery(query);
        
                    while (rs.next())
                    {
                        int id = rs.getInt("id");
                        int requestorid = rs.getInt("requestorid");
                        int requestedid = rs.getInt("requestedid");
                        int requestaccepted = rs.getInt("requestaccepted");
                        Connect connect = new Connect(id, requestorid, requestedid, requestaccepted);                        
                        friends.add(connect);
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
                        
            return friends;
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
    
    public static boolean acceptRequest(int connectionid) throws SQLException{
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
                
                stmt = connection.prepareStatement("UPDATE friends SET requestaccepted = ? WHERE id = ?");
                stmt.setInt(1, 1);
                stmt.setInt(2, connectionid);
                
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
    public static ArrayList<Connect> getFriends(int userid) throws SQLException{
        
            ArrayList<Connect> friends = new ArrayList<>();
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
                
                rs = stmt.executeQuery("select * from from friends where requestorid = '" + userid + "' OR requestedid = '" + userid + "' AND requestaccepted = '" + 1 + "'");
        
                    while (rs.next())
                    {
                        
                        int recordid = rs.getInt("id");
                        int requestorid = rs.getInt("requestorid");
                        int requestedid = rs.getInt("requestedid");
                        int requestaccepted = rs.getInt("requestaccepted");
                        
                        Connect connect = new Connect();
                        connect.setId(recordid);
                        connect.setRequestorid(requestorid);
                        connect.setRequestedid(requestedid);
                        connect.setRequestaccepted(requestaccepted);
                        
                        friends.add(connect);  
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
       
            return friends;
        }
    
}                       
}
    
    
    
