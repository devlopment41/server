package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "account", schema = "server")
public class Account extends DBObject {

    @GeneratedValue
    @Column(name = "name")
    private  String name;
    @GeneratedValue
    @Column(name = "company")
    private  String company;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

}
