
package FunctionLayer;


public class WoodAndRoof {
    private String name;
    private int length;
    private int amount;
    private String unit;
    private String description;
    
    public WoodAndRoof(String name, int length, int amount, String unit, String description){
        this.name = name;
        this.length = length;
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

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
