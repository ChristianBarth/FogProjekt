package FunctionLayer;

import java.sql.Date;

/**
 * @author PC
 */
public class Order {
    
    private int ordernumber;
    private String email;
    private String phonenumber;
    private Date time;
    private String status;
    private int totalprice;

    public Order(int ordernumber, String email, String phonenumber, Date time, String status) {
        this.ordernumber = ordernumber;
        this.email = email;
        this.phonenumber = phonenumber;
        this.time = time;
        this.status = status;
    }

    public Order(int ordernumber, String email, String phonenumber, Date time, String status, int totalprice) {
        this.ordernumber = ordernumber;
        this.email = email;
        this.phonenumber = phonenumber;
        this.time = time;
        this.status = status;
        this.totalprice = totalprice;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }
    
}
