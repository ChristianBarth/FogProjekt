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

//    public static void main(String[] args) {
//        MaterialMapper mm = new MaterialMapper();
//
//        mm.getProducts();
//        for (Product product : mm.getProducts()) {
//            System.out.println(product.getLength());
//        }
//        System.out.println("Element: " + mm.getProducts().get(0).getPrice());
//
//        SingleFlatRoofCal sfrc = new SingleFlatRoofCal();
//
//        double length = 780;
//        double width = 600;

//        System.out.println("Part0 - Amount: " + sfrc.getLengthPart0(width).getAmount() + " Product: " + mm.getProducts().get(0).getName());
//        System.out.println("Part1 - Amount: " + sfrc.getLengthPart1(length).getAmount() + " Product: " + mm.getProducts().get(1).getName());
//        System.out.println("Part2 - Amount: " + sfrc.getLengthPart2(width).getAmount() + " Product: " + mm.getProducts().get(2).getName());
//        System.out.println("Part3 - Amount: " + sfrc.getLengthPart3(length).getAmount() + " Product: " + mm.getProducts().get(3).getName());
//        
//        System.out.println("Part7 - Amount: " + sfrc.getLengthPart7(length).getAmount() + " Product: " + mm.getProducts().get(7).getName());
//        System.out.println("Part9 - Amount: " + sfrc.getLengthPart9(width).getAmount() + " Product: " + mm.getProducts().get(9).getName());
//
//        System.out.println("Part10 - Amount: " + sfrc.getLengthPart10(width).getAmount() + " Product: " + mm.getProducts().get(10).getName());
//
//        System.out.println("Part15 - Amount: " + sfrc.getLengthPart15(length, width).getAmount() + " Product: " + mm.getProducts().get(15).getName());
//        System.out.println("Part16 - Amount: " + sfrc.getAmountPart16(length, width).getAmount() + " Product: " + mm.getProducts().get(16).getName());
//    }
    private MaterialMapper mm = new MaterialMapper();

    // 25x200mm (360cm) trykimp. Brædt til længden, på forende og bagende
    public Product getLengthPart0(double length) {
        double lengthPart = (Math.ceil(length / mm.getProducts().get(0).getLength() * 2));
        int lengthPartInt = (int) lengthPart;
        int priceForParts = lengthPartInt * mm.getProducts().get(0).getPrice();
        Product product = new Product(mm.getProducts().get(0).getName(), mm.getProducts().get(0).getLength(), lengthPartInt, mm.getProducts().get(0).getUnit(), mm.getProducts().get(0).getDescription(), priceForParts);
        return product;
    }

    // 25x200 mm (540cm) trykimp. Brædt til længden af siderne
    public Product getLengthPart1(double length) {
        double lengthPart = (Math.ceil(length / mm.getProducts().get(1).getLength() * 2));
        int lengthPartInt = (int) lengthPart;
        int priceForParts = lengthPartInt * mm.getProducts().get(1).getPrice();
        Product product = new Product(mm.getProducts().get(1).getName(), mm.getProducts().get(1).getLength(), lengthPartInt, mm.getProducts().get(1).getUnit(), mm.getProducts().get(1).getDescription(), priceForParts);
        return product;
    }

    // 25x125mm (360cm) trykimp. Brædt til oversternsbrædder til forenden
    public Product getLengthPart2(double length) {
        double lengthPart = Math.ceil(length / mm.getProducts().get(2).getLength());
        int lengthPartInt = (int) lengthPart;
        int priceForParts = lengthPartInt * mm.getProducts().get(2).getPrice();
        Product product = new Product(mm.getProducts().get(2).getName(), mm.getProducts().get(2).getLength(), lengthPartInt, mm.getProducts().get(2).getUnit(), mm.getProducts().get(2).getDescription(), priceForParts);
        return product;
    }

    // 25x125mm (540cm) trykimp. Brædt til oversternsbrædder til siderne
    public Product getLengthPart3(double length) {
        double lengthPart = (Math.ceil(length / mm.getProducts().get(3).getLength() * 2));
        int lengthPartInt = (int) lengthPart;
        int priceForParts = lengthPartInt * mm.getProducts().get(3).getPrice();
        Product product = new Product(mm.getProducts().get(3).getName(), mm.getProducts().get(3).getLength(), lengthPartInt, mm.getProducts().get(3).getUnit(), mm.getProducts().get(3).getDescription(), priceForParts);
        return product;
    }

    // 45x195mm (600cm) spærtræ ubh. Remme i sider, sadles ned i stolper.
    public Product getLengthPart7(double length) {
        double lengthPart = Math.ceil(length / mm.getProducts().get(7).getLength());
        int lengthPartInt = (int) lengthPart;
        int priceForParts = lengthPartInt * mm.getProducts().get(7).getPrice();
        Product product = new Product(mm.getProducts().get(7).getName(), mm.getProducts().get(7).getLength(), lengthPartInt, mm.getProducts().get(7).getUnit(), mm.getProducts().get(7).getDescription(), priceForParts);
        return product;
    }

    // 45x195mm (600cm) spærtræ ubh. spær monteres på rem
    public Product getLengthPart9(double length) {
        double lengthPart = Math.ceil(length / 60);
        int lengthPartInt = (int) lengthPart;
        Product product = new Product(mm.getProducts().get(9).getName(), mm.getProducts().get(9).getLength(), lengthPartInt, mm.getProducts().get(9).getUnit(), mm.getProducts().get(9).getDescription(), mm.getProducts().get(9).getPrice());
        return product;
    }

    //97x97 mm. trykimp. Stolpe
    public Product getLengthPart10(double length) {
        double lengthPart = ((Math.ceil(length / 310)) + 1) * 2;
        int amountStolper = (int) lengthPart;
        int priceForParts = amountStolper * mm.getProducts().get(10).getPrice();
        Product product = new Product(mm.getProducts().get(10).getName(), mm.getProducts().get(10).getLength(), amountStolper, mm.getProducts().get(10).getUnit(), mm.getProducts().get(10).getDescription(), priceForParts);
        return product;
    }

    // Plastmo Ecolite blåtonet (600x109cm)
    public Product getLengthPart14(double length, double width) {
        double lengthPart = Math.ceil(length / mm.getProducts().get(14).getLength());
        double widthPart = Math.ceil(width / 109);
        int resultPart = (int) (lengthPart * widthPart);
        int priceForParts = resultPart * mm.getProducts().get(14).getPrice();
        Product product = new Product(mm.getProducts().get(14).getName(), mm.getProducts().get(14).getLength(), resultPart, mm.getProducts().get(14).getUnit(), mm.getProducts().get(14).getDescription(), priceForParts);
        return product;
    }

    // Plastmo Ecolite blåtonet (360x109cm)
    public Product getLengthPart15(double length, double width) {
        double lengthPart = Math.ceil(length / mm.getProducts().get(15).getLength());
        double widthPart = Math.ceil(width / 109);
        int resultPart = (int) (lengthPart * widthPart);
        int priceForParts = resultPart * mm.getProducts().get(15).getPrice();
        Product product = new Product(mm.getProducts().get(15).getName(), mm.getProducts().get(15).getLength(), resultPart, mm.getProducts().get(15).getUnit(), mm.getProducts().get(15).getDescription(), priceForParts);
        return product;
    }

    //plastmo bundskruer 200 stk.
    public Product getAmountPart16(double length, double width) {
        double lengthPart = Math.ceil(length / mm.getProducts().get(14).getLength());
        double widthPart = Math.ceil(width / 109);
        int resultPart = (int) (lengthPart * widthPart);
        int amountOfScrews = resultPart * 50;
        double amountOfPacks = Math.ceil(amountOfScrews / 200);
        
        int resultPart2 = (int) amountOfPacks;
        int priceForParts = resultPart2 * mm.getProducts().get(16).getPrice();
        Product product = new Product(mm.getProducts().get(16).getName(), mm.getProducts().get(16).getLength(), resultPart2, mm.getProducts().get(16).getUnit(), mm.getProducts().get(16).getDescription(), priceForParts);
        return product;

    }

    // hulbånd 1x20mm. 10 mtr
    public Product getAmountPart17(double length, double width) {
        double result = ((length * length) + (width * width));
        double partLength = Math.ceil(Math.sqrt(result));
        double resultPart = Math.ceil((partLength * 2) / mm.getProducts().get(17).getLength());
        int resultPartInt = (int) resultPart;
        int priceForParts = resultPartInt * mm.getProducts().get(17).getPrice();
        Product product = new Product(mm.getProducts().get(17).getName(), mm.getProducts().get(17).getLength(), resultPartInt, mm.getProducts().get(17).getUnit(), mm.getProducts().get(17).getDescription(), priceForParts);
        return product;
    }

    //universal 190mm. højre
    public Product getAmountPart18(double length, double width) {
        double lengthPart = Math.ceil(length / 60);
        int amountOfSpær = (int) lengthPart;
        int amountOfScrews = amountOfSpær * 1;
        int priceForParts = amountOfScrews * mm.getProducts().get(18).getPrice();

        int resultPart = (int) amountOfScrews;
        Product product = new Product(mm.getProducts().get(18).getName(), mm.getProducts().get(18).getLength(), resultPart, mm.getProducts().get(18).getUnit(), mm.getProducts().get(18).getDescription(), priceForParts);
        return product;
    }

    // universal 190mm. venstre
    public Product getAmountPart19(double length, double width) {
        double lengthPart = Math.ceil(length / 60);
        int amountOfSpær = (int) lengthPart;
        int amountOfScrews = amountOfSpær * 1;
        int priceForParts = amountOfScrews * mm.getProducts().get(19).getPrice();

        int resultPart = (int) amountOfScrews;
        Product product = new Product(mm.getProducts().get(19).getName(), mm.getProducts().get(19).getLength(), resultPart, mm.getProducts().get(19).getUnit(), mm.getProducts().get(19).getDescription(), priceForParts);
        return product;
    }

    // 4,5 x 60 mm. skruer 200 stk. (Formodet 6 skruer pr. meter i både længde og bredde)
    public Product getAmountPart20(double length, double width) {
        double lengthPart = (length / 100) * 6;
        double widthPart = (width / 100) * 6;
        double amountOfScrews = lengthPart + widthPart;
        double amountOfPacks = Math.ceil(amountOfScrews / 200);

        int resultPart = (int) amountOfPacks;
        int priceForParts = resultPart * mm.getProducts().get(20).getPrice();
        Product product = new Product(mm.getProducts().get(20).getName(), mm.getProducts().get(20).getLength(), resultPart, mm.getProducts().get(20).getUnit(), mm.getProducts().get(20).getDescription(), priceForParts);
        return product;
    }

    //4,0 x 50 mm. beslagskruer 250stk.
    public Product getAmountPart21(double length, double width) {
        double lengthPart = Math.ceil(length / 60);
        double amountOfSpær = lengthPart;
        double amountOfBeslag = amountOfSpær * 2;
        double amountOfScrews = amountOfBeslag * 6;
        double amountOfScrewsOnBand = (amountOfSpær * 2) * 2;
        double amountOfPacks = Math.ceil((amountOfScrews + amountOfScrewsOnBand) / 250);
     
        int resultPart = (int) amountOfPacks;
        int priceForParts = resultPart * mm.getProducts().get(21).getPrice();

        
        Product product = new Product(mm.getProducts().get(21).getName(), mm.getProducts().get(21).getLength(), resultPart, mm.getProducts().get(21).getUnit(), mm.getProducts().get(21).getDescription(), priceForParts);
        return product;
    }

//bræddebolt 10	x 120 mm.	    
    public Product getAmountPart22(double length, double width) {

        double lengthPart = ((Math.ceil(length / 310)) + 1) * 2;
        int amountStolper = (int) lengthPart;

        double amountOfBolts = Math.ceil(amountStolper * 2);

        int priceForParts = amountStolper * mm.getProducts().get(22).getPrice();
        int resultPart = (int) amountOfBolts;

        Product product = new Product(mm.getProducts().get(22).getName(), mm.getProducts().get(22).getLength(), resultPart, mm.getProducts().get(22).getUnit(), mm.getProducts().get(22).getDescription(), priceForParts);
        return product;
    }

//firkantskiver	40x40x11mm
    public Product getAmountPart23(double length, double width) {
        double lengthPart = ((Math.ceil(length / 310)) + 1) * 2;
        int amountStolper = (int) lengthPart;

        double amountOfSkiver = Math.ceil(amountStolper * 2);

        int priceForParts = amountStolper * mm.getProducts().get(23).getPrice();
        int resultPart = (int) amountOfSkiver;

        Product product = new Product(mm.getProducts().get(23).getName(), mm.getProducts().get(23).getLength(), resultPart, mm.getProducts().get(23).getUnit(), mm.getProducts().get(23).getDescription(), priceForParts);
        return product;
    }

    public static ArrayList<Product> getProductList(double length, double width) {

        ArrayList<Product> MaterialList = new ArrayList<Product>();
        SingleFlatRoofCal sfrc = new SingleFlatRoofCal();

        MaterialList.add(sfrc.getLengthPart0(length));
        MaterialList.add(sfrc.getLengthPart1(length));
        MaterialList.add(sfrc.getLengthPart2(length));
        MaterialList.add(sfrc.getLengthPart3(length));
        MaterialList.add(sfrc.getLengthPart7(length));
        MaterialList.add(sfrc.getLengthPart9(length));
        MaterialList.add(sfrc.getLengthPart10(length));
        MaterialList.add(sfrc.getLengthPart14(length, width));
        MaterialList.add(sfrc.getLengthPart15(length, width));
        MaterialList.add(sfrc.getAmountPart16(length, width));
        MaterialList.add(sfrc.getAmountPart17(length, width));
        MaterialList.add(sfrc.getAmountPart18(length, width));
        MaterialList.add(sfrc.getAmountPart19(length, width));
        MaterialList.add(sfrc.getAmountPart20(length, width));
        MaterialList.add(sfrc.getAmountPart21(length, width));
        MaterialList.add(sfrc.getAmountPart22(length, width));
        MaterialList.add(sfrc.getAmountPart23(length, width));

        return MaterialList;
    }
}
