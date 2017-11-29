/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import FunctionLayer.LoginException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Christian Kolz Barth
 */
public class UserMapper {
    
    public static User login( String email, String password ) throws LoginException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT role FROM user WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            
            if( rs.next() ) {
                String role = rs.getString( "role" );
                User user = new User( email, password, role );
                return user;
            } else {
                throw new LoginException( "Could not validate user" );
            }
            
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginException(ex.getMessage());
        }
    }
    
}
