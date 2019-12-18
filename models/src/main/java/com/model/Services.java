package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "services", schema = "server")

public class Services extends DBObject {

    @GeneratedValue
    @Column(name = "name")
    private String name;
    @GeneratedValue
    @Column(name = "phone")
    private int phone;
    @GeneratedValue
    @Column(name = "issue")
    private String issue;
    @GeneratedValue
    @Column(name = "address")
    private String address;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
