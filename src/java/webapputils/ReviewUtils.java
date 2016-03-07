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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import webappbeans.Review;
import webappbeans.Reviewslist;

/**
 *
 * @author EVA Unit 02
 */
public class ReviewUtils {
    
    public static boolean insert(Review newReview)
    {
        boolean fail_check = true;
        
        Connection connection = null;
        PreparedStatement pst_revdb = null;  
        ResultSet rs_revdb = null;  

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
           
            String query = "INSERT INTO reviews (reviewerid, revieweeid, agreecount, disagreecount, reviewtext) "
                    + "VALUES(?,?,?,?,?)";
           
            pst_revdb = connection.prepareStatement(query);

            pst_revdb.setInt(1, newReview.getReviewer_id());
            pst_revdb.setInt(2, newReview.getReviewee_id());
            pst_revdb.setInt(3, 0);
            pst_revdb.setInt(4, 0);
            pst_revdb.setString(5, newReview.getReviewtext());

            pst_revdb.executeUpdate();
         }catch (Exception e){
        e.printStackTrace();
        fail_check = false;
        }
        finally{
             try{
                 rs_revdb.close();
                 pst_revdb.close();
                 connection.close();
             }
             catch(Exception e) {
                 e.printStackTrace();
             }
         }
           
        return fail_check;
    }
    
    public static boolean update(Review newReview)
    {
        boolean fail_check = true;
        
        Connection connection = null;
        PreparedStatement pst_revdb = null;  
        ResultSet rs_revdb = null;  

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
           
            String query = "UPDATE reviews "
                    + "SET reviewerid = ?, revieweeid = ?, agreecount = ?, disagreecount = ?, reviewtext = ? "
                    + "WHERE id = ?";
           
            pst_revdb = connection.prepareStatement(query);

            pst_revdb.setInt(1, newReview.getReviewer_id());
            pst_revdb.setInt(2, newReview.getReviewee_id());
            pst_revdb.setInt(3, newReview.getAgree_count());
            pst_revdb.setInt(4, newReview.getDisagree_count());
            pst_revdb.setString(5, newReview.getReviewtext());
            pst_revdb.setInt(6, newReview.getId());

            pst_revdb.executeUpdate();
         }catch (Exception e){
        e.printStackTrace();
        fail_check = false;
        }
        finally{
             try{
                 rs_revdb.close();
                 pst_revdb.close();
                 connection.close();
             }
             catch(Exception e) {
                 e.printStackTrace();
             }
         }
           
        return fail_check;
    }
    
    public static boolean delete(int reviewid)
    {
        boolean fail_check = true;
        
        Connection connection = null;
        PreparedStatement pst_revdb = null;  
        ResultSet rs_revdb = null;  

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
           
            String query = "DELETE FROM reviews WHERE id = ?";
           
            pst_revdb = connection.prepareStatement(query);

            pst_revdb.setInt(1, reviewid);

            pst_revdb.executeUpdate();
         }catch (Exception e){
        e.printStackTrace();
        fail_check = false;
        }
        finally{
             try{
                 rs_revdb.close();
                 pst_revdb.close();
                 connection.close();
             }
             catch(Exception e) {
                 e.printStackTrace();
             }
         }
           
        return fail_check;
    }
    
    public static boolean incrementAgree(int reviewid)
    {
        boolean fail_check = true;
        
        Connection connection = null;
        PreparedStatement pst_revdb = null;  
        ResultSet rs_revdb = null;  

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
           
            String query = "UPDATE reviews "
                    + "SET agreecount = agreecount + 1 "
                    + "WHERE id = ?";
           
            pst_revdb = connection.prepareStatement(query);

            pst_revdb.setInt(1, reviewid);

            pst_revdb.executeUpdate();
         }catch (Exception e){
        e.printStackTrace();
        fail_check = false;
        }
        finally{
             try{
                 rs_revdb.close();
                 pst_revdb.close();
                 connection.close();
             }
             catch(Exception e) {
                 e.printStackTrace();
             }
         }
           
        return fail_check;
    }
    
    public static boolean incrementDisagree(int reviewid)
    {
        boolean fail_check = true;
        
        Connection connection = null;
        PreparedStatement pst_revdb = null;  
        ResultSet rs_revdb = null;  

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
           
            String query = "UPDATE reviews "
                    + "SET disagreecount = disagreecount + 1 "
                    + "WHERE id = ?";
           
            pst_revdb = connection.prepareStatement(query);

            pst_revdb.setInt(1, reviewid);

            pst_revdb.executeUpdate();
         }catch (Exception e){
        e.printStackTrace();
        fail_check = false;
        }
        finally{
             try{
                 rs_revdb.close();
                 pst_revdb.close();
                 connection.close();
             }
             catch(Exception e) {
                 e.printStackTrace();
             }
         }
           
        return fail_check;
    }
    
    public static Review retrieveSingleReview(int id) 
    {
        Review review = new Review();
        
        Connection connection = null;
        PreparedStatement pst_revdb = null;  
        ResultSet rs_revdb = null;  

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
           
            String query = "SELECT * FROM reviews WHERE id = ?";

            pst_revdb = connection.prepareStatement(query);

            pst_revdb.setInt(1, id);

            rs_revdb = pst_revdb.executeQuery();

            while(rs_revdb.next()) 
            {
                review.setId(rs_revdb.getInt("id"));
                review.setReviewer_id(rs_revdb.getInt("reviewerid"));
                review.setReviewee_id(rs_revdb.getInt("revieweeid"));
                review.setAgree_count(rs_revdb.getInt("agreecount"));
                review.setDisagree_count(rs_revdb.getInt("disagreecount"));
                review.setReviewtext(rs_revdb.getString("reviewtext"));
            }

         }catch (Exception e){
        e.printStackTrace();
        }
        finally{
             try{
                 rs_revdb.close();
                 pst_revdb.close();
                 connection.close();
             }
             catch(Exception e) {
                 e.printStackTrace();
             }
         }
        
        return review;
    }
    
    public static Reviewslist reviewsOfYou(int id) throws SQLException
    {
        String query = "SELECT r.*, u.firstname, u.lastname " +
                            "FROM reviews r " +
                            "    INNER JOIN user u ON r.reviewerid=u.id " +
                            "WHERE revieweeid = ? " +
                            "ORDER BY r.agreecount DESC";
        
        return retrieveReviewList(id, query);
    }
    
    public static Reviewslist reviewsByYou(int id) throws SQLException
    {
        String query = "SELECT r.*, u.firstname, u.lastname " +
                            "FROM reviews r " +
                            "    INNER JOIN user u ON r.revieweeid=u.id " +
                            "WHERE reviewerid = ? " +
                            "ORDER BY r.agreecount DESC";
        return retrieveReviewList(id, query);
    }
    
    public static Reviewslist retrieveReviewList(int id, String query) throws SQLException
    {
        Reviewslist reviews = new Reviewslist();
        reviews.setOwnerid(id);
        
        List<Review> listOfReviews = new ArrayList();
        
        Connection connection = null;
        PreparedStatement pst_revdb = null;  
        ResultSet rs_revdb = null;  

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
           
           pst_revdb = connection.prepareStatement(query);
           
           pst_revdb.setInt(1, id);
           
           rs_revdb = pst_revdb.executeQuery();

           while(rs_revdb.next()) 
           {
               Review review = new Review();
               
               review.setId(rs_revdb.getInt("id"));
               review.setReviewer_id(rs_revdb.getInt("reviewerid"));
               review.setReviewee_id(rs_revdb.getInt("revieweeid"));
               review.setAgree_count(rs_revdb.getInt("agreecount"));
               review.setDisagree_count(rs_revdb.getInt("disagreecount"));
               review.setReviewtext(rs_revdb.getString("reviewtext"));
               review.setReviewer_name(rs_revdb.getString("firstname") + " " + rs_revdb.getString("lastname"));
               
               listOfReviews.add(review);
           }
           
           reviews.setReviews(listOfReviews);
        }catch (Exception e){
       e.printStackTrace();
       }
       finally{
            try{
                rs_revdb.close();
                pst_revdb.close();
                connection.close();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        return reviews;
    }
}
