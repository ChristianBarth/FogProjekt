package FunctionLayer;

/**
 * @author PC
 */
public class Order {
    
    private int ordernumber;
    private int customerid;

    public Order(int ordernumber, int customerid) {
        this.ordernumber = ordernumber;
        this.customerid = customerid;
    }

    public int getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(int ordernumber) {
        this.ordernumber = ordernumber;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }
    
    
}
