package FunctionLayer;

/**
 * @author PC
 */
public class Product {


    private int id;
    private String name;
    private int length;
    private int width;
    private int amount;
    private String unit;
    private String description;
    private int price;

    // Entity til alle produkter i databasen.
    public Product(String name, int length, String unit, String description, int price) {
        this.name = name;
        this.length = length;
        this.unit = unit;
        this.description = description;
        this.price = price;
    }
    // Entity til at regne antallet ud med i lommeregneren
    public Product(String name, int length, int amount, String unit, String description, int price) {
        this.name = name;
        this.length = length;
        this.amount = amount;
        this.unit = unit;
        this.description = description;
        this.price = price;
    }
    
    // Entity til at hente produkter op af databasen.
    public Product(int id, String name, int length, int amount, String unit, String description, int price) {
        this.id = id;
        this.name = name;
        this.length = length;
        this.amount = amount;
        this.unit = unit;
        this.description = description;
        this.price = price;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
