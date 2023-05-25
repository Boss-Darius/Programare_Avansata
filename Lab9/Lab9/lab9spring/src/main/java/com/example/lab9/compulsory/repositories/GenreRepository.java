package com.example.lab9.compulsory.repositories;

import com.example.lab9.compulsory.models.Genre;
import jakarta.persistence.EntityManager;

public class GenreRepository {
	private final EntityManager em;

	public GenreRepository(EntityManager em) {
		this.em = em;
	}

	public void create(Genre genre) {
		em.getTransaction().begin();
		em.persist(genre);
		em.getTransaction().commit();
	}

	public Genre findById(int id) {
		return em.find(Genre.class, id);
	}

	public Genre findByName(String name) {
		return em.createNamedQuery("Genre.findByName", Genre.class)
				.setParameter("name", name)
				.getSingleResult();
	}
}
