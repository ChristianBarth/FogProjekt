/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import FunctionLayer.Product;
import DataLayer.MaterialMapper;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author PC
 */
public class SingleFlatRoofCal {

    public static void main(String[] args) {
        MaterialMapper mm = new MaterialMapper();

//        mm.getProducts();
//        for (Product product : mm.getProducts()) {
//            System.out.println(product.getLength());
//        }
//       System.out.println("Element: " + mm.getProducts().get(0).getPrice());
        SingleFlatRoofCal sfrc = new SingleFlatRoofCal();

        double length = 780;
        double width = 600;

        System.out.println("Part0 - Amount: " + sfrc.getLengthPart0(width).getAmount() + " Product: " + mm.getProducts().get(0).getName());
        System.out.println("Part1 - Amount: " + sfrc.getLengthPart1(length).getAmount() + " Product: " + mm.getProducts().get(1).getName());
        System.out.println("Part2 - Amount: " + sfrc.getLengthPart2(width).getAmount() + " Product: " + mm.getProducts().get(2).getName());
        System.out.println("Part3 - Amount: " + sfrc.getLengthPart3(length).getAmount() + " Product: " + mm.getProducts().get(3).getName());

        System.out.println("Part7 - Amount: " + sfrc.getLengthPart7(length).getAmount() + " Product: " + mm.getProducts().get(7).getName());
        System.out.println("Part9 - Amount: " + sfrc.getLengthPart9(width).getAmount() + " Product: " + mm.getProducts().get(9).getName());

        System.out.println("Part10 - Amount: " + sfrc.getLengthPart9(length).getAmount() + " Product: " + mm.getProducts().get(10).getName());

        System.out.println("Part14 - Amount: " + sfrc.getLengthPart14(length).getAmount() + " Product: " + mm.getProducts().get(14).getName());
        System.out.println("Part15 - Amount: " + sfrc.getLengthPart15(width).getAmount() + " Product: " + mm.getProducts().get(15).getName());
    }

    private MaterialMapper mm = new MaterialMapper();

    // 25x200mm (360cm) trykimp. Brædt til længden, på forende og bagende
    public Product getLengthPart0(double length) {
        double lengthPart = (Math.ceil(length / mm.getProducts().get(0).getLength() * 2));
        Product product = new Product(mm.getProducts().get(0).getName(), mm.getProducts().get(0).getLength(), lengthPart, mm.getProducts().get(0).getUnit(), mm.getProducts().get(0).getDescription(), mm.getProducts().get(0).getPrice());
        return product;
    }

    // 25x200 mm (540cm) trykimp. Brædt til længden af siderne
    public Product getLengthPart1(double length) {
        double lengthPart = (Math.ceil(length / mm.getProducts().get(1).getLength() * 2));
        Product product = new Product(mm.getProducts().get(1).getName(), mm.getProducts().get(1).getLength(), lengthPart, mm.getProducts().get(1).getUnit(), mm.getProducts().get(1).getDescription(), mm.getProducts().get(1).getPrice());
        return product;
    }

    // 25x125mm (360cm) trykimp. Brædt til oversternsbrædder til forenden
    public Product getLengthPart2(double length) {
        double lengthPart = Math.ceil(length / mm.getProducts().get(2).getLength());
        Product product = new Product(mm.getProducts().get(2).getName(), mm.getProducts().get(2).getLength(), lengthPart, mm.getProducts().get(2).getUnit(), mm.getProducts().get(2).getDescription(), mm.getProducts().get(2).getPrice());
        return product;
    }

    // 25x125mm (540cm) trykimp. Brædt til oversternsbrædder til siderne
    public Product getLengthPart3(double length) {
        double lengthPart = (Math.ceil(length / mm.getProducts().get(3).getLength() * 2));
        Product product = new Product(mm.getProducts().get(3).getName(), mm.getProducts().get(3).getLength(), lengthPart, mm.getProducts().get(3).getUnit(), mm.getProducts().get(3).getDescription(), mm.getProducts().get(3).getPrice());
        return product;
    }

    // 45x195mm (600cm) spærtræ ubh. Remme i sider, sadles ned i stolper.
    public Product getLengthPart7(double length) {
        double lengthPart = Math.ceil(length / mm.getProducts().get(7).getLength());
        Product product = new Product(mm.getProducts().get(7).getName(), mm.getProducts().get(7).getLength(), lengthPart, mm.getProducts().get(7).getUnit(), mm.getProducts().get(7).getDescription(), mm.getProducts().get(7).getPrice());
        return product;
    }

    // 45x195mm (480cm) spærtræ ubh. (Skur del skal måske ikke bruge lige nu)
    public Product getLengthPart9(double length) {
        double lengthPart = Math.ceil(length / 60);
        Product product = new Product(mm.getProducts().get(9).getName(), mm.getProducts().get(9).getLength(), lengthPart, mm.getProducts().get(9).getUnit(), mm.getProducts().get(9).getDescription(), mm.getProducts().get(9).getPrice());
        return product;
    }

    // 45x195mm (600cm) spærtræ ubh. Monteres på rem.
    public Product getLengthPart10(double length) {
        double lengthPart = Math.ceil(length);
        Product product = new Product(mm.getProducts().get(10).getName(), mm.getProducts().get(10).getLength(), lengthPart, mm.getProducts().get(10).getUnit(), mm.getProducts().get(10).getDescription(), mm.getProducts().get(10).getPrice());
        return product;
    }

    // Plastmo Ecolite blåtonet (600x109cm)
    public Product getLengthPart14(double length) {
        double lengthPart = Math.ceil(length);
        Product product = new Product(mm.getProducts().get(14).getName(), mm.getProducts().get(14).getLength(), lengthPart, mm.getProducts().get(14).getUnit(), mm.getProducts().get(14).getDescription(), mm.getProducts().get(14).getPrice());
        return product;
    }

    // Plastmo Ecolite blåtonet (360x109cm)
    public Product getLengthPart15(double length) {
        double lengthPart = Math.ceil(length);
        Product product = new Product(mm.getProducts().get(15).getName(), mm.getProducts().get(15).getLength(), lengthPart, mm.getProducts().get(15).getUnit(), mm.getProducts().get(15).getDescription(), mm.getProducts().get(15).getPrice());
        return product;
    }

    public ArrayList<Product> getProducts() {
        ArrayList<Product> MaterialList = new ArrayList<Product>();

        return MaterialList;
    }

}
