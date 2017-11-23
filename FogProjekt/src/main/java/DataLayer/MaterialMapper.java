package DataLayer;

import FunctionLayer.Order;
import FunctionLayer.Product;
import com.mysql.cj.api.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author PC
 */
public class MaterialMapper {

    public ArrayList<Product> getProducts() {

        ArrayList<Product> products = new ArrayList<Product>();
        Product product;

        try {

            Connection con = Connector.connection();
            String SQL = "SELECT name, length, unit, description, price FROM products";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                product = new Product(
                        rs.getString("name"),
                        rs.getInt("length"),
                        rs.getString("unit"),
                        rs.getString("description"),
                        rs.getInt("price")
                );
                products.add(product);
            }
        } catch (ClassNotFoundException | SQLException ex) {
        }
        return products;
    }

    public void createOrderNumber() {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders (customerid) VALUES (?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, 1);
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

    public ArrayList<Order> getOrdernumbersbyUserID(int userid) {

        ArrayList<Order> ListofOrders = new ArrayList<Order>();
        Order order;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT ordernumber, customerid FROM orders";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                order = new Order(
                        rs.getInt("ordernumber"),
                        rs.getInt("customerid")
                );
                ListofOrders.add(order);
            }
        } catch (ClassNotFoundException | SQLException ex) {
        }
        return ListofOrders;
    }
}
