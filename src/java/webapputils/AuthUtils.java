/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapputils;

import java.sql.*;
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
public class AuthUtils {
	public static User authorize(String email, String pword){
            User user = null;
            
		if(email != null && !email.isEmpty() && pword!= null && !pword.isEmpty()) {
                    user = new User();
                    user.setEmail(email);
                    user.setPassword(pword);
		}
                return user;
	}
        
        
}
