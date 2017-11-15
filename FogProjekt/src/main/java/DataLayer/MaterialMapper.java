package DataLayer;

import FunctionLayer.FittingAndScrews;
import FunctionLayer.WoodAndRoof;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author PC
 */
public class MaterialMapper {
    public ArrayList<WoodAndRoof> getWoodAndRoof() throws SQLException {
        
        ArrayList<WoodAndRoof> WoodandRoof = new ArrayList<WoodAndRoof>();
        WoodAndRoof WoodsAndRoofs;
        
        try {
            
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM woodandroof";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                WoodsAndRoofs = new WoodAndRoof(
                rs.getString("name"),
                rs.getInt("length"),
                rs.getInt("amount"),
                rs.getString("unit"),
                rs.getString("description")
                );
                WoodandRoof.add(WoodsAndRoofs);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MaterialMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return WoodandRoof;
    }
    
    public ArrayList<FittingAndScrews> getFittingAndScrews() throws SQLException {
        
        ArrayList<FittingAndScrews> FittingandScrews = new ArrayList<FittingAndScrews>();
        FittingAndScrews fittingandscrews;
        
        try {
            
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM fittingandscrews";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                fittingandscrews = new FittingAndScrews(
                rs.getString("name"),
                rs.getInt("amount"),
                rs.getString("unit"),
                rs.getString("description")
                );
                FittingandScrews.add(fittingandscrews);
                
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MaterialMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return FittingandScrews;
        
    }
}
