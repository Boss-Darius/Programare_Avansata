package org.example.Homework;

import printsqlexception.PrintSqlException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Genre extends Entity{

    int id;
    private String name;

    public Genre(int id, String name) {
        super(id);
        this.name = name;
    }

    public Genre(String name) {
        super(0);
        this.name = name;
    }
    public Genre() {
        super(0);
    }

    public String getName() {
        return name;
    }

    @Override
    public String getTable() {
        return "albums";
    }

    @Override
    public String getTableColsForInsert() {
        return "(name)";
    }

    @Override
    public String getTableParametersForInsert() {
        return "(?)";
    }

    @Override
    public void populateInsertPSTMT(PreparedStatement pstmt) throws SQLException {
        pstmt.setString(1, name);
    }

    @Override
    public Entity createInstance(ResultSet resultSet) {
        if (resultSet == null)
            return null;
        try {
            return new Artist(resultSet.getInt("id"), resultSet.getString("name"));
        } catch (SQLException e) {
            PrintSqlException.print(e);
        }
        return null;
    }

}
