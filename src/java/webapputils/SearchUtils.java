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
    
    
    public static List<User> getSearchResults(String fn, String ln, String gen, String em, String c, String st,
            String bday, String ethn, String ed, String occ, String rel, String ph)
    {
        List<User> searchResults = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement pst = null;  
        ResultSet rs = null;  
        
        String dbURL = "jdbc:mysql://localhost:3306/cs4310";
        String driver = "com.mysql.jdbc.Driver";
        String username = "root";
        String password = "password";
        
        String firstname = spaceChk(injectProtect(fn));
        String lastname = spaceChk(injectProtect(ln));
        String gender = spaceChk(injectProtect(gen));
        String email = spaceChk(injectProtect(em));
        String city = spaceChk(injectProtect(c));
        String state = spaceChk(injectProtect(st));
        String birthday = spaceChk(injectProtect(bday));
        String ethnicity = spaceChk(injectProtect(ethn));
        String education = spaceChk(injectProtect(ed));
        String occupation = spaceChk(injectProtect(occ));
        String relationship = spaceChk(injectProtect(rel));
        String phone = spaceChk(injectProtect(ph));
        
        String query = "SELECT id, firstname, lastname, gender, email, city, state, birthday, ethnicity, education, "
                + "occupation, relationship, phone"
                + " FROM user"
                + " WHERE firstname LIKE ? OR "
                + "lastname LIKE ? OR "
                + "gender LIKE ? OR "
                + "email LIKE ? OR "
                + "city LIKE ? OR "
                + "state LIKE ? OR "
                + "birthday LIKE ? OR "
                + "ethnicity LIKE ? OR "
                + "education LIKE ? OR "
                + "occupation LIKE ? OR "
                + "relationship LIKE ? OR "
                + "phone LIKE ?";  
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

            pst = connection.prepareStatement(query);
            
            pst.setString(1, firstname);
            pst.setString(2, lastname);
            pst.setString(3, gender);
            pst.setString(4, email);
            pst.setString(5, city);
            pst.setString(6, state);
            pst.setString(7, birthday);
            pst.setString(8, ethnicity);
            pst.setString(9, education);
            pst.setString(10, occupation);
            pst.setString(11, relationship);
            pst.setString(12, phone);
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                User result = new User();
                
                result.setId(rs.getInt(1));
                result.setFirstname(rs.getString(2));
                result.setLastname(rs.getString(3));
                
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
    
    private static String injectProtect (String keyword) 
    {
        return keyword.replace("!", "!!")
                    .replace("%", "!%")
                    .replace("_", "!_")
                    .replace(" ", "")
                    .replace("[", "![");
    }
    
    private static String spaceChk(String keyword)
    {
        if (keyword != "") 
        {
             return "%"+keyword+"%";
        } 
        else
            return keyword;
    }
}