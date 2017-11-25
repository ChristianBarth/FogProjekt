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
        try {

            Connection con = Connector.connection();
            String SQL = "SELECT name, length, unit, description, price FROM products";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product(
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

    public static ArrayList<Product> getProductOrders() {

        ArrayList<Product> productOrders = new ArrayList<Product>();
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
                productOrders.add(product);
            }
        } catch (Exception e) {
        }
        return productOrders;
    }
}
