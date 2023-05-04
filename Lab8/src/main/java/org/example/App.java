package org.example;

import org.example.Compulsory.Database;
import org.example.DAO.AlbumDAO;
import org.example.DAO.ArtistDAO;
import org.example.DAO.GenreDAO;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String args[]) {
        try {
            var artists = new ArtistDAO();
            artists.create(1,"Pink Floyd");
            artists.create(2,"Michael Jackson");
            var genres = new GenreDAO();
            genres.create(1,"Rock");
            genres.create(2,"Country");
            Database.getConnection().commit();
            var albums = new AlbumDAO();
            albums.create(1979, "The Wall", "Pink Floyd", "Rock");

            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }

}
