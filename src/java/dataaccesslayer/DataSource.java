package dataaccesslayer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import transferobjects.CredentialsDTO;

/**
 *
 * The DataSource class provides a connection to a MySQL database for a Java
 * application. It reads the database connection parameters from a configuration
 * file and creates a single connection to the database. The class uses the JDBC
 * driver to connect to the database and the CredentialsDTO object to obtain the
 * username and password.
 *
 * Assignment 2 Class: CST8288 - Lab Section: 013
 *
 * Lab Professor: Siju Philip
 *
 * Date: Mar. 30, 2023
 *
 * @author Mutao Yin
 * @version 1.0
 */
public class DataSource {
// Instance variables

    private Connection connection = null;
    private String url = "jdbc:mysql://localhost:3306/tutoring?useSSL=false";
    private String username = "CST8288";
    private String password = "CST8288";

    /**
     * Constructs a DataSource object with the given credentials.
     *
     * @param creds the CredentialsDTO object containing the username and
     * password
     */
    public DataSource(CredentialsDTO creds) {
    }

    /**
     * Creates a new database connection or returns an existing one.
     *
     * @return a Connection object representing the database connection
     * @throws ClassNotFoundException if the JDBC driver is not found
     */
    public Connection createConnection() throws ClassNotFoundException {
        try {
            if (connection != null) {
                System.out.println("Cannot create new connection, one exists already");
            } else {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
