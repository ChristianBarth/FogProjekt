/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import FunctionLayer.Product;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author asger
 */
public class UserMapper {

    public static void registerUser(User user) {

        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO user (email, password, phonenumber, role)";
            PreparedStatement ps = con.prepareStatement(SQL);

            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getPhonenumber());
            ps.setString(4, user.getRole());

            ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }
}
