/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DataLayer.MaterialMapper;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author PC
 */
public class SingleFlatRoofCal {

    public static void main(String[] args) {
        MaterialMapper mm = new MaterialMapper();
        mm.getProducts();
        for (Product product : mm.getProducts()) {
            System.out.println(product.getLength());
        }
                System.out.println("Element: " + mm.getProducts().get(0).getPrice());
    }

    private MaterialMapper mm = new MaterialMapper();

    public Product Part1(int length, int height, int width) {
        // mm.getProducts().equals("25x200 mm. trykimp. Brædt");
        int l;
        l = mm.getProducts().get(0).getLength();
        
        

        return null;
    }

    public ArrayList<Product> getProducts() {
        ArrayList<Product> MaterialList = new ArrayList<Product>();

        return MaterialList;
    }

}
