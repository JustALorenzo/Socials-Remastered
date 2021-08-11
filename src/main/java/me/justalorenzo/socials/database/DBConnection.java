package me.justalorenzo.socials.database;

import com.google.inject.Inject;
import me.justalorenzo.socials.Socials;
import org.bukkit.configuration.file.FileConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {

    private static Connection connection;
    private static String driver = "com.mysql.cj.jdbc.Driver";
    Socials plugin;
    FileConfiguration config;

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


    public Connection getConnection() throws Exception {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(getUrl(), getUsername(), getPassword());
            plugin.getLogger().info("Connection to DB established");
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

