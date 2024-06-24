package Modelo;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
 *
 * @author Ambar
 */
public class DatabaseConnector {
    //Variables estaticas de conexion
    private static final String PROPERTIES_FILE = "db.properties";
    private String url;
    private String username;
    private String password;
    private String driverClassName;

    //constructor de clase
    public DatabaseConnector() {
        try {
            loadProperties();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load database properties", e);
        }
    }

    //Conector
    private void loadProperties() throws IOException, ClassNotFoundException {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (input == null) {
                throw new IOException("Unable to find " + PROPERTIES_FILE);
            }
            properties.load(input);

            url = properties.getProperty("jdbc.url");
            username = properties.getProperty("jdbc.username");
            password = properties.getProperty("jdbc.password");
            driverClassName = properties.getProperty("jdbc.driverClassName");

            Class.forName(driverClassName);
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    //Metodo ejecutable
    public void conectarBase() {
        DatabaseConnector connector = new DatabaseConnector();
        try (Connection connection = connector.getConnection()) {
            System.out.println("Conectado a la Base");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}