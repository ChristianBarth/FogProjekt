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

    public static String BuildSideCarportWithSkur(double length, int height) {
        StringBuilder sb = new StringBuilder();
        sb.append(StolpeLayer(length, height));
        sb.append(BrætLayer(length, height));
        sb.append(SkurLayer(length, height));
        sb.append(SkurBrædderLayer(length,height));
        return sb.toString();
    }

    private static String StolpeLayer(double length, int yPos) {
        return putStolper(length, 0, yPos);
    }

    private static String BrætLayer(double length, int yPos) {
        return putBræt(length, 0, yPos);
    }

    private static String SkurLayer(double length, int yPos) {
        return putSkur(110, (int) (length - 110), yPos);
    }
    
    public static String SkurBrædderLayer(double length, int yPos) {
        return putSkurBrædder(length, yPos);
    }

    public static String putStolper(double length, int xPos, int yPos) {

        StringBuilder sb = new StringBuilder();
        double inBetweenStolper = SVGDrawingFromSide.calculateInBetweenSide(length);

        // Place all stolper
        while (length >= inBetweenStolper) {
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
        sb.append(Bræt(length - 2, 0 + 20));
        sb.append(Bræt(length - 2, 0 + 30));
        return sb.toString();
    }

    public static String putSkur(double length, int xPos, int yPos) {
        StringBuilder sb = new StringBuilder();

        sb.append(Skur(length, xPos, yPos));
        return sb.toString();
    }
    
    public static String putSkurBrædder(double length, int yPos) {
        StringBuilder sb = new StringBuilder();
        double skurPos = length - 110;
        double BrætLength = 1.9;
        
        while (skurPos <= length ){
            sb.append(Skurbræt(skurPos, yPos));
            
            skurPos = skurPos + BrætLength;
            }
        
        return sb.toString();
    }

    public static String Stolpe(double size, int xPos, int yPos) {
        String res = "<rect x='" + xPos + "' y='" + 1 + "' width='" + size + "' height='" + yPos + "'"
                + "style=\"stroke: #000000; fill:#ffd000\" fill-opacity=\"0.2\"/>";
        res += "<text x='" + (xPos + size / 2) + "' y='" + (yPos - 10) + "' "
                + "font-family=\"Verdana\" font-size=\"20px\""
                + "text-anchor=\"middle\" alignment-baseline=\"middle\">"
                + size / 100 + "m" + "</text>\n";
        return res;
    }

    public static String Bræt(double xPos, int yPos) {
        String res = "<Line x1='" + 0 + "' y1='" + yPos + "' x2='" + xPos + "' y2='" + yPos + "'"
                + "style=\"stroke: #000000; fill:#ffd000\" fill-opacity=\"0.2\"/>";
        return res;
    }

    public static String Skur(double size, int xPos, int yPos) {
        String res = "<rect x='" + xPos + "' y='" + 31 + "' width='" + size + "' height='" + (yPos - 30) + "'"
                + "style=\"stroke: #000000; fill:#ffd000\" fill-opacity=\"0.2\"/>";
        res += "<text x='" + (xPos + size / 2) + "' y='" + (yPos - 10) + "' "
                + "font-family=\"Verdana\" font-size=\"20px\""
                + "text-anchor=\"middle\" alignment-baseline=\"middle\">"
                + size / 100 + "m" + "</text>\n";
        return res;
    }
    
    public static String Skurbræt(double size, int yPos){
        String res = "<Line x1='" + size + "' y1='" + 31 + "' x2='" + size + "' y2='" + yPos +"'"
                  + "style=\"stroke: #000000; fill:#ffd000\" fill-opacity=\"0.2\"/>";
        return res;
    }

}
