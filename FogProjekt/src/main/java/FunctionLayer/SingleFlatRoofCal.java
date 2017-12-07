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
    public Product getAmountPart0(double length) {
        double lengthPart = (Math.ceil(length / mm.getProducts().get(0).getLength() * 2));
        int lengthPartInt = (int) lengthPart;
        int priceForParts = lengthPartInt * mm.getProducts().get(0).getPrice();
        Product product = new Product(mm.getProducts().get(0).getName(), mm.getProducts().get(0).getLength(), lengthPartInt, mm.getProducts().get(0).getUnit(), mm.getProducts().get(0).getDescription(), priceForParts);
        return product;
    }

    // 25x200 mm (540cm) trykimp. Brædt til længden af siderne
    public Product getAmountPart1(double length) {
        double lengthPart = (Math.ceil(length / mm.getProducts().get(1).getLength() * 2));
        int lengthPartInt = (int) lengthPart;
        int priceForParts = lengthPartInt * mm.getProducts().get(1).getPrice();
        Product product = new Product(mm.getProducts().get(1).getName(), mm.getProducts().get(1).getLength(), lengthPartInt, mm.getProducts().get(1).getUnit(), mm.getProducts().get(1).getDescription(), priceForParts);
        return product;
    }

    // 25x125mm (360cm) trykimp. Brædt til oversternsbrædder til forenden
    public Product getAmountPart2(double length) {
        double lengthPart = Math.ceil(length / mm.getProducts().get(2).getLength());
        int lengthPartInt = (int) lengthPart;
        int priceForParts = lengthPartInt * mm.getProducts().get(2).getPrice();
        Product product = new Product(mm.getProducts().get(2).getName(), mm.getProducts().get(2).getLength(), lengthPartInt, mm.getProducts().get(2).getUnit(), mm.getProducts().get(2).getDescription(), priceForParts);
        return product;
    }

    // 25x125mm (540cm) trykimp. Brædt til oversternsbrædder til siderne
    public Product getAmountPart3(double length) {
        double lengthPart = (Math.ceil(length / mm.getProducts().get(3).getLength() * 2));
        int lengthPartInt = (int) lengthPart;
        int priceForParts = lengthPartInt * mm.getProducts().get(3).getPrice();
        Product product = new Product(mm.getProducts().get(3).getName(), mm.getProducts().get(3).getLength(), lengthPartInt, mm.getProducts().get(3).getUnit(), mm.getProducts().get(3).getDescription(), priceForParts);
        return product;
    }

    // til z på bagside af dør	
    public Product getAmountPart4(double length, double width) {
        double lengthPart = length / mm.getProducts().get(4).getLength();
        int amountOfLægte = (int)lengthPart;
        int resultPart = amountOfLægte;

        int priceForParts = resultPart * mm.getProducts().get(4).getPrice();

        Product product = new Product(mm.getProducts().get(4).getName(), mm.getProducts().get(4).getLength(), resultPart, mm.getProducts().get(4).getUnit(), mm.getProducts().get(4).getDescription(), priceForParts);
        return product;
    }

    // løsholter til skur gavle	
    public Product getAmountPart5(double length, double width) {
        double lengthPart = Math.ceil(width / mm.getProducts().get(5).getLength()) * 4;
        int amountOfLøsholter = (int) lengthPart;
        int resultPart = amountOfLøsholter;

        int priceForParts = resultPart * mm.getProducts().get(5).getPrice();

        Product product = new Product(mm.getProducts().get(5).getName(), mm.getProducts().get(5).getLength(), resultPart, mm.getProducts().get(5).getUnit(), mm.getProducts().get(5).getDescription(), priceForParts);
        return product;
    }

    // løsholter til skur sider
    public Product getAmountPart6(double length, double width) {
        int amountOfSkurSider = 4;
        int amountOfLøsholter = amountOfSkurSider;
        int resultPart = amountOfLøsholter;

        int priceForParts = resultPart * mm.getProducts().get(6).getPrice();

        Product product = new Product(mm.getProducts().get(6).getName(), mm.getProducts().get(6).getLength(), resultPart, mm.getProducts().get(6).getUnit(), mm.getProducts().get(6).getDescription(), priceForParts);
        return product;
        
    }

    // 45x195mm (600cm) spærtræ ubh. Remme i sider, sadles ned i stolper.

    public Product getAmountPart7(double length) {
        double lengthPart = Math.ceil(length / mm.getProducts().get(7).getLength()) * 2;

        int lengthPartInt = (int) lengthPart;
        int priceForParts = lengthPartInt * mm.getProducts().get(7).getPrice();
        Product product = new Product(mm.getProducts().get(7).getName(), mm.getProducts().get(7).getLength(), lengthPartInt, mm.getProducts().get(7).getUnit(), mm.getProducts().get(7).getDescription(), priceForParts);
        return product;
    }

    // Remme i sider, sadles ned i stolper (skur del, deles)	
    public Product getAmountPart8(double length, double width) {
        int amountOfRemme = 1;
        int resultPart = amountOfRemme;

        int priceForParts = resultPart * mm.getProducts().get(8).getPrice();

        Product product = new Product(mm.getProducts().get(8).getName(), mm.getProducts().get(8).getLength(), resultPart, mm.getProducts().get(8).getUnit(), mm.getProducts().get(8).getDescription(), priceForParts);
        return product;
    }

    // 45x195mm (600cm) spærtræ ubh. spær monteres på rem
    public Product getAmountPart9(double length) {
        double lengthPart = Math.ceil(length / 60);
        int lengthPartInt = (int) lengthPart;
        Product product = new Product(mm.getProducts().get(9).getName(), mm.getProducts().get(9).getLength(), lengthPartInt, mm.getProducts().get(9).getUnit(), mm.getProducts().get(9).getDescription(), mm.getProducts().get(9).getPrice());
        return product;
    }

    //97x97 mm. trykimp. Stolpe
    public Product getAmountPart10(double length) {
        double lengthPart = ((Math.ceil(length / 310)) + 1) * 2;
        int amountStolper = (int) lengthPart;
        int priceForParts = amountStolper * mm.getProducts().get(10).getPrice();
        Product product = new Product(mm.getProducts().get(10).getName(), mm.getProducts().get(10).getLength(), amountStolper, mm.getProducts().get(10).getUnit(), mm.getProducts().get(10).getDescription(), priceForParts);
        return product;
    }

    // til beklædning af skur 1 på 2 (sider?)
    public Product getAmountPart11(double length, double width) {
        double SkurWidth = width - 70;
        double langside = Math.ceil(SkurWidth / 10) * 2;
        double breddeside = Math.ceil(110 / 10) * 2;
        double amountOfBrædder = langside + breddeside;

        int resultPart = (int) amountOfBrædder;

        int priceForParts = resultPart * mm.getProducts().get(11).getPrice();

        Product product = new Product(mm.getProducts().get(11).getName(), mm.getProducts().get(11).getLength(), resultPart, mm.getProducts().get(11).getUnit(), mm.getProducts().get(11).getDescription(), priceForParts);
        return product;
    }

    // vandbrædt på stern i sider
    public Product getAmountPart12(double length, double width) {
        double lengthPart = Math.ceil(length / mm.getProducts().get(12).getLength());
        int amountOfSkurSider = 2;
        int amountOfVandbrædt = amountOfSkurSider + (int) lengthPart;
        int resultPart = amountOfVandbrædt;

        int priceForParts = resultPart * mm.getProducts().get(12).getPrice();

        Product product = new Product(mm.getProducts().get(12).getName(), mm.getProducts().get(12).getLength(), resultPart, mm.getProducts().get(12).getUnit(), mm.getProducts().get(12).getDescription(), priceForParts);
        return product;
    }

    // vandbrædt på stern i forende
    public Product getAmountPart13(double length, double width) {
        double lengthPart = Math.ceil(width / mm.getProducts().get(13).getLength());
        int amountOfSkurSider = 1;
        int amountOfVandbrædt = amountOfSkurSider + (int) lengthPart;
        int resultPart = amountOfVandbrædt;

        int priceForParts = resultPart * mm.getProducts().get(13).getPrice();

        Product product = new Product(mm.getProducts().get(13).getName(), mm.getProducts().get(13).getLength(), resultPart, mm.getProducts().get(13).getUnit(), mm.getProducts().get(13).getDescription(), priceForParts);
        return product;
    }

    // Plastmo Ecolite blåtonet (600x109cm)
    public Product getAmountPart14(double length, double width) {
        double lengthPart = Math.ceil(length / mm.getProducts().get(14).getLength());
        double widthPart = Math.ceil(width / 109);
        int resultPart = (int) (lengthPart * widthPart);
        int priceForParts = resultPart * mm.getProducts().get(14).getPrice();
        Product product = new Product(mm.getProducts().get(14).getName(), mm.getProducts().get(14).getLength(), resultPart, mm.getProducts().get(14).getUnit(), mm.getProducts().get(14).getDescription(), priceForParts);
        return product;
    }

    // Plastmo Ecolite blåtonet (360x109cm)
    public Product getAmountPart15(double length, double width) {
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

    //4,0 x 50 mm. beslagskruer 250stk. (60 cm max afstand mellem spær)
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

    // til montering af yderste beklædning (400 per pakke)
    public Product getAmountPart24(double length, double width) {
        double lengthPart = Math.ceil(width * 0.19);
        double amountOfBrædt = lengthPart;
        double amountOfScrews = amountOfBrædt * 4;
        double amountOfPacks = Math.ceil(amountOfScrews / 400);
        int resultPart = (int) amountOfPacks;

        int priceForParts = resultPart * mm.getProducts().get(24).getPrice();

        Product product = new Product(mm.getProducts().get(24).getName(), mm.getProducts().get(24).getLength(), resultPart, mm.getProducts().get(24).getUnit(), mm.getProducts().get(24).getDescription(), priceForParts);
        return product;
    }

    // til montering af inderste beklædning (300 per pakke)
    public Product getAmountPart25(double length, double width) {
        double lengthPart = Math.ceil(width * 0.19);
        double amountOfBrædt = lengthPart;
        double amountOfScrews = amountOfBrædt * 4;
        double amountOfPacks = Math.ceil(amountOfScrews / 300);
        int resultPart = (int) amountOfPacks;

        int priceForParts = resultPart * mm.getProducts().get(25).getPrice();

        Product product = new Product(mm.getProducts().get(25).getName(), mm.getProducts().get(25).getLength(), resultPart, mm.getProducts().get(25).getUnit(), mm.getProducts().get(25).getDescription(), priceForParts);
        return product;
    }
    
    // til lås på dør i skur
    public Product getAmountPart26(double length, double width) {
        int amountOfDør = 1;
        int resultPart = amountOfDør;

        int priceForParts = resultPart * mm.getProducts().get(26).getPrice();

        Product product = new Product(mm.getProducts().get(26).getName(), mm.getProducts().get(26).getLength(), resultPart, mm.getProducts().get(26).getUnit(), mm.getProducts().get(26).getDescription(), priceForParts);
        return product;
    }
    
    // Til skurdør (Hængsel) 2x pr. dør
    public Product getAmountPart27(double length, double width) {
        int amountOfDør = 1;
        int amountOfHængsel = amountOfDør * 2;
        int resultPart = amountOfHængsel;

        int priceForParts = resultPart * mm.getProducts().get(27).getPrice();

        Product product = new Product(mm.getProducts().get(27).getName(), mm.getProducts().get(27).getLength(), resultPart, mm.getProducts().get(27).getUnit(), mm.getProducts().get(27).getDescription(), priceForParts);
        return product;
    }
    
    // Til montering af løsholter i skur (2x pr. løsholt)
    public Product getAmountPart28(double length, double width) {
        double amountTilGavle = Math.ceil(width / mm.getProducts().get(5).getLength()) * 4;
        int amountTilSider = 4;
        int amountOfVinkelBeslag = ((int)amountTilGavle + amountTilSider) * 2; 
   
        int resultPart = amountOfVinkelBeslag;

        int priceForParts = resultPart * mm.getProducts().get(28).getPrice();

        Product product = new Product(mm.getProducts().get(28).getName(), mm.getProducts().get(28).getLength(), resultPart, mm.getProducts().get(28).getUnit(), mm.getProducts().get(28).getDescription(), priceForParts);
        return product;
       
    }

    public static ArrayList<Product> getProductsNoSkur(double length, double width) {

        ArrayList<Product> MaterialList = new ArrayList<Product>();
        SingleFlatRoofCal sfrc = new SingleFlatRoofCal();

        MaterialList.add(sfrc.getAmountPart0(length));
        MaterialList.add(sfrc.getAmountPart1(length));
        MaterialList.add(sfrc.getAmountPart2(length));
        MaterialList.add(sfrc.getAmountPart3(length));
        MaterialList.add(sfrc.getAmountPart7(length));
        MaterialList.add(sfrc.getAmountPart9(length));
        MaterialList.add(sfrc.getAmountPart10(length));
        MaterialList.add(sfrc.getAmountPart14(length, width));
        MaterialList.add(sfrc.getAmountPart15(length, width));
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
    public static ArrayList<Product> getProductsWithSkur(double length, double width) {

        ArrayList<Product> MaterialList = new ArrayList<Product>();
        SingleFlatRoofCal sfrc = new SingleFlatRoofCal();

        MaterialList.add(sfrc.getAmountPart0(length));
        MaterialList.add(sfrc.getAmountPart1(length));
        MaterialList.add(sfrc.getAmountPart2(length));
        MaterialList.add(sfrc.getAmountPart3(length));
        MaterialList.add(sfrc.getAmountPart4(length, width));
        MaterialList.add(sfrc.getAmountPart5(length, width));
        MaterialList.add(sfrc.getAmountPart6(length, width));
        MaterialList.add(sfrc.getAmountPart7(length));
        MaterialList.add(sfrc.getAmountPart8(length, width));
        MaterialList.add(sfrc.getAmountPart9(length));
        MaterialList.add(sfrc.getAmountPart10(length));
        MaterialList.add(sfrc.getAmountPart11(length, width));
        MaterialList.add(sfrc.getAmountPart12(length, width));
        MaterialList.add(sfrc.getAmountPart13(length, width));
        MaterialList.add(sfrc.getAmountPart14(length, width));
        MaterialList.add(sfrc.getAmountPart15(length, width));
        MaterialList.add(sfrc.getAmountPart16(length, width));
        MaterialList.add(sfrc.getAmountPart17(length, width));
        MaterialList.add(sfrc.getAmountPart18(length, width));
        MaterialList.add(sfrc.getAmountPart19(length, width));
        MaterialList.add(sfrc.getAmountPart20(length, width));
        MaterialList.add(sfrc.getAmountPart21(length, width));
        MaterialList.add(sfrc.getAmountPart22(length, width));
        MaterialList.add(sfrc.getAmountPart23(length, width));
        MaterialList.add(sfrc.getAmountPart24(length, width));
        MaterialList.add(sfrc.getAmountPart25(length, width));
        MaterialList.add(sfrc.getAmountPart26(length, width));
        MaterialList.add(sfrc.getAmountPart27(length, width));
        MaterialList.add(sfrc.getAmountPart28(length, width));

        return MaterialList;
    }
    
}

