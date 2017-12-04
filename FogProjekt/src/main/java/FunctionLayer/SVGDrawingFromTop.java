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
        sb.append(spærLayer(length, (double) width));
        sb.append(stolperLayer(length, (double) width));
        return sb.toString();
    }

    private static String spærLayer(double length, double yPos) {
        return putSpær(length, 0, yPos);
    }

    private static String stolperLayer(double length, double yPos) {
        return putStolper(length, 0, yPos);
    }

    public static String putSpær(double length, int xPos, double yPos) {

        StringBuilder sb = new StringBuilder();
        double inBetweenSpær = SVGDrawingFromTop.calculateInBetweenSpærFromTop(length);

        sb.append(Remme(length, (yPos - 35)));
        sb.append(Remme(length, (yPos - 35 + 4.50)));
        sb.append(Remme(length, 0 + 35));
        sb.append(Remme(length, 0 + 35 + 4.50));

        while (length >= inBetweenSpær) { // Place all the spær
            sb.append(Spær(inBetweenSpær, xPos, (int) yPos));
            length = length - inBetweenSpær;
            xPos += inBetweenSpær;
        }

        return sb.toString();
    }

    public static double calculateInBetweenSpærFromTop(double length) {

        double amountofStolperDouble = Math.ceil(length / 60);
        int amountofStolperInt = (int) amountofStolperDouble;
        int lengthInBetween = (int) length / amountofStolperInt;
        return lengthInBetween;

    }

    public static String putStolper(double length, int xPos, double yPos) {

        StringBuilder sb = new StringBuilder();
        double inBetweenStolper = SVGDrawingFromTop.calculateInBetweenStolperFromTop(length);

        sb.append(StolperSeenFromTopEnd(0, 35 - 2.25));
        sb.append(StolperSeenFromTopEnd(0, 0 + yPos - 35 - 2.25));
        sb.append(StolperSeenFromTopEnd(length - 6.25, yPos - 35 - 2.25));
        sb.append(StolperSeenFromTopEnd(length - 6.25, 35 - 2.25));

        while (length >= inBetweenStolper) {
            sb.append(StolperSeenFromTop(inBetweenStolper, yPos - 35 - 2.25));
            sb.append(StolperSeenFromTop(inBetweenStolper, 35 - 2.25));
            length = length - inBetweenStolper;
            inBetweenStolper += inBetweenStolper;
        }

        return sb.toString();

    }

    public static double calculateInBetweenStolperFromTop(double length) {

        double amountofStolperDouble = Math.ceil(length / 310);
        int amountofStolperInt = (int) amountofStolperDouble;
        int lengthInBetween = (int) length / amountofStolperInt;
        return lengthInBetween;

    }

    public static String Spær(double size, int xPos, int yPos) {
        String res = "<rect x='" + xPos + "' y='" + 1 + "' width='" + size + "' height='" + yPos + "'"
                + "style=\"stroke: #000000; fill:#ffd000\" fill-opacity=\"0.2\"/>";
        res += "<text x='" + (xPos + size / 2) + "' y='" + (yPos - 10) + "' "
                + "font-family=\"Verdana\" font-size=\"15px\""
                + "text-anchor=\"middle\" alignment-baseline=\"middle\">"
                + size / 100 + "m" + "</text>\n";
        return res;
    }

    public static String Remme(double size, double yPos) {
        String res = "<Line x1='" + 0 + "' y1='" + yPos + "' x2='" + size + "' y2='" + yPos + "'"
                + "style=\"stroke: #000000; fill:#ffd000\" fill-opacity=\"0.2\"/>";
        return res;
    }

    public static String StolperSeenFromTop(double xPos, double yPos) {
        String res = "<rect x='" + xPos + "' y='" + yPos + "' width='" + 9.7 + "' height='" + 9.7 + "'"
                + "style=\"stroke: #000000; fill:#ffd000\" fill-opacity=\"0.2\"/>";
        return res;
    }

    public static String StolperSeenFromTopEnd(double xPos, double yPos) {
        String res = "<rect x='" + xPos + "' y='" + yPos + "' width='" + 4.85 + "' height='" + 9.7 + "'"
                + "style=\"stroke: #000000; fill:#ffd000\" fill-opacity=\"0.2\"/>";
        return res;
    }
}
