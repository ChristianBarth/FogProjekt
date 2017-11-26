package FunctionLayer;

/**
 * @author Oliver
 */
public class SVGUtil {

    public static String BuildSideCarport(double length, int height) {
        StringBuilder sb = new StringBuilder();
        sb.append(layer((int) length, height));
        return sb.toString();
    }

    private static String layer(int length, int yPos) {
        return putStolper(length / 10, 0, yPos / 10);
    }

    public static String putStolper(int length, int xPos, int yPos) {

        StringBuilder sb = new StringBuilder();
        int inBetweenStolper = SVGUtil.calculateInBetween(length);
        
        //sb.append(Stolpe(inBetweenStolper, xPos, yPos));

        while (length >= inBetweenStolper) { // Place all the stolper
            // for (int i = 0; i <= 3; i++) {
            sb.append(Stolpe(inBetweenStolper, xPos, yPos));
            length = length - inBetweenStolper;
            xPos += inBetweenStolper;
            // }
        }
        return sb.toString();
    }

    public static int calculateInBetween(double length) {

        double amountofStolperDouble = Math.ceil(length / 31);
        int amountofStolperInt = (int) amountofStolperDouble + 1;
        int lengthInBetween = (int) length / amountofStolperInt;
        return lengthInBetween;

    }

    public static String Stolpe(int size, int xPos, int yPos) {
        String res = "<rect x='" + xPos + "' y='" + 1 + "' width='" + size + "' height='" + yPos + "'"
                + "style=\"stroke: #000000; fill: #ffffff\"/>";
        res += "<text x='" + (xPos + (size) / 2) + "' y='" + (yPos - 3) + "' "
                + "font-family=\"Verdana\" font-size=\"5px\""
                + "text-anchor=\"middle\" alignment-baseline=\"middle\">"
                + (double) size / 100 + "m" + "</text>\n";
        return res;
    }
}
