package DataLayer;

import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author PC
 */
public class UserMapper {

    public static void createUser(User user) {

        try {

            Connection con = Connector.connection();
            String SQL = "INSERT INTO user (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL);

            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.executeUpdate();

            ps.close();
            con.close();

        } catch (Exception e) {
        }

    }

    public static User login(String email, String password) {
        
        User account = new User();
        
        try {
            
            Connection con = Connector.connection();
            String SQL = "SELECT role FROM user WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                String role = rs.getString("role");
                User user = new User(email, password, role);
                user = account;
            }
        } catch (Exception e) {
        }
        return account;
    }
}
