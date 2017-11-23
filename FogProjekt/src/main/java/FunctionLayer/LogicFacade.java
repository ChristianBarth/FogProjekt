/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DataLayer.OrderMapper;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class LogicFacade {

    public static ArrayList<Product> getListOfItems(double length, double width) {
        SingleFlatRoofCal calculate = new SingleFlatRoofCal();
        ArrayList<Product> orders = calculate.getProductList(length, width);
        return orders;
    }

    public static void PutOrderInDatabase(ArrayList<Product> ListofItems) {
        OrderMapper.createOrderNumber();
        OrderMapper om = new OrderMapper();
        om.putOrderInDatabase(ListofItems);
    }

    public static ArrayList<Order> getOrders() {
        return OrderMapper.getOrderLines();
    }
}
