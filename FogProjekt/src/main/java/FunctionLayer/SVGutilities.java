/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author asger
 */
public class SVGutilities {

    public static String carport(int length, int width, int height) {
        StringBuilder sb = new StringBuilder();
        for (int layer = 0; layer <= length; layer++) {
            sb.append(Stolper(length, layer));
        }

        return sb.toString();
    }

    private static String Stolper(int length, int height) {
        StringBuilder sb = new StringBuilder();

        String rightStolper = SVGutilities.rightStolper(length / 2, height);
        
        String leftStolper = SVGutilities.leftStolper(length / 2, height);
        
        sb.append(rightStolper + leftStolper);
        return sb.toString();
    }

    private static String leftStolper(int length, int height) {
     StringBuilder sb = new StringBuilder();
        
     
     
            return sb.toString();
    }

    private static String rightStolper(int length, int height) {
     StringBuilder sb = new StringBuilder();
     
     
     
            return sb.toString();
        
    }
}
