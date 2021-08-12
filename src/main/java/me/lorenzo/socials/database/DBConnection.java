package me.justalorenzo.socials.database;

import com.google.inject.Inject;
import me.justalorenzo.socials.Socials;
import org.bukkit.configuration.file.FileConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {

    public static Connection connection;
    private static String driver = "com.mysql.cj.jdbc.Driver";
    Socials plugin;
    FileConfiguration config;
    Table table;
    DataHandler dataHandler;
    final String databasePath = "database.";

    //database variables
    String username = "";
    String password = "";
    String host = "";
    String port = "";
    String databaseName = "";
    String url = "";

    @Inject
    public DBConnection(Socials plugin) throws ClassNotFoundException {

        this.plugin = plugin;
        config = this.plugin.getConfig();
        setupDatabaseVariables();
    }


    void setupDatabaseVariables() {
        username = config.getString(databasePath + "user");
        password = config.getString(databasePath + "password");
        host = config.getString(databasePath + "host");
        port = config.getString(databasePath + "port");
        databaseName = config.getString(databasePath + "databasename");
        url = "jdbc:mysql://" + host + ":" + port + "/" + databaseName;

    }


    public Connection getConnection()  {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(getUrl(), getUsername(), getPassword());
            plugin.getLogger().info("Connection to DB established");
            table = new Table(connection);
            table.createTable();
            plugin.getLogger().info("Tables created if they weren't before");
            dataHandler = new DataHandler();
           // dataHandler.insertData(new String[]{"youtube","https://youtube.com/pewdiepie"});
            plugin.getLogger().info("Inserted basic values into DB!");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


}

