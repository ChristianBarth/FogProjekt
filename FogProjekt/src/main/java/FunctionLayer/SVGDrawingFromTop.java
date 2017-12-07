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
        sb.append(RemmeOgSpærLayer(length, (double) width));
        sb.append(StolpeLayer(length, (double) width));
        sb.append(HulbåndLayer(length, (double) width));
        return sb.toString();
    }

    public static String BuildTopCarportWithSkur(double length, int width) {
        StringBuilder sb = new StringBuilder();
        sb.append(RemmeOgSpærLayer(length, (double) width));
        sb.append(StolpeLayer(length, (double) width));
        sb.append(HulbåndLayerMedSkur(length, (double) width));
        sb.append(SkurLayer(length, (double) width));
        sb.append(SkurStolpeLayer(length, (double) width));
        return sb.toString();
    }

    private static String RemmeOgSpærLayer(double length, double yPos) {
        return putRemmeOgSpær(length, 0, yPos);
    }

    private static String StolpeLayer(double length, double yPos) {
        return putStolper(length, yPos);
    }

    private static String HulbåndLayer(double length, double yPos) {
        return putHulbånd(length, yPos);
    }
    
    private static String HulbåndLayerMedSkur(double length, double yPos) {
        return putHulbånd(length - 110, yPos);
    }

    private static String SkurLayer(double length, double yPos){
        return putSkur(length, yPos);
    }
    
    private static String SkurStolpeLayer(double length, double yPos){
        return putStolperToSkur(length, yPos);
    }
    
    
    
    public static String putRemmeOgSpær(double length, int xPos, double yPos) {

        StringBuilder sb = new StringBuilder();
        double inBetweenSpær = SVGDrawingFromTop.calculateInBetweenSpærFromTop(length);

        // - 2 for den præcise længde på x - aksen. 4,5 er spærets bredde
        sb.append(Remme(length - 2, (yPos - 35)));
        sb.append(Remme(length - 2, (yPos - 35 + 4.50)));
        sb.append(Remme(length - 2, 0 + 35));
        sb.append(Remme(length - 2, 0 + 35 + 4.50));

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

    public static String putStolper(double length, double yPos) {

        StringBuilder sb = new StringBuilder();
        double inBetweenStolper = SVGDrawingFromTop.calculateInBetweenStolperFromTop(length);

        // 7 for den præcise længde på x - aksen.
        sb.append(StolperSeenFromTop(7, 35 - 2.25));
        sb.append(StolperSeenFromTop(7, 0 + yPos - 35 - 2.25));
        sb.append(StolperSeenFromTop(length - 7, yPos - 35 - 2.25));
        sb.append(StolperSeenFromTop(length - 7, 35 - 2.25));

        while (length >= inBetweenStolper) {
            sb.append(StolperSeenFromTop(inBetweenStolper, yPos - 35 - 2.25));
            sb.append(StolperSeenFromTop(inBetweenStolper, 35 - 2.25));
            length = length - inBetweenStolper;
            inBetweenStolper += inBetweenStolper;
        }

        return sb.toString();

    }
    
    public static String putStolperToSkur(double length, double yPos) {
        StringBuilder sb = new StringBuilder();
        
      
        
         sb.append(StolperSeenFromTop(length - 110, 35 - 2.25));
         sb.append(StolperSeenFromTop(length - 110, yPos - 35 - 2.25));
         sb.append(StolperSeenFromTop(length - 110, (yPos / 2)));
         sb.append(StolperSeenFromTop(length - 5, (yPos / 2)));
        return sb.toString();
    }
    
    private static String putSkur(double length, double yPos) {
        StringBuilder sb = new StringBuilder(); 
       
        length = length - 110;
        
        sb.append(Skur(length, yPos));
        
        return sb.toString();
    }

    public static double calculateInBetweenStolperFromTop(double length) {

        double amountofStolperDouble = Math.ceil(length / 310);
        int amountofStolperInt = (int) amountofStolperDouble;
        int lengthInBetween = (int) length / amountofStolperInt;
        return lengthInBetween;

    }

    public static String putHulbånd(double length, double yPos) {

        StringBuilder sb = new StringBuilder();

        sb.append(hulbånd1(length, yPos));
        sb.append(hulbånd2(length, yPos));

        return sb.toString();
    }

    public static String Spær(double length, int xPos, int yPos) {
        String res = "<rect x='" + xPos + "' y='" + 1 + "' width='" + length + "' height='" + yPos + "'"
                + "style=\"stroke: #000000; fill:#ffd000\" fill-opacity=\"0.2\"/>";
        res += "<text x='" + (xPos + length / 2) + "' y='" + (yPos - 10) + "' "
                + "font-family=\"Verdana\" font-size=\"15px\""
                + "text-anchor=\"middle\" alignment-baseline=\"middle\">"
                + length / 100 + "m" + "</text>\n";
        return res;
    }

    public static String Remme(double xPos, double yPos) {
        String res = "<Line x1='" + 0 + "' y1='" + yPos + "' x2='" + xPos + "' y2='" + yPos + "'"
                + "style=\"stroke: #000000; fill:#ffd000\" fill-opacity=\"0.2\"/>";
        return res;
    }

    public static String StolperSeenFromTop(double xPos, double yPos) {
        String res = "<rect x='" + (xPos - 5) + "' y='" + yPos + "' width='" + 9.7 + "' height='" + 9.7 + "'"
                + "style=\"stroke: #000000; fill:#ffd000\" fill-opacity=\"0.2\"/>";
        return res;
    }

    public static String hulbånd1(double xPos, double yPos) {
        String res = "<Line stroke-dasharray=\"5, 10\" x1='" + (xPos * 0.90) + "' y1='" + 35 + "' x2='" + (xPos * 0.10) + "' y2='" + (yPos - 30) + "'"
                + "style=\"stroke: #000000; fill:#ffd000\" fill-opacity=\"0.2\"/>";
        return res;
    }

    public static String hulbånd2(double xPos, double yPos) {
        String res = "<Line stroke-dasharray=\"5, 10\" x1='" + (xPos * 0.10) + "' y1='" + 35 + "' x2='" + (xPos * 0.90) + "' y2='" + (yPos - 30) + "'"
                + "style=\"stroke: #000000; fill:#ffd000\" fill-opacity=\"0.2\"/>";
        return res;
    }
    
     public static String Skur(double size, double yPos) {
        String res = "<rect x='" + size + "' y='" + 37 + "' width='" + 110 + "' height='" + (yPos - 70) + "'"
                + "style=\"stroke: #000000; fill:#ffd000\" fill-opacity=\"0.2\"/>";
        return res;
    }
    
}
