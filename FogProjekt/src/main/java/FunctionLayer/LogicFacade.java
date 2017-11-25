/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DataLayer.MaterialMapper;
import DataLayer.OrderMapper;
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
        OrderMapper.createOrderNumber();
        OrderMapper om = new OrderMapper();
        om.putOrderInDatabase(ListofItems);
    }
    
    public static String getSideCarportDrawing(double length, int height){
        return SVGUtil.BuildSideCarport(length, height);
    }
    
    public static ArrayList<Order> getOrderLines() {
        return OrderMapper.getOrderLines();
    }
    
    public static ArrayList<Product> getProductsFromOrders(){
        return MaterialMapper.getProductOrders();
    }
    
    public static ArrayList<Product> getOrderProductsFromID(int number, ArrayList<Order> orderlines, ArrayList<Product> orderdetails){
            ArrayList<Product> ordersofid = new ArrayList<Product>();
            for (int i = 0; i < orderdetails.size(); i++) {
                if(number == orderdetails.get(i).getId()){
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
    
}
