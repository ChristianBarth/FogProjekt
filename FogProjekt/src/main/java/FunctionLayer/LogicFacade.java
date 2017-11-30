/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DataLayer.MaterialMapper;
import DataLayer.OrderMapper;
import DataLayer.UserMapper;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class LogicFacade {

    // ArrayList of all products from the database.
    public static ArrayList<Product> getListOfProducts(double length, double width) {
        ArrayList<Product> orders = SingleFlatRoofCal.getProductList(length, width);
        return orders;
    }

    // Put the orderlines into the database.
    public static void PutOrderInDatabase(User user, ArrayList<Product> ListofItems) {
        OrderMapper.putUserInfoIntoOrders(user);
        OrderMapper om = new OrderMapper();
        om.putOrderInDatabase(ListofItems);
    }

    // Flat Drawings
    public static String getSideCarportDrawing(double length, int height) {
        return SVGDrawingFromSide.BuildSideCarport(length, height);
    }

    public static String getTopCarportDrawing(double length, int width) {
        return SVGDrawingFromTop.BuildTopCarport(length, width);
    }

    // Orderlines. Admin has access to orderdetails.
    public static ArrayList<Order> getOrderLinesAdmin() {
        return OrderMapper.getOrderLines();
    }

    public static ArrayList<Product> getOrderDetails() {
        return OrderMapper.getOrderDetails();
    }

    public static ArrayList<Order> getOrderLinesCustomer(User user) {

        ArrayList<Order> userorderlist = new ArrayList<Order>();
        ArrayList<Order> allorders = OrderMapper.getOrderLines();

        for (int i = 0; i < allorders.size(); i++) {
            if (user.getEmail().equals(allorders.get(i).getEmail())) {
                Order order = new Order(
                        allorders.get(i).getOrdernumber(),
                        allorders.get(i).getEmail(),
                        allorders.get(i).getPhonenumber(),
                        allorders.get(i).getTime(),
                        allorders.get(i).getStatus()
                );
                userorderlist.add(order);
            }
        }
        return userorderlist;
    }

    // Orderdetails by id
    public static ArrayList<Product> getOrderProductsFromID(int number, ArrayList<Order> orderlines, ArrayList<Product> orderdetails) {
        ArrayList<Product> ordersofid = new ArrayList<Product>();
        for (int i = 0; i < orderdetails.size(); i++) {
            if (number == orderdetails.get(i).getId()) {
                Product product = new Product(
                        orderdetails.get(i).getName(),
                        orderdetails.get(i).getLength(),
                        orderdetails.get(i).getAmount(),
                        orderdetails.get(i).getUnit(),
                        orderdetails.get(i).getDescription(),
                        orderdetails.get(i).getPrice()
                );
                ordersofid.add(product);
            }
        }
        return ordersofid;
    }

    // User login and register
    public static void createUser(User user) {
        UserMapper.createUser(user);
    }

    public static User login(String email, String password) throws LoginException {
        return UserMapper.login(email, password);
    }
}
