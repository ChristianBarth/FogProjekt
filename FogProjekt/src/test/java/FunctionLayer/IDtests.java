/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.Order;
import FunctionLayer.Product;
import java.util.ArrayList;
import java.util.Date;
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
public class IDtests {

    public IDtests() {
    }

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
    public void getProductsByID() {
        ArrayList<Order> orderlines = LogicFacade.getOrderLinesAdmin();
        assertEquals(orderlines.get(0).getOrdernumber(), 1);
        assertEquals(orderlines.get(0).getEmail(), "asgersh@hotmail.com");
        assertEquals(orderlines.get(0).getPhonenumber(), "20621159");
        assertTrue(orderlines.get(0).getStatus() != null);
    }
}
