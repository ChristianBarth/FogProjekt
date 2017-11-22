/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class LogicFacade {
    
        public ArrayList<Product> getListOfItems(double length, double width) {
        SingleFlatRoofCal calculate = new SingleFlatRoofCal();
        ArrayList<Product> orders = calculate.getProductList(length, width);
        return orders;
    }
}
