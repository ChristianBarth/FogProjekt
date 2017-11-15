package FunctionLayer;

/**
 * @author PC
 */
public class FittingAndScrews {
    
    private String name;
    private int amount;
    private String unit;
    private String description;

    public FittingAndScrews(String name, int amount, String unit, String description) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
        this.description = description;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
