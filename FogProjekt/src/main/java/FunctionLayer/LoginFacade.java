package FunctionLayer;

import DataLayer.UserMapper;

/**
 * @author PC
 */
public class LoginFacade {

    public static User login(String email, String password) {
        return UserMapper.login(email, password);
    }
    // We only create users as customers. Employees has to manually edit in the database.
    public static User createUser(String email, String password){
        User user = new User(email, password, "customer");
        UserMapper.createUser(user);
        return user;
    }
}
