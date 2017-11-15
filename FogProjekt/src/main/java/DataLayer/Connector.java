package DataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author PC
 */
public class Connector {
    
    private static final String url = "jdbc:mysql://146.185.139.173:3306/jfog";
    private static final String username = "HawkDon";
    private static final String password = "Hawk@Don11";

    private static Connection singleton;

    public static Connection connection() throws ClassNotFoundException, SQLException  {
        if ( singleton == null ) {
            Class.forName( "com.mysql.jdbc.Driver" );
            singleton = DriverManager.getConnection( url, username, password );
        }
        return singleton;
    }
}
