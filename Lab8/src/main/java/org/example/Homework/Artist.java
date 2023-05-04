package org.example.Homework;

import printsqlexception.PrintSqlException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Artist extends Entity {
    int id;
    private String name;

    public Artist(int id, String name) {
        super(id);
        this.name = name;
    }

    public Artist(String name) {
        super(0);
        this.name = name;
    }
    public Artist() {
        super(0);
    }

    public String getName() {
        return name;
    }

    @Override
    public String getTable() {
        return "artists";
    }

    @Override
    public String getTableColsForInsert() {
        return "(name)";
    }


    public String getTableParametersForInsert() {
        return "(?)";
    }


    public void populateInsertPSTMT(PreparedStatement pstmt) throws SQLException {
        pstmt.setString(1, name);
    }


    public Entity createInstance(ResultSet resultSet) {
        if (resultSet == null)
            return null;
        try {
            Artist artist = new Artist(resultSet.getInt("id"), resultSet.getString("name"));
            return artist;
        } catch (SQLException e) {
            PrintSqlException.print(e);
        }
        return null;
    }
}
