package FunctionLayer;

/**
 * @author PC
 */
public class Order {
    
    private int ordernumber;
    private String email;

    public Order(int ordernumber, String email) {
        this.ordernumber = ordernumber;
        this.email = email;
    }

    public int getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(int ordernumber) {
        this.ordernumber = ordernumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
