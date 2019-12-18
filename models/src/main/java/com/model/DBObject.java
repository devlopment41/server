package com.model;

import javax.persistence.*;

@MappedSuperclass
public class DBObject {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
