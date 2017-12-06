package FunctionLayer;

/**
 * @author Oliver
 */
public class SVGDrawingFromSide {

    public static String BuildSideCarport(double length, int height) {
        StringBuilder sb = new StringBuilder();
        sb.append(StolpeLayer(length, height));
        sb.append(BrætLayer(length, height));
        return sb.toString();
    }

    private static String StolpeLayer(double length, int yPos) {
        return putStolper(length, 0, yPos);
    }

    private static String BrætLayer(double length, int yPos) {
        return putBræt(length, 0, yPos);
    }

    public static String putStolper(double length, int xPos, int yPos) {

        StringBuilder sb = new StringBuilder();
        double inBetweenStolper = SVGDrawingFromSide.calculateInBetweenSide(length);

        while (length >= inBetweenStolper) { // Place all the stolper
            sb.append(Stolpe(inBetweenStolper, xPos, yPos));
            length = length - inBetweenStolper;
            xPos += inBetweenStolper;
        }
        return sb.toString();
    }

    public static double calculateInBetweenSide(double length) {

        double amountofStolperDouble = Math.ceil(length / 310);
        int amountofStolperInt = (int) amountofStolperDouble;
        int lengthInBetween = (int) length / amountofStolperInt;
        return lengthInBetween;

    }

    public static String putBræt(double length, int xPos, int yPos) {

        StringBuilder sb = new StringBuilder();
        
        // - 2 for den præcise længde på x - aksen
        sb.append(Bræt1(length - 2, 0 + 20));
        sb.append(Bræt1(length - 2, 0 + 30));
        return sb.toString();
    }

    public static String Stolpe(double size, int xPos, int yPos) {
        String res = "<rect x='" + xPos + "' y='" + 1 + "' width='" + size + "' height='" + (yPos - 30) + "'"
                + "style=\"stroke: #000000; fill:#ffd000\" fill-opacity=\"0.2\"/>";
        res += "<text x='" + (xPos + size / 2) + "' y='" + (yPos - 10) + "' "
                + "font-family=\"Verdana\" font-size=\"30px\""
                + "text-anchor=\"middle\" alignment-baseline=\"middle\">"
                + size / 100 + "m" + "</text>\n";
        return res;
    }

    public static String Bræt1(double xPos, int yPos) {
        String res = "<Line x1='" + 0 + "' y1='" + yPos + "' x2='" + xPos + "' y2='" + yPos + "'"
                + "style=\"stroke: #000000; fill:#ffd000\" fill-opacity=\"0.2\"/>";
        return res;
    }
}
