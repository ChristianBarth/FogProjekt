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
    
        public static void putUserInfoIntoOrder(User user) {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orderlines (useremail, phonenumber, status) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPhoneNumber());
            ps.setString(3, "Pending");
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static int getOrderID() {

        int newestInt = -1;

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT max(ordernumber) FROM orderlines";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                newestInt = rs.getInt("max(ordernumber)");
            }
        } catch (Exception e) {
        }

        return newestInt;
    }

    public static void putListOfProductsIntoDatabase(ArrayList<Product> ListofItems) {

        try {
            Connection con = Connector.connection();

            int orderID = OrderMapper.getOrderID();
            String SQL = "INSERT INTO billofmaterials (ordernumber, title, length, amount, unit, description, price) VALUES (?, ?, ? , ?, ?, ?, ?)";
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
            String SQL = "SELECT ordernumber, useremail, phonenumber, date, status FROM orderlines";
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
            String SQL = "SELECT ordernumber, title, length, amount, unit, description, price FROM billofmaterials";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product(
                        rs.getInt("ordernumber"),
                        rs.getString("title"),
                        rs.getInt("length"),
                        rs.getInt("amount"),
                        rs.getString("unit"),
                        rs.getString("description"),
                        rs.getInt("price")
                );
                productOrderDetails.add(product);
            }
        } catch (Exception e) {
        }
        return productOrderDetails;
    }
    
    public static void updateStatusOnOrder(int ordernumber, String status){
        try { 
            Connection con = Connector.connection();
            String SQL = "UPDATE orderlines SET status=? WHERE ordernumber=" + ordernumber;
            PreparedStatement ps = con.prepareStatement(SQL);
            
            ps.setString(1, status);
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
    }
}
