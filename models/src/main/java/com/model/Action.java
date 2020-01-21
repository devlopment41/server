package com.model;

import javax.persistence.*;

@Entity
@Table(name = "action", schema = "server")
@Inheritance(strategy=InheritanceType.JOINED)
public class Action extends DBObject {

    @GeneratedValue
    @Column(name = "object_class")
    private String object_class;
    @GeneratedValue
    @Column(name = "object_id")
    private int object_id;
    @GeneratedValue
    @Column(name = "user_id")
    private int user_id;

    public String getObject_class() {
        return object_class;
    }

    public void setObject_class(String object_class) {
        this.object_class = object_class;
    }

    public int getObject_id() {
        return object_id;
    }

    public void setObject_id(int object_id) {
        this.object_id = object_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
