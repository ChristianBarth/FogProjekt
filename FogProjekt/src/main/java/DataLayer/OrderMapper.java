package DataLayer;

import FunctionLayer.Order;
import FunctionLayer.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Oliver
 */
public class OrderMapper {
    
        public static void createEmailID() {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders (useremail) VALUES (?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, "admin@mail.dk");
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
            String SQL = "SELECT ordernumber, useremail FROM orders";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Order order = new Order(
                        rs.getInt("ordernumber"),
                        rs.getString("useremail")
                );
                ListofOrders.add(order);
            }
        } catch (ClassNotFoundException | SQLException ex) {
        }
        return ListofOrders;
    }
    
}
