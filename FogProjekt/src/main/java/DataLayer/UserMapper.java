/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import FunctionLayer.MessageException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author asger
 */
public class UserMapper {

    public static void createUser(User user) throws MessageException {

        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO users (email, password, phonenumber, role) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL);

            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getPhoneNumber());
            ps.setString(4, user.getRole());

            ps.executeUpdate();
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new MessageException("Could not create user, please fill out all the text fields");
        }
    }

    public static User login( String email, String password ) throws MessageException {
        try {
            
            Connection con = Connector.connection();
            String SQL = "SELECT phonenumber, role FROM users WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);

            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String phoneNumber = rs.getString("phonenumber");
                String role = rs.getString("role");
                User user = new User(email, password, phoneNumber, role);
                return user;
            } else {
                throw new MessageException("Could not validate user");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            throw new MessageException(ex.getMessage());
        }
    }
}
