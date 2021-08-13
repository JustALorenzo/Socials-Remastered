package me.justalorenzo.socials.database;

import me.justalorenzo.heads.HeadsAPI;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataHandler {

    public void insertData(String[] args) {

        String platform = args[0];
        String link = args[1];
        String base64;
        try {
            base64 = HeadsAPI.getHead(args[2], true);
            System.out.println("inserting: " + platform + " " + link + " " + base64);
            PreparedStatement data = DBConnection.connection.prepareStatement("INSERT INTO socials (platform, link, customhead) VALUES ('" + platform + "', '" + link + "', '" + base64 + "')");
            data.executeUpdate();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

}
