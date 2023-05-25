package com.example.lab9.compulsory;

import com.example.lab9.compulsory.models.Artist;
import com.example.lab9.compulsory.repositories.ArtistRepository;
import jakarta.persistence.EntityManager;


//spring boot
public class API {
    public static void testJPA1() {

        EntityManager em = EMFSingleton.INSTANCE.getInstance().createEntityManager();

        em.getTransaction().begin();
        Artist artist = new Artist("Beatles");
        em.persist(artist);

        Artist a = (Artist) em.createQuery("select e from Artist e where e.name='Beatles'")
                .getSingleResult();

        a.setName("The Beatles");
        em.getTransaction().commit();

        System.out.println(a);

        em.close();
        EMFSingleton.INSTANCE.getInstance().close();
    }

    public static void testJPA2() {

        var artistRepo = new ArtistRepository(EMFSingleton.INSTANCE.getInstance().createEntityManager());

        artistRepo.create(new Artist("Beatles"));
        artistRepo.create(new Artist("Artist1"));
        artistRepo.create(new Artist("Artist2"));
        artistRepo.create(new Artist("Artist3"));


        System.out.println(artistRepo.findByName("Artist2"));
        System.out.println(artistRepo.findById(2));
        EMFSingleton.INSTANCE.getInstance().close();
    }

}
