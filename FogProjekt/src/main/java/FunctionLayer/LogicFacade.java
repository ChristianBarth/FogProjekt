/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DataLayer.OrderMapper;
import DataLayer.UserMapper;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class LogicFacade {

    // ArrayList of all products without "skur" from the database.
    public static ArrayList<Product> getListOfProductsNoSkur(double length, double width) {
        ArrayList<Product> orders = SingleFlatRoofCal.getProductsNoSkur(length, width);
        return orders;
    }

    // ArrayList of all products with "skur" from the database.
    public static ArrayList<Product> getListOfProductsWithSkur(double length, double width) {
        ArrayList<Product> orders = SingleFlatRoofCal.getProductsWithSkur(length, width);
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

    public static String getSideCarportDrawingWithSkur(double length, int height) {
        return SVGDrawingFromSide.BuildSideCarportWithSkur(length, height);
    }

    public static String getTopCarportDrawing(double length, int width) {
        return SVGDrawingFromTop.BuildTopCarport(length, width);
    }

    public static String getTopCarportDrawingWithSkur(double length, int width) {
        return SVGDrawingFromTop.BuildTopCarport(length, width);
    }

    // Orderlines and orderdetails. Admin has access to orderdetails.
    public static ArrayList<Order> getOrderLinesAdmin() {
        return OrderMapper.getOrderLines();
    }

    public static ArrayList<Product> getOrderDetails() {
        return OrderMapper.getOrderDetails();
    }

    // Orderdetails by id
    public static ArrayList<Product> getOrderProductsFromID(int number, ArrayList<Product> orderdetails) {
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

    public static int getTotalPriceForDetails(int number, ArrayList<Product> orderdetails) {
        int totalPrice = 0;
        for (int i = 0; i < orderdetails.size(); i++) {
            if (number == orderdetails.get(i).getId()) {
                totalPrice += orderdetails.get(i).getPrice();
            }
        }
        return totalPrice;
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

    // User login and register
    public static void createUser(User user) {
        UserMapper.createUser(user);
    }

    public static User login(String email, String password) throws LoginException {
        return UserMapper.login(email, password);
    }

    public static ArrayList<Order> getTotalPriceForOrderWithoutSkur(ArrayList<Product> orderdetails, ArrayList<Order> orderlines) {

        ArrayList<Order> orderlist = new ArrayList<Order>();
        int numberindexstart = 0;
        int numberindexstop = 17;
        int indexmeterfororderline = 0;

        for (int i = 0; i < orderlines.size(); i++) {
            Order order = new Order(
                    orderlines.get(i).getOrdernumber(),
                    orderlines.get(i).getEmail(),
                    orderlines.get(i).getPhonenumber(),
                    orderlines.get(i).getTime(),
                    orderlines.get(i).getStatus(),
                    LogicFacade.getTotalPriceForEachOrder(numberindexstart, numberindexstop, indexmeterfororderline, orderdetails, orderlines)
            );
            orderlist.add(order);
            numberindexstart += 17;
            numberindexstop += 17;
            indexmeterfororderline += 1;
        }
        return orderlist;
    }

    public static ArrayList<Order> getTotalPriceForOrderWithSkur(ArrayList<Product> orderdetails, ArrayList<Order> orderlines) {

        ArrayList<Order> orderlist = new ArrayList<Order>();
        int numberindexstart = 0;
        int numberindexstop = 29;
        int indexmeterfororderline = 0;

        for (int i = 0; i < orderlines.size(); i++) {
            Order order = new Order(
                    orderlines.get(i).getOrdernumber(),
                    orderlines.get(i).getEmail(),
                    orderlines.get(i).getPhonenumber(),
                    orderlines.get(i).getTime(),
                    orderlines.get(i).getStatus(),
                    LogicFacade.getTotalPriceForEachOrder(numberindexstart, numberindexstop, indexmeterfororderline, orderdetails, orderlines)
            );
            orderlist.add(order);
            numberindexstart += 29;
            numberindexstop += 29;
            indexmeterfororderline += 1;
        }
        return orderlist;
    }

    public static int getTotalPriceForEachOrder(int numberindexstart, int numberindexstop, int indexmeterfororderline, ArrayList<Product> orderdetails, ArrayList<Order> orderlines) {

        int totalPrice = 0;

        for (int i = numberindexstart; i < numberindexstop; i++) {
            if (orderlines.get(indexmeterfororderline).getOrdernumber() == orderdetails.get(i).getId()) {
                totalPrice += orderdetails.get(i).getPrice();
            }
        }
        return totalPrice;
    }

    public static void putStatusIntoDatabase(int ordernumber, String status) {

        OrderMapper.updateStatusOnOrder(ordernumber, status);

    }
}
