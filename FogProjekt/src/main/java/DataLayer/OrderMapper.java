package DataLayer;

import FunctionLayer.Order;
import FunctionLayer.Product;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Oliver
 */
public class OrderMapper {
    
        public static void putUserInfoIntoOrders(User user) {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders (useremail, phonenumber, status) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPhoneNumber());
            ps.setString(3, "Pending");
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int getOrderID() {

        int newestInt = -1;

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT max(ordernumber) FROM orders";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                newestInt = rs.getInt("max(ordernumber)");
            }
        } catch (Exception e) {
        }

        return newestInt;
    }

    public void putOrderInDatabase(ArrayList<Product> ListofItems) {

        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO stykliste (ordernumber, titel, længde, antal, enhed, beskrivelse, pris) VALUES (?, ?, ? , ?, ?, ?, ?)";
            int orderID = this.getOrderID();
            PreparedStatement ps = con.prepareStatement(SQL);
            for (Product product : ListofItems) {
                ps.setInt(1, orderID);
                ps.setString(2, product.getName());
                ps.setInt(3, product.getLength());
                ps.setInt(4, product.getAmount());
                ps.setString(5, product.getUnit());
                ps.setString(6, product.getDescription());
                ps.setInt(7, product.getPrice());

                ps.executeUpdate();
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static ArrayList<Order> getOrderLines() {

        ArrayList<Order> ListofOrders = new ArrayList<Order>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT ordernumber, useremail, phonenumber, date, status FROM orders";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Order order = new Order(
                        rs.getInt("ordernumber"),
                        rs.getString("useremail"),
                        rs.getString("phonenumber"),
                        rs.getDate("date"),
                        rs.getString("status")
                );
                ListofOrders.add(order);
            }
        } catch (ClassNotFoundException | SQLException ex) {
        }
        return ListofOrders;
    }
    
    public static ArrayList<Product> getOrderDetails() {

        ArrayList<Product> productOrderDetails = new ArrayList<Product>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT ordernumber, titel, længde, antal, enhed, beskrivelse, pris FROM stykliste";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product(
                        rs.getInt("ordernumber"),
                        rs.getString("titel"),
                        rs.getInt("længde"),
                        rs.getInt("antal"),
                        rs.getString("enhed"),
                        rs.getString("beskrivelse"),
                        rs.getInt("pris")
                );
                productOrderDetails.add(product);
            }
        } catch (Exception e) {
        }
        return productOrderDetails;
    }
}
