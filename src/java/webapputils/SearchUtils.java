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
    
    
    public static List<User> getSearchResults(String k)
    {
        List<User> searchResults = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement pst = null;  
        ResultSet rs = null;  
        
        String dbURL = "jdbc:mysql://localhost:3306/cs4310";
        String driver = "com.mysql.jdbc.Driver";
        String username = "root";
        String password = "password";
        String keywords = k;
        keywords = keywords.replace("!", "!!")
                           .replace("%", "!%")
                           .replace("_", "!_")
                           .replace("[", "![");
        String query = "SELECT id, firstname, lastname FROM user WHERE CONCAT_WS('', firstname, lastname) LIKE ?";
        
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
            pst.setString(1,"%"+keywords+"%");
            
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
}
