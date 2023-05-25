package com.example.lab9.compulsory.models;

import jakarta.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "artists")
@NamedQueries({
		@NamedQuery(name = "Artist.findAll",
				query = "select e from Artist e order by e.name"),
})
public class Artist implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	public Artist() {
	}

	public Artist(String name) {
//		this.id = 0;
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
		return "Artist{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}