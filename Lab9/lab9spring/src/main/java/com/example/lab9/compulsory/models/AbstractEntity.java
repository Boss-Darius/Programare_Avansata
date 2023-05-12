package com.example.lab9.compulsory.models;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEntity {
    private long id;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}


