package org.example.Homework;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

abstract public class Entity {

    private int id;

    public Entity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public abstract String getTable();

    public abstract String getTableColsForInsert();

    public abstract String getTableParametersForInsert();

    public abstract void populateInsertPSTMT(PreparedStatement pstmt) throws SQLException;

    public abstract Entity createInstance(ResultSet resultSet);
}
