package org.example.DAO;

import org.example.Compulsory.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AssotationDAO {
    public String findByAlbumId(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from association where id_a='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

    public String findByGenreId(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from association where id_g='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
}
