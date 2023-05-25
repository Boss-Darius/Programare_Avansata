package com.example.lab9.compulsory.repositories;

import com.example.lab9.compulsory.models.Artist;
import jakarta.persistence.EntityManager;

public class ArtistRepository {
	private final EntityManager em;

	public ArtistRepository(EntityManager em) {
		this.em = em;
	}

	public void create(Artist artist) {
		em.getTransaction().begin();
		em.persist(artist);
		em.getTransaction().commit();
	}

	public Artist findById(int id) {
		return em.find(Artist.class, id);
	}

	public Artist findByName(String name) {
		return em.createNamedQuery("Artist.findByName", Artist.class)
				.setParameter("name", name)
				.getSingleResult();
	}
}
