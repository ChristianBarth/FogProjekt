package FunctionLayer;

/**
 * @author Oliver
 */
public class SVGUtil {

    public static String BuildSideCarport(double length, int height) {
        StringBuilder sb = new StringBuilder();
        sb.append(layer( length, height));
        return sb.toString();
    }

    private static String layer(double length, int yPos) {
        return putStolper(length, 0, yPos);
    }

    public static String putStolper(double length, int xPos, int yPos) {

        StringBuilder sb = new StringBuilder();
        double inBetweenStolper = SVGUtil.calculateInBetween(length);

        while (length >= inBetweenStolper) { // Place all the stolper
            // for (int i = 0; i <= 3; i++) {
            sb.append(Stolpe(inBetweenStolper, xPos, yPos));
            length = length - inBetweenStolper;
            xPos += inBetweenStolper;
            // }
        }
        return sb.toString();
    }

    public static double calculateInBetween(double length) {

        double amountofStolperDouble = Math.ceil(length / 310);
        int amountofStolperInt = (int) amountofStolperDouble;
        int lengthInBetween = (int) length / amountofStolperInt;
        return lengthInBetween;

    }

    public static String Stolpe(double size, int xPos, int yPos) {
        String res = "<rect x='" + xPos + "' y='" + 1 + "' width='" + size + "' height='" + yPos + "'"
                + "style=\"stroke: #000000; fill: #ffffff\"/>";
        res += "<text x='" + (xPos + size / 2) + "' y='" + (yPos - 10) + "' "
                + "font-family=\"Verdana\" font-size=\"30px\""
                + "text-anchor=\"middle\" alignment-baseline=\"middle\">"
                + Math.floor(size) / 100 + "m" + "</text>\n";
        return res;
    }
}
