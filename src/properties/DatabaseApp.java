package properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DatabaseApp {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("src/properties/database.properties");
        Properties properties = new Properties();
        properties.load(fis); //load all the properties from properties file and store as a map
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver"); // this key we do not have
        System.out.println("UserName : "+username);
        System.out.println("Password : "+password);
        System.out.println("Driver : "+ driver); // when we do not have the key name then we get value as null
        fis.close();
    }
}
