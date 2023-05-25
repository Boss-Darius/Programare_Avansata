package com.example.lab9.compulsory.models;


import jakarta.persistence.*;

@Table(name = "albums")
@NamedQueries({
        @NamedQuery(name = "Album.findAll",
                query = "select e from Album e order by e.title"),
        @NamedQuery(name = "Album.findByArtist",
                query = "select e from Album e where e.artist = ?1"),
        @NamedQuery(name = "Album.findById",
                query = "select e from Album e where e.id = ?1"),
})
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @JoinColumn(name = "artist")
    @ManyToOne
    private Artist artist;

    @Column(name = "release_year")
    private Integer release_year;

    @JoinColumn(name = "genre")
    @ManyToMany
    private Genre genre;

    public Album() {
    }

    public Album(String name, Artist artist, Integer release_year, Genre genre) {
        this.name = name;
        this.artist = artist;
        this.release_year = release_year;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Integer getRelease_year() {
        return release_year;
    }

    public void setRelease_year(Integer release_year) {
        this.release_year = release_year;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artist=" + artist +
                ", release_year=" + release_year +
                ", genre =" + genre +
                '}';
    }
}
