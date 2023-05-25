package com.example.lab9.compulsory.repositories;

import com.example.lab9.compulsory.models.Album;
import com.example.lab9.compulsory.models.Artist;
import jakarta.persistence.EntityManager;

import java.util.List;

public class AlbumRepository {
	private EntityManager em;

	public AlbumRepository(EntityManager em) {
		this.em = em;
	}

	public void create(Album album){
		em.getTransaction().begin();
		em.persist(album);
		em.getTransaction().commit();
	}

	public Album findById(int id){
		return em.find(Album.class, id);
	}

	public Album findByName(String name) {
		return em.createNamedQuery("Album.findByName", Album.class)
				.setParameter("name", name)
				.getSingleResult();
	}

	public List<Album> findByArtist(Artist artist) {
		return (List<Album>) em.createNamedQuery("Album.findByArtist")
				.setParameter("artist", artist)
				.getResultList();

	}
}