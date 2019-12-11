package com.db.model;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "server")
public class User {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
