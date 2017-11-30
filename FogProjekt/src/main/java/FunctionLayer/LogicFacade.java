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

    public static ArrayList<Product> getListOfProducts(double length, double width) {
        ArrayList<Product> orders = SingleFlatRoofCal.getProductList(length, width);
        return orders;
    }

    public static void PutOrderInDatabase(ArrayList<Product> ListofItems) {
        OrderMapper.createEmailID();
        OrderMapper om = new OrderMapper();
        om.putOrderInDatabase(ListofItems);
    }

    // Side carport tegning
    public static String getSideCarportDrawing(double length, int height) {
        return SVGDrawingFromSide.BuildSideCarport(length, height);
    }
    // Top carport tegning
    public static String getTopCarportDrawing(double length, int width) {
        return SVGDrawingFromTop.BuildTopCarport(length, width);
    }

    public static ArrayList<Order> getOrderLines() {
        return OrderMapper.getOrderLines();
    }

    public static ArrayList<Product> getProductsFromOrders() {
        return MaterialMapper.getProductOrders();
    }

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

    public static void createUser(User user){
        UserMapper.registerUser(user);
    }
    
    public static User login(String email, String password) throws LoginException{
        return UserMapper.login(email, password);
    }
}
