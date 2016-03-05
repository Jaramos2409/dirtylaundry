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
 * @author EVA Unit 02
 */
public class SearchUtils {
    
    
    public static List<User> getSearchResults(String k, String s)
    {
        List<User> emptyResult = new ArrayList();
        
        String keyword = injectProtect(k);
        
        if ("Name".equals(s)) return nameSearch(keyword);
        else if("Email".equals(s)) return emailSearch(keyword);
        else if("City, State".equals(s)) return locationSearch(keyword);
        else if("Relationship".equals(s)) return relationSearch(keyword);
        else if("Phone Number".equals(s)) return phoneSearch(keyword);
        else return emptyResult;
    }
    
    private static String injectProtect (String keyword) 
    {
        return keyword.replaceFirst("\\s+$", "")
                    .replace("!", "!!")
                    .replace("%", "!%")
                    .replace("_", "!_")
                    .replace("[", "![");
    }
    
    private static String spaceChk(String keyword)
    {
        if (keyword != "") 
        {
             return keyword+"%";
        } 
        else
            return keyword;
    }
    
    private static List<User> nameSearch(String key) 
    {
        List<User> searchResults = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement pst = null;  
        ResultSet rs = null;  

        String dbURL = "jdbc:mysql://localhost:3306/cs4310";
        String driver = "com.mysql.jdbc.Driver";
        String username = "root";
        String password = "password";

        try {
           try {
               Class.forName(driver);
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(AuthUtils.class.getName()).log(Level.SEVERE, null, ex);
           }

           connection = DriverManager.getConnection(
               dbURL, username, password);
           if (connection != null)
           {
               System.out.println("Successful Connection");
           }
           
           String query = "SELECT id, firstname, lastname, gender, city, state, relationship " +
                        "FROM user " +
                        "WHERE concat_ws(' ',firstname , lastname) LIKE ? " +
                        "ORDER BY " +
                            "CASE " +
                                "WHEN firstname LIKE ? THEN 1 " +
                                "WHEN lastname LIKE ? THEN 2 " +
                                "WHEN firstname LIKE ? THEN 3 " +
                                "WHEN lastname LIKE ? THEN 4 " +
                                "ELSE 5 " +
                            "END ";

           pst = connection.prepareStatement(query);

           pst.setString(1, "%"+key+"%");
           pst.setString(2, key +"%");
           pst.setString(3, key +"%");
           pst.setString(4, "%"+key);
           pst.setString(5, "%"+key);

           rs = pst.executeQuery();

           while(rs.next())
           {
               User result = new User();

               result.setId(rs.getInt(1));
               result.setFirstname(rs.getString(2));
               result.setLastname(rs.getString(3));
               result.setGender(rs.getString(4));
               result.setCity(rs.getString(5));
               result.setState(rs.getString(6));
               result.setRelationship(rs.getString(7));

               searchResults.add(result);
           }

       }catch (Exception e){
           e.printStackTrace();
       }
       finally{
            try{
                rs.close();
                pst.close();
                connection.close();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    return searchResults;
    }
    
    private static List<User> emailSearch(String key) 
    {
        List<User> searchResults = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement pst = null;  
        ResultSet rs = null;  

        String dbURL = "jdbc:mysql://localhost:3306/cs4310";
        String driver = "com.mysql.jdbc.Driver";
        String username = "root";
        String password = "password";

        try {
           try {
               Class.forName(driver);
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(AuthUtils.class.getName()).log(Level.SEVERE, null, ex);
           }

           connection = DriverManager.getConnection(
               dbURL, username, password);
           if (connection != null)
           {
               System.out.println("Successful Connection");
           }
           
           String query = "SELECT id, firstname, lastname, gender, city, state, relationship " +
                        "FROM user " +
                        "WHERE email LIKE ? " +
                        "ORDER BY " +
                            "CASE " +
                                "WHEN email LIKE ? THEN 1 " +
                                "WHEN email LIKE ? THEN 3 " +
                                "ELSE 2 " +
                            "END ";

           pst = connection.prepareStatement(query);

           pst.setString(1, "%"+key+"%");
           pst.setString(2, key +"%");
           pst.setString(3, "%"+key);

           rs = pst.executeQuery();

           while(rs.next())
           {
               User result = new User();

               result.setId(rs.getInt(1));
               result.setFirstname(rs.getString(2));
               result.setLastname(rs.getString(3));
               result.setGender(rs.getString(4));
               result.setCity(rs.getString(5));
               result.setState(rs.getString(6));
               result.setRelationship(rs.getString(7));

               searchResults.add(result);
           }

       }catch (Exception e){
           e.printStackTrace();
       }
       finally{
            try{
                rs.close();
                pst.close();
                connection.close();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    return searchResults;
    }
    
    private static List<User> locationSearch(String key) 
    {
        List<User> searchResults = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement pst = null;  
        ResultSet rs = null;  

        String dbURL = "jdbc:mysql://localhost:3306/cs4310";
        String driver = "com.mysql.jdbc.Driver";
        String username = "root";
        String password = "password";

        try {
           try {
               Class.forName(driver);
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(AuthUtils.class.getName()).log(Level.SEVERE, null, ex);
           }

           connection = DriverManager.getConnection(
               dbURL, username, password);
           if (connection != null)
           {
               System.out.println("Successful Connection");
           }
           
           String query = "SELECT id, firstname, lastname, gender, city, state, relationship " +
                        "FROM user " +
                        "WHERE concat_ws(', ', city , state) LIKE ? " +
                        "ORDER BY " +
                            "CASE " +
                                "WHEN city LIKE ? THEN 1 " +
                                "WHEN state LIKE ? THEN 2 " +
                                "WHEN city LIKE ? THEN 3 " +
                                "WHEN state LIKE ? THEN 4 " +
                                "ELSE 5 " +
                            "END ";

           pst = connection.prepareStatement(query);

           pst.setString(1, "%"+key+"%");
           pst.setString(2, key +"%");
           pst.setString(3, key +"%");
           pst.setString(4, "%"+key);
           pst.setString(5, "%"+key);

           rs = pst.executeQuery();

           while(rs.next())
           {
               User result = new User();

               result.setId(rs.getInt(1));
               result.setFirstname(rs.getString(2));
               result.setLastname(rs.getString(3));
               result.setGender(rs.getString(4));
               result.setCity(rs.getString(5));
               result.setState(rs.getString(6));
               result.setRelationship(rs.getString(7));

               searchResults.add(result);
           }

       }catch (Exception e){
           e.printStackTrace();
       }
       finally{
            try{
                rs.close();
                pst.close();
                connection.close();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    return searchResults;
    }
    
    private static List<User> relationSearch(String key) 
    {
        List<User> searchResults = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement pst = null;  
        ResultSet rs = null;  

        String dbURL = "jdbc:mysql://localhost:3306/cs4310";
        String driver = "com.mysql.jdbc.Driver";
        String username = "root";
        String password = "password";

        try {
           try {
               Class.forName(driver);
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(AuthUtils.class.getName()).log(Level.SEVERE, null, ex);
           }

           connection = DriverManager.getConnection(
               dbURL, username, password);
           if (connection != null)
           {
               System.out.println("Successful Connection");
           }
           
           String query = "SELECT id, firstname, lastname, gender, city, state, relationship " +
                        "FROM user " +
                        "WHERE relationship LIKE ? " +
                        "ORDER BY " +
                            "CASE " +
                                "WHEN relationship LIKE ? THEN 1 " +
                                "WHEN relationship LIKE ? THEN 3 " +
                                "ELSE 2 " +
                            "END ";

           pst = connection.prepareStatement(query);

           pst.setString(1, "%"+key+"%");
           pst.setString(2, key +"%");
           pst.setString(3, "%"+key);

           rs = pst.executeQuery();

           while(rs.next())
           {
               User result = new User();

               result.setId(rs.getInt(1));
               result.setFirstname(rs.getString(2));
               result.setLastname(rs.getString(3));
               result.setGender(rs.getString(4));
               result.setCity(rs.getString(5));
               result.setState(rs.getString(6));
               result.setRelationship(rs.getString(7));

               searchResults.add(result);
           }

       }catch (Exception e){
           e.printStackTrace();
       }
       finally{
            try{
                rs.close();
                pst.close();
                connection.close();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    return searchResults;
    }
    
    private static List<User> phoneSearch(String key) 
    {
        List<User> searchResults = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement pst = null;  
        ResultSet rs = null;  

        String dbURL = "jdbc:mysql://localhost:3306/cs4310";
        String driver = "com.mysql.jdbc.Driver";
        String username = "root";
        String password = "password";

        try {
           try {
               Class.forName(driver);
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(AuthUtils.class.getName()).log(Level.SEVERE, null, ex);
           }

           connection = DriverManager.getConnection(
               dbURL, username, password);
           if (connection != null)
           {
               System.out.println("Successful Connection");
           }
           
           String query = "SELECT id, firstname, lastname, gender, city, state, relationship " +
                        "FROM user " +
                        "WHERE phone LIKE ? " +
                        "ORDER BY " +
                            "CASE " +
                                "WHEN phone LIKE ? THEN 1 " +
                                "WHEN phone LIKE ? THEN 3 " +
                                "ELSE 2 " +
                            "END ";

           pst = connection.prepareStatement(query);

           pst.setString(1, "%"+key+"%");
           pst.setString(2, key +"%");
           pst.setString(3, "%"+key);

           rs = pst.executeQuery();

           while(rs.next())
           {
               User result = new User();

               result.setId(rs.getInt(1));
               result.setFirstname(rs.getString(2));
               result.setLastname(rs.getString(3));
               result.setGender(rs.getString(4));
               result.setCity(rs.getString(5));
               result.setState(rs.getString(6));
               result.setRelationship(rs.getString(7));

               searchResults.add(result);
           }

       }catch (Exception e){
           e.printStackTrace();
       }
       finally{
            try{
                rs.close();
                pst.close();
                connection.close();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    return searchResults;
    }
}