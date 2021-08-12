package me.justalorenzo.socials.database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DataHandler {

    Connection connection;

    public DataHandler(Connection connection) {
        this.connection = connection;
    }


    public void insertData(String[] args) {

        String platform = args[0];
        String link = args[1];

        try {
            PreparedStatement data = connection.prepareStatement("INSERT INTO socials (platform, link, customhead) VALUES ('" + platform + "', '" + link + "', 'eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTY3ZDgxM2FlN2ZmZTViZTk1MWE0ZjQxZjJhYTYxOWE1ZTM4OTRlODVlYTVkNDk4NmY4NDk0OWM2M2Q3NjcyZSJ9fX0=')");
            data.executeUpdate();
        } catch (Exception e) {
    e.printStackTrace();
        }
    }

}
