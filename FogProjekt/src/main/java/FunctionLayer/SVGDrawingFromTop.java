/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Oliver
 */
public class SVGDrawingFromTop {
    
    public static String BuildTopCarport(double length, int width) {
        StringBuilder sb = new StringBuilder();
        sb.append(layer( length, width));
        return sb.toString();
    }

    private static String layer(double length, int yPos) {
        return putSpær(length, 0, yPos);
    }

    public static String putSpær(double length, int xPos, int yPos) {

        StringBuilder sb = new StringBuilder();
        double inBetweenSpær = SVGDrawingFromTop.calculateInBetweenTop(length);

        while (length >= inBetweenSpær) { // Place all the spær
            sb.append(Spær(inBetweenSpær, xPos, yPos));
            length = length - inBetweenSpær;
            xPos += inBetweenSpær;
        }
        return sb.toString();
    }

    public static double calculateInBetweenTop(double length) {

        double amountofStolperDouble = Math.ceil(length / 60);
        int amountofStolperInt = (int) amountofStolperDouble;
        int lengthInBetween = (int) length / amountofStolperInt;
        return lengthInBetween;

    }

    public static String Spær(double size, int xPos, int yPos) {
        String res = "<rect x='" + xPos + "' y='" + 1 + "' width='" + size + "' height='" + yPos + "'"
                + "style=\"stroke: #000000; fill: #ffffff\"/>";
        res += "<text x='" + (xPos + size / 2) + "' y='" + (yPos - 10) + "' "
                + "font-family=\"Verdana\" font-size=\"15px\""
                + "text-anchor=\"middle\" alignment-baseline=\"middle\">"
                + size / 100 + "m" + "</text>\n";
        return res;
    }
}
