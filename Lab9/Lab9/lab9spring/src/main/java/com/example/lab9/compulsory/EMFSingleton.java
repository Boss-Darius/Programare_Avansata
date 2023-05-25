package com.example.lab9.compulsory;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public enum EMFSingleton {
	 INSTANCE;

	EntityManagerFactory emf;

	public EntityManagerFactory getInstance() {
		if (emf==null){
			emf = Persistence.createEntityManagerFactory("DefaultPU");}

		return emf;
	}

}