package DataLayer;

import FunctionLayer.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
            ex.printStackTrace();
        }
        return products;
    }
}
