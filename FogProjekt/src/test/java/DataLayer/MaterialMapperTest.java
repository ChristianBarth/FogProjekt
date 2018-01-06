package DataLayer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import FunctionLayer.Product;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PC
 */
public class MaterialMapperTest {

    private MaterialMapper mm = new MaterialMapper();

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getProductsFromDatabase() {
        ArrayList<Product> products = new ArrayList<Product>();
        products.addAll(mm.getProducts());
        assertEquals(products.size(), 29);
        System.out.println("Size af produkter i dataabasen: " + products.size());
    }
}
