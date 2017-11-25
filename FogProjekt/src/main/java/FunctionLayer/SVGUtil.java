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
        return putStolper(length + 200, 200, yPos);
    }

    public static String putStolper(int length, int xPos, int yPos) {

        StringBuilder sb = new StringBuilder();
        int inBetweenStolper = SVGUtil.calculateInBetween(length);

        while (length >= inBetweenStolper) { // Place all the stolper
            sb.append(Stolpe(inBetweenStolper, xPos, yPos));
            length = length - inBetweenStolper;
            xPos += inBetweenStolper;
        }
        return sb.toString();
    }

    public static int calculateInBetween(double length) {

        double amountofStolperDouble = Math.ceil(length / 310);
        int amountofStolperInt = (int) amountofStolperDouble + 1;
        int lengthInBetween = (int) length / amountofStolperInt;
        return lengthInBetween;

    }

    public static String Stolpe(int size, int xPos, int yPos) {
        String res = "<rect x='" + xPos + "' y='" + 50 + "' width='" + size + "' height='" + yPos * 2 + "'"
                + "style=\"stroke: #000000; fill: #ffffff\"/>";
        res += "<text x='" + (xPos + (size) / 2) + "' y='" + (yPos + 280) + "' "
                + "font-family=\"Verdana\" font-size=\"20px\""
                + "text-anchor=\"middle\" alignment-baseline=\"middle\">"
                + size + "</text>\n";
        return res;
    }
}
