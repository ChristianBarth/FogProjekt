/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DataLayer.MaterialMapper;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oliver
 */
public class CalculationTests {

    private SingleFlatRoofCal sfrc = new SingleFlatRoofCal();
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
    public void testForPriceOfProduct() {

        assertEquals(mm.getProducts().get(0).getPrice(), 180);

    }

    @Test
    public void testForProductAmount() {

        ArrayList<Product> orderdetails = LogicFacade.getOrderDetails();
        assertEquals(orderdetails.get(0).getAmount(), 3);

        Product product = sfrc.getAmountPart0(780);
        assertEquals(product.getAmount(), 5);
    }

    @Test
    public void getTotalPriceForOrderline() {

        ArrayList<Product> orderdetails = LogicFacade.getOrderDetails();
        ArrayList<Order> orderlines = LogicFacade.getOrderLinesAdmin();
        ArrayList<Order> listoforders = LogicFacade.getTotalPriceForOrderLines(orderdetails, orderlines);
        int totalPrice = 0;
        int j = 0;
        for (int i = 1; i == orderdetails.get(j).getId(); j++) {
            totalPrice += orderdetails.get(j).getPrice();
        }
        assertEquals(listoforders.get(0).getTotalprice(), totalPrice);
    }
}
