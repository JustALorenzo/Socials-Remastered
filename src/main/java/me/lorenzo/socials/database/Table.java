package me.justalorenzo.socials.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Table {
    Connection connection;

    public Table(Connection connection) {
        this.connection = connection;
    }

    public void createTable() {
        try {
            PreparedStatement creation = connection.prepareStatement("CREATE TABLE IF NOT EXISTS " +
                    "socials(id int NOT NULL AUTO_INCREMENT, platform varchar(255), link varchar(255), customhead varchar(255), PRIMARY KEY(id))");
            creation.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





}
