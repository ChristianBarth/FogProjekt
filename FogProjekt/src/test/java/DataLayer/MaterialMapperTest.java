package DataLayer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import FunctionLayer.WoodAndRoof;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PC
 */
public class MaterialMapperTest {
    
    private MaterialMapper mm;
    
    public MaterialMapperTest() {
        this.mm = new MaterialMapper();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
     @Test
    public void getMaterialFromDatabase(){
        ArrayList<WoodAndRoof> WoodandRoofs = new ArrayList<WoodAndRoof>();
        try {
            WoodandRoofs.addAll(mm.getWoodAndRoof());
        } catch (SQLException ex) {
            Logger.getLogger(MaterialMapperTest.class.getName()).log(Level.SEVERE, null, ex);
        }
            assertEquals(WoodandRoofs.size(), 16);
            System.out.println("Size of array: " + WoodandRoofs.size());
    }
    
    @Test
    public void getMaterialValues(){
        ArrayList<WoodAndRoof> WoodandRoofs = new ArrayList<WoodAndRoof>();
        try {
            WoodandRoofs.addAll(mm.getWoodAndRoof());
        } catch (SQLException ex) {
            Logger.getLogger(MaterialMapperTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (WoodAndRoof WoodandRoof : WoodandRoofs){
            System.out.println("name: " + WoodandRoof.getName());
            System.out.println("length: " + WoodandRoof.getLength());
            System.out.println("amount: " + WoodandRoof.getAmount());
            System.out.println("unit: " + WoodandRoof.getUnit());
            System.out.println("description: " + WoodandRoof.getDescription());
        }
    }
}
