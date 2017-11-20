package FunctionLayer;

/**
 * @author PC
 */
public class User {
    
    private int id; // Not really used in the constructor. Maybe for later
    private String email;
    private String password;
    private String role;

    public User() {
    }
    
    public User(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
}
