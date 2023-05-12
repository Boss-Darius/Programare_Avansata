package com.example.lab9.compulsory.models;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "genres")
@NamedQueries({
		@NamedQuery(name = "Genres.findAll",
				query = "select e from Genres e order by e.name"),
		@NamedQuery(name = "Genres.findByName",
				query = "select e from Genres e where e.name = :name")
})
public class Genre implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	public Genre() {
	}

	public Genre(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Genre{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}