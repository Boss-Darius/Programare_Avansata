package com.example.lab9.compulsory.repositories;


import com.example.lab9.compulsory.models.AbstractEntity;
import jakarta.persistence.EntityManager;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractRepo <T extends AbstractEntity,ID extends Serializable> {
    private EntityManager em;

    public AbstractRepo(EntityManager em) {
        this.em = em;
    }

    public T findById(ID id) {
        return (T) em.find(AbstractEntity.class, id);
    }

    public T findByName(String name) {
        return (T) em.createNamedQuery(getEntityClass().getSimpleName() +".findByName")
                .setParameter(1, name)
                .getSingleResult();
    }

    public List<T> findAll() {
        return (List<T>) em.createNamedQuery(getEntityClass().getSimpleName() +".findAll")
                .getResultList();
    }

    public void create(T entity) {
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
            em.getTransaction().rollback();
        }
    }

    protected EntityManager getEntityManager() {
        return em;
    }

    protected abstract Class<T> getEntityClass();

}
