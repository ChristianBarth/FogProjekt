package FunctionLayer;

/**
 * @author PC
 */
public class Order {
    
    private int ordernumber;
    private String email;
    private String phonenumber;

    public Order(int ordernumber, String email, String phonenumber) {
        this.ordernumber = ordernumber;
        this.email = email;
        this.phonenumber = phonenumber;
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

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    
    
}
